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
            success : function (data) {
                //여기서 모든라인의 정보를 갖고있는 해쉬맵의 key 1부터 하나하나 읽어들여
                //key안에 있는 value(다른라인의 hashmap의 key)를 찾아감
                var all_data = data;
                var all_line = all_data.keys["allOfLine"];// 여기에 java에서 가져온 모든라인을 읽어들이는 정보를 넣을 것.
                console.log("길이"+Object.keys(all_line).length);
                for (var i = 0; i < Object.keys(all_line).length; i++) {

                    var key_name = (i+1) + "line";
                    console.log("키네"+key_name);
                    // p1line
                    //HashMap<String,String> allOfLine = new HashMap<String,String>();
                    var lineInfo = all_line[key_name];
                    console.log(lineInfo);


                    if (lineInfo.indexOf('p')==0) {
                        //"p"+i+"line"
                        //파람키를 넘겨쥼 그기로 가세여
                        console.log("p있어서 들어옴")
                        var all_param = all_data.keys["param"];
	console.log(all_param);
                        var key = all_param;
                        //여기다가 함수를 만들어서 거기서 처리하게 만들어죠
                        //canvas로 통하는 거만듦녀댄당;
                        console.log(key);
                        paramDraw(key["p"+key_name]);
                        //key는 object형식으로 전달됨

                    } 
                }
            }
         })
      }
   }
            
            	
            	/* function(data) {
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
            } */
          

            
          
      
   
   
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <center>
      <table cellpadding="0" cellspacing="0" width=50% border="0">
         <tr align="center" valign="middle">
            <td>
               <form name=codeform>
                  <h3>코드다아아아아</h3>

                  <textarea id="code" name="code" cols="67" rows="15"></textarea>
               </form>
            </td>
       
            <td>
               <h3>그림이다아아아아</h3> <canvas id="myCanvas" width="1000px"
                  height="500px" style="border:1px solid black"></canvas>
         
				</td>
			</tr>
		</table>
		<a href="./test">go test</a>
	</center>
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
        //여기서 canvas만들면된다.
    }
    
	</script>
</body>
</html>