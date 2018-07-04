<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
</script>

<script type="text/javascript">
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
            success : function(data) {
              var tt = data.result;	
              var a = JSON.stringify(tt);
             
             var param = data.param;
             alert(parma);
             
              //var vvv = a.name;
            //  alert(vvv);
            },
            error : function(e) {
               console.log('error:' + e.status + '..힝')
            }

         });
      }
   }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<table cellpadding="0" cellspacing="0" width=50% border="0">
			<tr align="center" valign="middle">
				<td><h1>여기능 코드 영역</h1></td>

				<td><h1>여기능 이미지 영역</h1></td>
			</tr>
			<tr align="center" valign="middle">
				<td>
					<form name=codeform>
						<h3>코드다아아아아</h3>

						<textarea id="code" name="code" cols="67" rows="15"></textarea>
					</form>
				</td>
				<td>그림이다</td>
				<td>
					<h3>그림이다아아아아</h3> <canvas id="myCanvas" width="200px"
						height="200px" style="border:1px solid black"></canvas> </script>


				</td>
			</tr>
		</table>
	</center>



</body>
</html>