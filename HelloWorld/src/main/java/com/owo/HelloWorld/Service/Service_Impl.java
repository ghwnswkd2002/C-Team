package com.owo.HelloWorld.Service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.owo.HelloWorld.Buffer.CodeBuffer;
import com.owo.HelloWorld.Buffer.CoreBuffer;
import com.owo.HelloWorld.Buffer.Bean.MethodBean;
import com.owo.HelloWorld.Buffer.Bean.ParamBean;
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

	CoreBuffer corebuffer = new CoreBuffer();
	MainService mainservice; 

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
	public Object lineRead(int lineNumber,String code,HashMap<String, String> splitcode,CoreBuffer corebuffer) {// 여기 string은 1라인씩 자른 코드의 한줄짜리 코드임
		//String[] lineSplit = code.split(" ");// 여기서 스플릿을 여러형태로 해줘야함
		//만약 =이 있을 경우 양쪽의 값을 비교대조해줘야하거나
		//케이스별로 짜개야함
		//int a;

		System.out.println("한라인만 읽기");
		System.out.println(code);

		for(ParameterType parameterType : ParameterType.values()) {
			if(code.toUpperCase().contains(parameterType.toString())&&!code.contains("(")) {			//변수선언일경우
				System.out.println("int 드르가");
				ParamBean parambean = new ParamBean();
				parambean = codebuffer.case_VariableDeclaration(lineNumber,code);
				System.out.println("paramname"+parambean.getParamName());
				System.out.println("paramline"+parambean.getParamLine());
				return parambean;
			}
			else if(code.toUpperCase().contains(parameterType.toString())&&code.contains("(")&&code.contains(")")) {										//함수선언일경우
				System.out.println("함수케이스 들어가버렷스");
				MethodBean methodbean = new MethodBean();
				
				methodbean = codebuffer.case_functionDefine(lineNumber,code,splitcode);
			}
		}


		return null;//임시

	}



	@Override
	public CoreBuffer allRead(HashMap<String, String> splitcode) {


		//CoreBuffer corebuffer = new CoreBuffer();	// 비교할려면 코어버퍼 줘야하나? 시발
																		// 이거 어떻게 해야하지
		
		System.out.println("전부읽어들이기");
		System.out.println(splitcode);
		//HashMap<String, String> temp = new HashMap<String,String>();


		for(int i=1;i<splitcode.size()+1;i++) {
			Object obj = new Object();
			//	System.out.println(hashmap.get(i+"line"));
			
			
			obj = lineRead(i,splitcode.get(i+"line"),splitcode,corebuffer);//리턴타입 오브젝트
			//변수 같은거 있나없나 비교할려면 코어버퍼 줘야하나? 시발
			

			System.out.println(obj);
			if(obj instanceof ParamBean) {	//Object의 타입을 알아내기위함
				System.out.println(obj instanceof ParamBean);

				corebuffer.setParam(i+"line",obj);
				System.out.println("같냐안간나");
			}
		}

		return corebuffer;
	}
}
