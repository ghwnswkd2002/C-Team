<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script src="modernizr-1-6.min.js"></script>
<script type="text/javascript">
window.addEventListener('load',eventWindowLoaded,false);

function eventWindowLoaded(){
	canvasApp();
}

function canvasSupport()}{
	return Modernizr.canvas;
}

function canvasApp(){
	if(!canvasSupport()){
		return;
	}
	
	function drawScreen(){
		context.fillStyle='#EEEEEE';
		context.fillRect(0,0,thCanvas.width,theCanvas.height);
		
		//사각형 박스
		context.strokeStyle ='#000000';
		context.strokeRect(1,1,theCanvas.width-2,theCanvas.height-2);
		
		update();
		testWalls();
		collide();
		render();
		
	}
	
	function update(){
		for(var i=0;i<balls.length;i++){
			ball = balls[i];
			ball.nextx = (ball.z+=ball.velocityx);
			ball.nexty = (ball.y+=ball.velocityx);
			
		}
	}
	
	function textWalls(){
		var ball;
		var testBall;
		
		for(var i=0;i<balls.length;i++){
			
			ball = balls[i];
			
			if(ball.nextx+ball.radius>theCanvas.width){
				ball.velocityx = ball.velocityx*-1;
				ball.nextx = theCanvas.width- ball.radius;
			}else if(ball.nextx-ball.radius<0){
				ball.velocityx = ball.velocityx*-1;
				ball.nextx = ball.radius;
			}else if(ball.nexty+ball.radius > theCanvas.height){
				ball.velocityy = ball.velocityy*-1;
				ball.nexty = theCanvas.height- ball.radius;
			}
			else if(ball.nexty+ball.radius>theCanvas.width){
				ball.velocityy = ball.velocityy*-1;
				ball.nexty = ball.radius;
			}
		}
	}
	
	function render(){
		var ball;
		context.fillStyle = "#000000";
		for(var i=0;i<balls.length;i++){
			ball = balls[i];
			ball.x = ball.nextx;
			ball.y = ball.nexty;
			
			context.beginPath();
			context.arc(ball.x,ball.y,ball.radius,0,Math.PI*2,true);
			context.closePath();
			context.fill();
			
		}
	}
	
	
	function collide(){
		var ball;
		var testBall;
		for(var i=0;i<balls.length;i++){
			ball=balls[i];
			for(var j=i+i;j<balls.length;j++){
				
			}
		}
	}
}


</script>

</body>
</html>