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
             var json = data;
             console.log("data받아옴"+json);
             
             console.log(Object.keys(json.keys).length);
             for(var i = 0; i < Object.keys(json.keys).length; i++){
                console.log((i+1)+"번 라인"+json.keys["param"]);
                var unlock = json.keys["param"];
                console.log(unlock);
           //  console.log(Object.keys(unlock.p2line).length);
             console.log(Object.keys(unlock).length);
             }
          for(var j = 0; j< Object.keys(unlock).length; j++){
             var lockkeys = "p"+(j+1)+"line"
             console.log(lockkeys);
                console.log(lockkeys + "의 paramLine = "+unlock[lockkeys].paramLine);
                console.log(lockkeys + "의 paramName = "+unlock[lockkeys].paramName);
                console.log(lockkeys + "의 paramType = "+unlock[lockkeys].paramType);
                console.log(lockkeys + "의 paramValue = "+unlock[lockkeys].paramValue);
             }
             
             //   console.log(unlock.keys["p2line"]);
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
				</td>
			</tr>
		</table>
		<a href="./test">go test</a>
	</center>
</body>
</html>