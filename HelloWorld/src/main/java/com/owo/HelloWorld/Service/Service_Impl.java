package com.owo.HelloWorld.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.owo.HelloWorld.Buffer.CodeBuffer;
import com.owo.HelloWorld.Buffer.CoreBuffer;
import com.owo.HelloWorld.Buffer.Bean.ForBean;
import com.owo.HelloWorld.Buffer.Bean.MethodBean;
import com.owo.HelloWorld.Buffer.Bean.ParamBean;
import com.owo.HelloWorld.Buffer.Enum.ControlStatement;
import com.owo.HelloWorld.Buffer.Enum.ParameterType;

@Service
public class Service_Impl implements MainService{
    /* 
     * 코어 버퍼에 한꺼번에 모아서 객체를 전달할 예정이기 때문에
     * 라인 버퍼까지 있을 필요가 없을 수도 있기때문
     * 여기로 코드 전부를 모아서 바로 core로 보내는 함수를 전부 만든다.
     * line별로 스플릿한 해시맵을 라인수대로 차례차례검사하면서
     * corebuffer에 있는 해시맵에 다시 담아주는 작업을 실시한다.
     */

    @Inject
    CodeBuffer codebuffer;
    MainService mainservice;

    ParameterType parameterType;
    int keynum;
    @Override
    public HashMap<String, String> splitCode(String text) {
        HashMap<String, String> res = new HashMap<String, String>();
        System.out.println("split 들어옴");
        if(text != null) { 										//텍스트 널 아니면
            String[] sp = text.split("\n"); 					// 자르셈
            for(int i = 0; i < sp.length; i++) { 				//포문돌림
                res.put((i+1)+"line", sp[i]); 					//res해쉬맵에 넣어
                System.out.println(res.get((i+1)+"line")); 		//찍어
            }
            return res; 										//컨트롤러에서 불렀잖; ;;리턴해
        }		
        return null;
    }

    @Override
    public HashMap<String, String> methodSplit(HashMap<String, String> sc) { 
        return codebuffer.methodSplit(sc);
    }

    @Override
    public Object lineRead(int lineNumber,String code,HashMap<String, String> splitcode,CoreBuffer corebuffer, int keynum) {// 여기 string은 1라인씩 자른 코드의 한줄짜리 코드임
        //String[] lineSplit = code.split(" ");// 여기서 스플릿을 여러형태로 해줘야함
        //만약 =이 있을 경우 양쪽의 값을 비교대조해줘야하거나
        //케이스별로 짜개야함
        //int a;

        ParamBean parambean = new ParamBean();

        System.out.println("한라인만 읽기");
        System.out.println(code);

      //  int povalue = pointerNameSearch(corebuffer, code);
//System.out.println("POVALUEEEEEEEEEEEEEEEEE"+povalue);
        int isvalue = codebuffer.nameSearch(corebuffer, code);
        System.out.println(lineNumber);
        System.out.println("이거뭔ㄷㅔ"+isvalue);
        
        for(ParameterType parameterType : ParameterType.values()) {
            System.out.println("keynum = "+keynum);
            System.out.println("파라미터타입 = "+parameterType.toString());
            if(code.toUpperCase().contains(parameterType.toString())&&!code.contains("(")) {			//변수선언일경우
                System.out.println("int 드르가");
                parambean = codebuffer.case_VariableDeclaration(lineNumber,code,splitcode,corebuffer);
                System.out.println("paramname"+parambean.getParamName());
                System.out.println("paramline"+parambean.getParamLine());
                //keynum++;
                //parambean.setKeyNum(keynum);
                return parambean;
            }
           /* else if(code.toUpperCase().contains(parameterType.toString())&&!code.contains("(")&&code.contains("*")) {
                System.out.println("포인터쪽 int 드르가");
                parambean = codebuffer.case_VariableDeclaration(lineNumber,code);
                System.out.println("paramname"+parambean.getParamName());
                System.out.println("paramline"+parambean.getParamLine());
                return parambean;
                //keynum++;
                //parambean.setKeyNum(keynum);
            }*/
            else if(!code.contains("for")&&code.toUpperCase().contains(parameterType.toString())&&code.contains("(")&&code.contains(")")) {										//함수선언일경우
                System.out.println("함수케이스 들어가버렷스");
                MethodBean methodbean = new MethodBean();

                methodbean = codebuffer.case_functionDefine(lineNumber,code,splitcode);
            }else if(corebuffer.getParam().get("p"+keynum+"line")==null) {
                System.out.println("널 들어옴");
                continue;
            }
            /*
			else if(code.contains(corebuffer.getParam().get("p"+keynum+"line").getParamName())&&code.contains("=")&&!code.toUpperCase().contains(parameterType.toString())) {
			    String[] tempvalue = code.split("=");

			    corebuffer.getParam().get("p"+keynum+"line").setParamValue(tempvalue[1].replaceAll(";", ""));


			    keynum--;
			    return keynum;
			    //return parambean;
			   // System.out.println("쉿 조용");
			//    return 10;
			}*/
            
        }
        
//-----------------------for------------------------------
        
        for(ControlStatement controlstatement : ControlStatement.values()) {
            if(code.toUpperCase().contains(controlstatement.toString())) {     
                System.out.println("for문 들어갔습니다");
                ForBean forbean =new ForBean();
                
                forbean = codebuffer.case_forLoop(lineNumber, code, splitcode);
                System.out.println("lineNumber: "+lineNumber+"code: "+code);
                
                return forbean;
            }

       
		
//-----------------------for------------------------------      
        if(isvalue != 0) {
            System.out.println(isvalue);
            String[] tempvalue = code.split("=");
            System.out.println("value"+tempvalue[1]);
            tempvalue[1] = tempvalue[1].replaceAll(" ","");
            corebuffer.getParam().get("p"+isvalue+"line").setParamValue(tempvalue[1].replaceAll(";", ""));
        }
  /*      
        if(povalue != 0) {
            System.out.println("POVALUE"+povalue);
            System.out.println("라인넘버가 몇임?"+lineNumber);
            System.out.println(corebuffer.getParam().get("p"+lineNumber+"line"));
            corebuffer.getParam().get("p"+lineNumber+"line").setParamValue(corebuffer.getParam().get("p"+povalue+"line").getParamValue());
            return parambean;
        }*/


        

        }
     
       return "lineRead부분";//임시
    }




    @Override
    public CoreBuffer allRead(HashMap<String, String> splitcode) {

        CoreBuffer corebuffer = new CoreBuffer();
        //CoreBuffer corebuffer = new CoreBuffer();	// 비교할려면 코어버퍼 줘야하나? 시발
        // 이거 어떻게 해야하지
        keynum=-1;
        System.out.println("전부읽어들이기");
        System.out.println("allRead부분"+splitcode);
        //HashMap<String, String> temp = new HashMap<String,String>();

        int j= 1;
        for(int i=1;i<splitcode.size()+1;i++) {
            Object obj = new Object();
            //	System.out.println(hashmap.get(i+"line"));

            keynum++;
            obj = lineRead(i,splitcode.get(i+"line"),splitcode,corebuffer,keynum);//리턴타입 오브젝트
            //변수 같은거 있나없나 비교할려면 코어버퍼 줘야하나? 시발
            if(obj instanceof Integer) {
                keynum = (Integer) obj;
            }
            System.out.println(obj);
            if(obj instanceof ParamBean) {	//Object의 타입을 알아내기위함
                System.out.println(obj instanceof ParamBean);
                ParamBean pb = new ParamBean();
                pb = (ParamBean)obj;
                corebuffer.setParam(j+"line",pb);
            
                System.out.println("같냐안간나");
                j++;
            }else if(obj instanceof ForBean) {
            	ForBean fb = new ForBean();
            	fb=(ForBean)obj;
            	//--------여기서부터 ----------
            	
            }
          
            //System.out.println("비었나안비었나"+corebuffer.getParam().isEmpty());
            
            /*for(int po = 1 ; po <= corebuffer.getParam().size(); po++) {
                System.out.println("p아이line=    "+"p"+po+"line");
            if(corebuffer.getParam().get("p"+po+"line").getParamName().contains("*")) {
                System.out.println("포인터 들어옴옴옴");
                System.out.println(po+"의 값들이다."+corebuffer.getParam().get("p"+po+"line").getParamName());
                int resserch = pointerNameSearch(corebuffer, corebuffer.getParam().get("p"+po+"line").getParamValue());
                System.out.println("resserch"+resserch);
                corebuffer.getParam().get("p"+po+"line").setParamValue(corebuffer.getParam().get("p"+resserch+"line").getParamValue());
            }
            }*/
            
        }
                            
        return corebuffer;  
    }

    
    
    @Override
    public int pointerNameSearch(CoreBuffer coreBuffer, String code) {
        System.out.println("코드코드" +  code);
      //  String[] key = code.split("=");
        
       // key[1]=key[1].replaceAll(" ", "");
       // key[1]=key[1].replaceAll(";", "");
        System.out.println("key[1]@#@!#!#@!#@!#@!#!#asd!@#@!"+code);
        if(!code.contains("&")) {
            System.out.println("&이 없네");
            return 0;
        }
        String res = code.replace("&","");
        System.out.println("RESSSSSSSSSSSSSSSSSSSSSS"+res);
        int i;
        for(i= 1; i<=coreBuffer.getParam().size(); i++) {
            if(res.equals(coreBuffer.getParam().get("p"+i+"line").getParamName())) {
                System.out.println("아이의 값이다!!!!!!"+i);
                return i;
            }
        }
        return 0;
        
    }
    
}
