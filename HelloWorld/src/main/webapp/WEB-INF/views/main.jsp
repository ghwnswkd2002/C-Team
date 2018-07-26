<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
   Binary by TEMPLATED
   templated.co @templatedco
   Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>



<!-- <script src="canvas/fabric.min.js"></script>
<script src="canvas/canvas=function.js"></script> -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/util.js"></script>
<script src="js/main.js"></script>
<script src="js/new.js"></script>
<script src="js/coloreditor.js" /></script>
<script src="js/colorscripter.js" /></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>


<script type="text/javascript">

$(function() {
    var textInput = document.getElementById('code');
    var timeCheck = null;

    textInput.onkeyup = function(e) {
       if (e.keyCode >= 37 && e.keyCode <= 40) {
          return;
       }
       clearTimeout(timeCheck);

       timeCheck = setTimeout(previewIt, 1000);
    }
 });



 var isIE = document.all ? true : false;
 var isDOM = document.getElementById ? true : false;

 function previewIt() {
    var _update = document.codeform.code.value;
    console.log(_update);
    var _regExp = /\n/gi;
    if (_update != "") {
       $.ajax({
          type : 'post',
          url : './ajax',
          contentType : "application/text; charset=utf-8",
          data : _update,
          dataType:"json",
          success : function (data) {
              //���⼭ �������� ������ �����ִ� �ؽ����� key 1���� �ϳ��ϳ� �о�鿩
              //key�ȿ� �ִ� value(�ٸ������� hashmap�� key)�� ã�ư�
              var all_data = data;
              var all_line = all_data.keys["allOfLine"];// ���⿡ java���� ������ �������� �о���̴� ������ ���� ��.
              console.log("����"+Object.keys(all_line).length);
              for (var i = 0; i < Object.keys(all_line).length; i++) {

                  var key_name = (i+1) + "line";
                  console.log("Ű��"+key_name);
                  // p1line
                  //HashMap<String,String> allOfLine = new HashMap<String,String>();
                  var lineInfo = all_line[key_name];
                  console.log(lineInfo);


                  if (lineInfo.indexOf('p')==0) {
                      //"p"+i+"line"
                      //�Ķ�Ű�� �Ѱ��� �ױ�� ������
                      console.log("p�־ ����")
                      var all_param = all_data.keys["param"];
	console.log(all_param);
                      var key = all_param;
                      //����ٰ� �Լ��� ���� �ű⼭ ó���ϰ� �������
                      //canvas�� ���ϴ� �Ÿ������;
                      console.log(key);
                      var param1 = paramDraw(key["p"+key_name]);
                      //key�� object�������� ���޵�

                  } 
              }
          }
       })
    }
 }
		$(document).ready(function(){
			var objbj = document.getElementById('linenumber');
			var d = document.createElement("li");
			d.innerHTML = 1;
			objbj.appendChild(d);
		});
   
		   function updateLineNumber() {
			  
   var rawCodeText = document.getElementById("code").value;
   var previousLineNums=0;
   console.log(document.getElementById("code").value);
   console.log(rawCodeText);
   
		var lineNums = rawCodeText.split("\n").length;
		console.log("����"+lineNums);
		if (lineNums != previousLineNums) {
			
			var InObj = document.getElementById('linenumber');
			console.log(InObj);
			InObj.innerHTML = "";
			var objbj = document.getElementById('linenumber');
			for (var i=0; i<lineNums; i++) {
				var d = document.createElement("li");
				d.innerHTML = i + 1;
				objbj.appendChild(d);
				clearInterval();
			}
		}
		return lineNums;
		   }




</script>
<head>
<title>Binary by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />





<link rel="stylesheet" href="css/coloreditor.css" />
<link rel="stylesheet" href="css/codeAndCanvas.css" />
</head>

<body>

	<form name=codeform>
	<!-- Header -->
	<header id="header"> <a href="index.html" class="logo"><strong>Hello</strong>
		WORLD</a> <nav> <a href="#menu">Menu</a> </nav> </header>

	<!-- Nav -->
	<nav id="menu">
	<ul class="links">
		<li><a href="./balltest">balltest</a></li>
		<li><a href="generic.html">Generic</a></li>
		<li><a href="elements.html">Elements</a></li>
	</ul>
	</nav>


	<!-- One -->

	<article id="one" class="post style1">

	<div class="half" style="margin-top: 0px; height: 100%; width: 40px;">
		<!-- �����ġ�� -->
		<!-- ����� ���γѹ����� -->
		<div class="line" style="margin-top: 0px; height: 100%; width: 100%;">
			<ul id="linenumber" style="list-style-type: none; padding-left: 0px">

			</ul>

			<!-- ���� ��ģ�� -->



			<!-- �����ģ�� -->



		</div>
	</div>




	<div class="half" style="overflow: auto;">
		<textarea class="msg" id="code" name="code" spellcheck="false"
			onkeydown="setTimeout('updateLineNumber()',20)"
			onkeyup="setTimeout('updateLineNumber()',20)"
			style="padding: 0px; none; margin-top: 0px; height: 100%; width: 100%;"></textarea>

	</div>
	<div class="half" >
<!-- 		<canvas id="myCanvas"
			style='width:800px;
                  height:600px; position:absolute; left:0px; top:0px; overflow:hidden;'></canvas>
 --><canvas id="myCanvas"></canvas>

	</div>

	</article>

	<!-- Footer -->
	<!--  ������ footer ��� �� �� ��. -->
	<footer id="footer"> <!--   <ul class="icons">
               <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
               <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
               <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
            </ul> -->
	<div class="copyright">
		&copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>.
		Images: <a href="https://unsplash.com">Unsplash</a>.
	</div>
	</footer>

	<!-- Scripts -->





</form>

<script>
var canvas = document.querySelector('canvas');
function fitToContainer(canvas){
	canvas.style.width='100%';
	canvas.style.height='100%';
	canvas.width = canvas.offsetWidth;
	canvas.height = canvas.offsetHeight;
}
fitToContainer(canvas);
</script>
	<script type="text/javascript">

    function paramDraw(key) {
    
        var pline = key.paramLine;
        var pName = key.paramName;
        var pType = key.paramType;
        var pValue = key.paramValue;

        var canvas = document.getElementById("myCanvas");
        var ctx = canvas.getContext("2d");
        
        var rectX = 50;
        var rectY = 50;
        var rectWidth = 100;
        var rectHeight = 100;
        var cornerRadius = 20;
        
        
        ctx.lineJoin = "round";
        ctx.lineWidth = cornerRadius;
        
        ctx.beginStyle = '#333333';
        ctx.fillStyle = '#333333';
        
        ctx.strokeRect(rectX+(cornerRadius/2),rectY+(cornerRadius/2),rectWidth-cornerRadius,rectHeight-cornerRadius);
        ctx.fillRect(rectX+(cornerRadius/2),rectY+(cornerRadius/2),rectWidth-cornerRadius,rectHeight-cornerRadius);
        
        var ctx2 = canvas.getContext("2d");
        ctx2.font = "30px Arial";
        ctx2.fillStyle = '#E6E6E6';
        ctx2.fillText(pType,60,80);
        
        var ctx3 = canvas.getContext("2d");
        ctx3.font = "30px Arial";
        ctx3.fillStyle = '#E6E6E6';
        ctx3.fillText(pName,67,120);
        //���⼭ canvas�����ȴ�.
    }
       
   </script>


</body>
</html>