/**
 * 
 */

var ColorEditor = function() {
	/**
	 * 인스턴스 출력을 위한 객체
	 */
	var _object = {};


	/**
	 * ColorScripter 인스턴스
	 */
	var colorScripter;


	/**
	 * ColorEditor의 DOM 오브젝트
	 *
	 * :: <div class="ColorEditor">
	 */
	var ceDOM;


	/**
	 * hook-functions를 저장해주는 dict
	 *
	 * codeTextCompose(keyEvent): 초,중,종성 입력시
	 * keyDown(keyEvent): 키가 눌렸을 때 (before proccessing)
	 * keyUp(keyEvent): keyup이후 proccessing전
	 * codeChanging(html, codeTextDOM): 막 하이라이팅 및 포커싱을 할 때, 리턴값이 있으면 해당 리턴값으로 에디터 노드가 변경됨
	 * codeChanged(html, codeTextDom): 하이라이팅 및 포커스 처리 이후
	 */
	var hooks = {};


	/**
	 * 코드 에디팅 DOM
	 *
	 * :: <pre class="ce-code-text">
	 */
	var codeText;


	/**
	 * 이전의 줄번호 숫자
	 */
	var previousLineNums;

	/**
	 * key-up이 block 되었는지를 나타냄
	 *
	 * 메타키(Ctrl과 같이 누르는 키)는 무시
	 * 한글 중, 종성도 무시
	 */
	var keuUpBlocked = false;


	/**
	 * raw-code
	 * 코드 업데이트마다 갱신시켜준다
	 */
	var rawCodeText = "";


	/**
	 * 브라우저
	 */
	var isWebkit = (navigator.userAgent.indexOf("WebKit") != -1);
	var isFireFox = (navigator.userAgent.indexOf("Firefox") != -1);

	/**
	 * 실시간 하이라이팅이 켜져 있는가
	 */
	var realTimeEnabled;


	/**
 	 * colorscripter sdk js가 로드중인지 체크
	 */
	var colorScripterJSLoadingNow = false;

	/**
	 *  sdk로더 interval
	 */
	var sdkLoaderIntv;

	/**
	 *  sdk로더 요청 횟수
	 */
	var sdkLoadReqTime = 0;


	/**
	 * [ PUBLIC ]
	 * Color Editor init
	 *
	 * @param targetDOM: 에디터가 위치할 DOM-Object
	 * @param language: 하이라이팅할 언어
	 * @param stylePackage: 스타일패키지
	 */
	_object.init = function(targetDOM, language, stylePackage) {
		if (!targetDOM) {
			throw Error("targetDOM is null");
			return;
		}

		if (typeof ColorScripter == "undefined") {
			if (!colorScripterJSLoadingNow) {
				var csjs = document.createElement("script");
				var script1 = document.getElementsByTagName("script")[0];
				csjs.src = "http://api.colorscripter.com/code/colorscripter.js";
				script1.parentNode.insertBefore(csjs, script1);

				colorScripterJSLoadingNow = true;
		   		sdkLoaderIntv = setInterval(function () { _object.init(targetDOM, language, stylePackage) }, 20);
		   	}
		   	return;
		}

		if (++sdkLoadReqTime > 50) {
			alert("Error: cannot load colorscripter sdk file");
			clearInterval(sdkLoaderIntv);
			sdkLoaderIntv = null;
		}

		if (sdkLoaderIntv) {
			clearInterval(sdkLoaderIntv);
			sdkLoaderIntv = null;
		}

		if (isWebkit || isFireFox)
			realTimeEnabled = true;



		if (!language) language = "text";

		colorScripter = new ColorScripter(language);
		if (stylePackage) colorScripter.selectStylePackage(stylePackage);

		var html = '<div class="ColorEditor">\
			<div class="ce-wrap">\
				<div class="ce-linenumber">\
					<ol>\
						<li>1</li>\
					</ol>\
				</div>\
				<div class="ce-text-area"></div>\
			</div>\
		</div>';

		targetDOM.innerHTML = html;
		ceDOM = gebcn(targetDOM, "ColorEditor")[0];

		if (realTimeEnabled)
			_object.enableRealTime(true);
		else
			_object.disableRealTime(true);
		
		_object.updateCode("", true);
		_object.resize();
	};

	/**
	 * [ PUBLIC ]
	 * ColorScripter 인스턴스 반환
	 */
	_object.getColorScripter = function() {
		return colorScripter;
	};

	/**
	 * [ PUBLIC ]
	 * colorEditor DOM 오브젝트 (ceDOM) 반환
	 */
	_object.getEditorDOM = function() {
		return ceDOM;
	};

	/**
	 * [ PUBLIC ]
	 * code-text DOM 오브젝트 반환
	 */
	_object.getCodeTextDOM = function() {
		return codeText;
	};

	/**
	 * [ PUBLIC ]
	 * raw-code-text 반환
	 */
	_object.getRawCodeText = function() {
		return rawCodeText;
	};


	/**
	 * [ PUBLIC ]
	 * 직접 코드를 넣어 업데이트
	 */
	_object.updateCode = function (code, disableFocus) {
		if (code) {
			updateRawCodeText(code);

			code = code.split("\r\n").join("\n");
			code = code.split("&").join("&amp;").split("<").join("&lt;").split(">").join("&gt;");

			if (realTimeEnabled)
				codeText.innerHTML = code;
			else
				codeText.value = code;
		}
		codeChangeHandler(null, disableFocus);
	};

	/**
	 * [ PUBLIC ]
	 * DOM을 resize하고 싶을때, 함수를 실행하여 맞춤
	 */
	_object.resize = function() {
		codeText.style.width = (ceDOM.clientWidth - 51 - 14) + "px";
		codeText.style.height = (ceDOM.clientHeight - 21) + "px";

		if (hooks["resize"]) hooks["resize"](codeText, ceDOM);
	};

	/**
	 * [ PUBLIC ]
	 * 후킹함수 설정
	 */
	_object.setHook = function(type, func) {
		hooks[type] = func;
	};


	/**
	 * [ PUBLIC ]
	 * 실시간 에디터를 활성화 여부 반환
	 */
	_object.getRealTimeEnabled = function() {
		return realTimeEnabled;
	};


	/**
	 * [ PUBLIC ]
	 * 실시간 에디터를 활성화 시킨다
	 */
	_object.enableRealTime = function(forceUpdate) {
		if (realTimeEnabled && !forceUpdate) return;
		realTimeEnabled = true;

		var wrapper = gebcn(ceDOM, "ce-text-area")[0];
		if (codeText) wrapper.removeChild(codeText);

		codeText = document.createElement('pre');
		codeText.setAttribute('class', 'ce-code-text');
		codeText.setAttribute('contenteditable', true);
		codeText.setAttribute('spellcheck', false);
		codeText.innerHTML = '<div></div>';


		codeText.addEventListener("compositionstart", codeTextComposeHandler);
		codeText.addEventListener("compositionupdate", codeTextComposeHandler);
		codeText.addEventListener("compositionend", codeTextComposeHandler);

		codeText.addEventListener("keydown", codeChangePreventHandler);
		codeText.addEventListener("keyup", codeChangeHandler);

		codeText.addEventListener("copy", codeCopyHandler);
		codeText.addEventListener("paste", codePasteHandler);

		wrapper.appendChild(codeText);

		_object.updateCode(rawCodeText);
		_object.resize();
	};


	/**
	 * [ PUBLIC ]
	 * 실시간 에디터를 비활성화한다.
	 */




	/**
	 * getElementsByClassName 와 같음
	 */
	function gebcn(dom, className) {
		if (dom.getElementsByClassName)
			return dom.getElementsByClassName(className);

		else if (dom.querySelectorAll)
			return dom.querySelectorAll("." + className);

		else if (dom.getElementsByTagName) {
			var t = dom.getElementsByTagName("*");
			var n = [];
			for (var i=0; i<t.length; i++){
				var classLists = t[i].className.split(" ");
				if (classLists.indexOf(className) != -1)
					n.push(t[i]);
			}
			return n;
		}
	}


	/**
	 * 한글 키가 조합 될 때 (초성, 종성)
	 */
	function codeTextComposeHandler(e) {
		if (!realTimeEnabled) return;
		if (hooks["codeTextCompose"]) hooks["codeTextCompose"](e);

		if (e.type == "compositionend")
			keuUpBlocked = false;
		else
			keuUpBlocked = true;
	}


	/**
	 * key down시 처리
	 */
	function codeChangePreventHandler(e) {
		if (!realTimeEnabled) return;
		if (hooks["keyDown"]) hooks["keyDown"](e);

		keuUpBlocked = false;
		pastedCode = null;

		if (isFireFox) {
			if (e.metaKey == true && e.key != "v") {
				keuUpBlocked = true;
			}
			if (e.keyCode === 13) {
				// insert \n
				document.execCommand('insertHTML', false, '\n');
				e.preventDefault();
				return false;
			}
		}

		if (e.keyCode === 9) {
			// tab
			document.execCommand('insertHTML', false, '	');
			e.preventDefault();
			return false;
		}

		if (e.key == '&' && realTimeEnabled) {
			document.execCommand('insertHTML', false, '&amp;');
			e.preventDefault();
			return false;
		}

		updateLineNumber();
	}


	function codeCopyHandler(e) {
		if (e && e.clipboardData && e.clipboardData.setData) {
			var start = window.getSelection().getRangeAt(0).startOffset;
			var end = window.getSelection().getRangeAt(0).endOffset;

			e.clipboardData.setData('text/plain', rawCodeText.substring(start, end));
			//e.clipboardData.setData('text/html', codeText.innerHTML.substring(start, end));
			//e.preventDefault();
		}
	}


	/**
	 * 붙여넣기시 처리
	 */
	function codePasteHandler(e) {
		if (hooks["codePasted"]) hooks["codePasted"](e);

		if (e && e.clipboardData && e.clipboardData.getData) {
			if (/text\/plain/.test(e.clipboardData.types)) {
				var pastedCode = e.clipboardData.getData('text/plain');

				//console.log( pastedCode );
				//console.log( e.clipboardData.getData('text/html') );

				//
				// TODO: text/html으로 처리를 해야하나... </div><div>가 씹힘
				//
				//
				//

				pastedCode = pastedCode.split("\r\n").join("\n");
				pastedCode = pastedCode.split("&").join("&amp;").split("<").join("&lt;").split(">").join("&gt;");

				//console.log( pastedCode );

				e.preventDefault();
				document.execCommand("insertHTML", false, pastedCode);
			}
		}
	}


	/**
	 * raw-code 갱신
	 */
	function updateRawCodeText(forcedText) {
		if (forcedText) {
			rawCodeText = forcedText;
			return;
		}

		if (realTimeEnabled) {
			rawCodeText = codeText.innerHTML;

			if (isFireFox && rawCodeText.substr(0, 4) == "<br>") rawCodeText = "\n" + rawCodeText;
			
			rawCodeText = rawCodeText.replace(/<\/div><div[^>]*>/g, "\n").replace(/<[\s\S]*?>/g, "").split("&lt;").join("<").split("&gt;").join(">").split("&nbsp;").join(" ").split("&amp;").join("&");

		}else
			rawCodeText = codeText.value;
	}


	/**
	 * key up시 코드 하이라이팅 처리
	 */
	function codeChangeHandler(e, disableFocus) {
		if (e != null && hooks["keyUp"]) hooks["keyUp"](e);

		var range;
		
		if (realTimeEnabled && disableFocus != true) {
			if (window.getSelection().type == "Range" || keuUpBlocked) return;
			try {
				range = window.getSelection().getRangeAt(0);
			
			}catch (error) {
				//console.dir(error);
				return;
			}
		}


		updateRawCodeText(null);
		
		updateLineNumber();


		if (realTimeEnabled) {		
			//
			// 포커스를 맞추기 위한 트릭 및 하이라이팅 시작
			//
			if (gebcn(document, "focus-caret").length) {
				d = gebcn(document, "focus-caret")[0];
				d.parentNode.removeChild(d);
			}


			var caretSpan = document.createElement("s");
			caretSpan.id = "focus-caret";
			if (range != null) range.insertNode(caretSpan);
			
			var html = codeText.innerHTML.replace(/<\/div><div[^>]*>/g, "\n").replace(/<\/?br[\s\S]*?>/g, "").replace(/<\/?span[\s\S]*?>/g, "").replace(/<\/?font[\s\S]*?>/g, "")
				.replace(/<\/?div[\s\S]*?>/g, "").replace("<i></i>", "").split("&lt;").join("<").split("&gt;").join(">").split("&nbsp;").join(" ").split("&amp;").join("&");


			var x = html.indexOf('<s id="focus-caret"></s>'); //focus-cart의 index를 미리 저장해둠
			var n = 0;

			if (x == -1) {
				caretSpan.remove();
			}
			
			html = colorScripter.color(rawCodeText).split("&nbsp;").join(" "); // 새로 하이라이팅한 코드와 기존 코드를 비교
			
			for (var i=0; i<html.length+1; i++) {
				if (n == x) {	
					html = html.substr(0, i) + "<i></i>" + html.substr(i);
					break;
				}

				if (html[i] == "<") {
					i = html.indexOf(">", i+1);
					continue;

				}else if (html.substr(i, 6) == "&nbsp;")
					i += 5;

				else if (html.substr(i, 5) == "&amp;")
					i += 4;

				else if (html.substr(i, 4) == "&lt;" || html.substr(i, 4) == "&gt;")
					i += 3;

				n++;
			}

			var cht = null;
			if (hooks["codeChanging"])
				cht = hooks["codeChanging"](html, codeText);

			if (cht)
				html = cht;

			else {
				if (html.indexOf("\n") == -1)
					html = "<div>" + html + "</div>";
				else
					html = "<div>" + html.split("\n").join("</div><div>") + "</div>";
			}

			codeText.blur();
			codeText.innerHTML = html;


			if (range != null) codeText.focus();

			var i = codeText.getElementsByTagName("i")[0];
			if (i) {
				var range = document.createRange();
				range.selectNode(i);

				var selection = window.getSelection();
				selection.removeAllRanges();
				selection.addRange(range);
				range.deleteContents();
			}
			//
			// 포커스를 맞추기 위한 트릭 및 하이라이팅 끝
			//
		}

		codeText.style.color = colorScripter.stylePackage.normal;
		ceDOM.style.backgroundColor = (colorScripter.stylePackage.backgroundColor) ? colorScripter.stylePackage.backgroundColor : "";

		if (codeText.tagName != "PRE") {
			//console.log();
			codeText.style.backgroundColor = ceDOM.style.backgroundColor;
		}

		if (hooks["codeChanged"]) hooks["codeChanged"](html, codeText);
	}


	// 줄번호 갱신
	function updateLineNumber() {
		var lineNums = rawCodeText.split("\n").length;

		if (lineNums != previousLineNums) {
			var lnObj = gebcn(ceDOM, "ce-linenumber")[0].getElementsByTagName("ol")[0];
			lnObj.innerHTML = "";
			
			for (var i=0; i<lineNums; i++) {
				var d = document.createElement("li");
				d.innerHTML = i + 1;
				lnObj.appendChild(d);
			}
		}
		return lineNums;
	}

	return _object;
};
