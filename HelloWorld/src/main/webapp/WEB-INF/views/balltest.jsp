<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery.min.js"></script>
<script src="js/fabric.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<canvas id="mc" width="800" height="600"></canvas>

<script>
 var canvas = new fabric.Canvas('mc',{hoverCursor:'pointer',selection:false});
 
 var rect = new fabric.Rect({
	 radius:25,
	 padding:20,

	 fill :'red',
	 width:200,
	 height:200
	 });
 
 var str ="String";
 
 var text = new fabric.IText(str);
 
 canvas.add(rect);

</script>


</body>
</html>