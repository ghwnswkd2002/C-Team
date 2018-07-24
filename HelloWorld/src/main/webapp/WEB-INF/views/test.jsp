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
<script type="text/javascript">
/*   var idx=1;


   //updateLineNumber();
   
   function enterkey() {
      if (window.event.keyCode == 13) {
         indexadd();
      }
   }
   function indexadd() {
      var newdiv = document.createElement("DIV");
      //var newdiv1 = document.setElement
      newdiv.setAttribute('class', 'linenumber');

      newdiv.innerHTML = idx;
      document.getElementById('linenumber').appendChild(newdiv);
      idx++;
   } */
   

	
		
		$(document).ready(function(){
			var objbj = document.getElementById('linenumber');
			var d = document.createElement("li");
			d.innerHTML = 1;
			objbj.appendChild(d);
		});
   
		   function updateLineNumber() {
			  
   var rawCodeText = document.getElementById("codeArea").value;
   var previousLineNums=0;
   console.log(document.getElementById("codeArea").value);
   console.log(rawCodeText);
   
		var lineNums = rawCodeText.split("\n").length;
		console.log("라인"+lineNums);
		if (lineNums != previousLineNums) {
			//var lnObj = gebcn(ceDOM, "ce-linenumber")[0].getElementsByTagName("ol")[0];
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


   
   
//	return _object;

   
   /* function updateLineNumber(){
      var _value = document.getElementById("codeArea").value;
      console.log(_value);
      var lineNums = _value.split("\n").length;
      console.log(lineNums);
      
      if(idx != previousLineNums){
         var inobj = document.getElementsByClassName("DIV")[0];
         console.log(inobj);
         inobj.innerHTML = "";
         
         for(var i=0;i<lineNums;i++){
            var a = document.createElement("DIV");
            a.setAttribute('class', 'linenumber');
            
            a.innerHTML = i+1;
            inobj.appendChild(a);
         }
      }

   
   }*/
   

</script>
<style>

</style>
<head>
<title>Binary by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />





<link rel="stylesheet" href="css/coloreditor.css" />
<link rel="stylesheet" href="css/codeAndCanvas.css" />
</head>

<body>

	<!-- Header -->
	<header id="header"> <a href="index.html" class="logo"><strong>Hello</strong>
		WORLD</a> <nav> <a href="#menu">Menu</a> </nav> </header>

	<!-- Nav -->
	<nav id="menu">
	<ul class="links">
		<li><a href="index.html">Home</a></li>
		<li><a href="generic.html">Generic</a></li>
		<li><a href="elements.html">Elements</a></li>
	</ul>
	</nav>


	<!-- One -->

	<article id="one" class="post style1">

	<div class="half" style="margin-top: 0px; height: 100%; width: 40px;">
		<!-- 여기고치고 -->
		<!-- 여기는 라인넘버영역 -->
		<div class="line" style="margin-top: 0px; height: 100%; width: 100%;">
			<ul id="linenumber" style="list-style-type: none; padding-left: 0px">
			
			</ul>

			<!-- 여기 고친다 -->



			<!-- 여기고친다 -->



		</div>
	</div>




	<div class="half">
		<textarea class="msg" name="ff" id="codeArea" spellcheck="false"
			onkeydown="setTimeout('updateLineNumber()',20)"
			onkeyup="setTimeout('updateLineNumber()',20)"
			style="padding: 0px;  none; margin-top: 0px; height: 100%; width: 100%;" ></textarea>

	</div>
	<div class="half">
		<canvas id="myCanvas" style='position:absolute; left:0px; top:0px;'></canvas>


	</div>

	</article>

	<!-- Footer -->
	<!--  반응형 footer 고민 해 볼 것. -->
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







	<script type="text/javascript">
   
  // var codeArea =  updateLineNumber();
    
   /*    var mycanvas = document.getElementById('myCanvas');
      var ctx = mycanvas.getContext('2d');

      var imageObj = new Image();

      imageObj.src = "images/box1.png";
      imageObj.onload = function() {
         ctx.drawImage(imageObj, 40, 40, 60, 25);
      };

      (function() {
         var canvas = document.getElementById('myCanvas');
         var context = canvas.getContext('2d');
         initialize();

         function initialize() {
            window.addEventListener('resize', resizeCanvas, false);
            resizeCanvas();
         }
         function redraw() {
            context.strokeStyle = 'blue';
            context.linewidth = '5';
            context.strokeRect(0, 0, window.innerWidth, innerHeight);
         }
         function resizeCanvas() {
            htmlCanvas.width = window.innerWidth;
            htmlCanvas.height = window.innerHeight;
            redraw();
         }

      })(); */
   </script>


</body>
</html>