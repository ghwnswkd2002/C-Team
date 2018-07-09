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
	public HashMap<String, String> methodSplit(HashMap<String, String> sc) { //메소드 잘라서 붙이는거임
		//String mth = "void main(){ int a;, int b ; int c; c = a+b; printf("%d",c); }";
		HashMap<String, String> res = new HashMap<String, String>();	//해쉬맵임
		ArrayList list = new ArrayList();								//라인 나눈거 받은거 get한거 넣은 리스트임
		String result; 										//결과값임
		ArrayList<Integer> start = new ArrayList<Integer>(); 			//시작라인 어레이리스트임
		ArrayList<Integer> end = new ArrayList<Integer>(); 				//끝라인임 ㅎㅎ
		//String[] msd = null; 											//msd배열임 null로 초기화 ㅎㅎ 일단주석
		int Sindex = 0; 									//스타트인덱스
		int Eindex = 0;										//끝인덱스
		int Toindex = 0; 									//총 인덱스
		int startcbcnt = 0;									//여는 중괄호 { 카운트
		int endcbcnt = 0;									//닫는 중괄호 } 카운트

		for(int i=0; i<sc.size(); i++) { 								//돌려돌려 for문판!
			if(sc.get((i+1)+"line").contains("{")) {
				startcbcnt++;
			}
			if(sc.get((i+1)+"line").contains("}")) {
				endcbcnt++;
			}

			if((startcbcnt-endcbcnt)==1&&sc.get((i+1)+"line").contains("(")&&!sc.get((i+1)+"line").contains(";")) { //만약에~말야~
				System.out.println("시작라인 확인"); 						//찍어봄 함
				start.add(i+1); 										//스타트 넣어줌
				list.add(sc.get((i+1)+"line")); 									//리스트에 넣어 if문에 걸리는거
				System.out.println("시작라인"+list.get(Toindex)+"라인번호 = "+start.get(Sindex)); //찍어�R다
				Sindex++; 												//증
				Toindex++; 												//가
			}
			if((startcbcnt==endcbcnt)&&sc.get((i+1)+"line").contains("}")) { 							//끝찾기

				System.out.println("끝라인 체크");
				end.add(i+1); 											//end 리스트에 넣음
				list.add(sc.get((i+1)+"line")); 									// 끝라인 넣음
				System.out.println("끝라인"+list.get(Toindex) + "라인번호 = " +end.get(Eindex));
				Eindex++; 												//증
				Toindex++; 												//to the 가
			}

		}


		for(int ind = 0; ind<end.size(); ind++) { 						//돌려돌려 for문판!
			result = ""; 												//result값 초기화
			for(int st=start.get(ind); st<end.get(ind)+1; st++) { 		//함수형식으로 만들기 위해 한번 더 돌림
				result +=sc.get(st+"line")+"\n";								//라인 존나게 붙여준다
				System.out.println("라인 붙이기 ="+result); 
			}
			res.put((ind+1)+"line", result); 									//res에 넣어줌
			System.out.println((ind+1)+"번 들어감");
		}

		for(int i=0; i<res.size(); i++) {
			System.out.println("LineBuffer\n"+(i+1)+"번째 함수"+res.get((i+1)+"line"));		    
		}

		for(int i=0; i<sc.size();i++) { 								//라인확인하려고 돌려봄
			System.out.println(i+1+"번째 라인 = "+sc.get((i+1)+"line"));
		}
		return res;
	}

	@Override
	public Object lineRead(int lineNumber,String code,HashMap<String, String> splitcode) {// 여기 string은 1라인씩 자른 코드의 한줄짜리 코드임
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


		CoreBuffer corebuffer = new CoreBuffer();
		System.out.println("전부읽어들이기");
		System.out.println(splitcode);
		//HashMap<String, String> temp = new HashMap<String,String>();


		for(int i=1;i<splitcode.size()+1;i++) {
			Object obj = new Object();
			//	System.out.println(hashmap.get(i+"line"));
			obj = lineRead(i,splitcode.get(i+"line"),splitcode);//리턴타입 오브젝트


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
