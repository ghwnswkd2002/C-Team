package com.owo.HelloWorld.Buffer;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.owo.HelloWorld.Buffer.Bean.MethodBean;
import com.owo.HelloWorld.Buffer.Bean.ParamBean;
import com.owo.HelloWorld.Buffer.Enum.ParameterType;
@Repository
public class CodeBuffer_Impl implements CodeBuffer{
	/*
	 * service에서 부름
	 * 
	 * 주로 line을 한줄 한줄 읽는 역할
	 * 한줄 한줄 읽어서 hashmap으로 반환하거나 객체로 반환해서 service에서 합쳐서  controller로 보내줌
	 * 여기서는 라인을 하나하나 읽는 경우의 수를 생각해서 함수 만들어 줘야함
	 * 	1. 첫 글자가 변수형태일 때
	 *		- 변수 선언문		- 함수 선언
	 *
	 *	2. 제어문 경우
	 *		- 반복문			- 제어문
	 *
	 *	3. 내장함수
	 *		- printf/scanf	- 기타
	 *
	 *	4. 기타(좀더 생각 해 볼것);
	 *
	 */


	//ParameterType parameterType;//enum쓸꼬얌
	ParamBean param;
	MethodBean method;

	@Override		//변수 선언부분 만났을 경우
	public ParamBean case_VariableDeclaration(int lineNumber,String line) {

		//String line ="char name;"
		System.out.println("케이스 변수선언 들어옴");
		String[] dev = line.split(" ");
		param = new ParamBean();

<<<<<<< HEAD
//		System.out.println(line +"���� �����κ� ������");
//		for(int i = 0; i<dev.length; i++) {
//			System.out.println("dev"+i+"="+dev[i]);
//		}
		
		for(ParameterType parameterType : ParameterType.values()) {//�Ϲ������ξȶ��� �����Ѱ��
			System.out.println("for�� ����");
=======
		System.out.println(line +"여긴 변수부분 찍히냐");
		for(int i = 0; i<dev.length; i++) {
			System.out.println("dev"+i+"="+dev[i]);
		}

		for(ParameterType parameterType : ParameterType.values()) {
			System.out.println("for문 들어옴");
>>>>>>> branch 'master' of https://github.com/ghwnswkd2002/C-Team.git
			if(dev[0].toUpperCase().equals(parameterType.toString())&&!line.contains("=")) {
				System.out.println("if문");
				//enum 안에 있는 Strind과 split한 배열 첫번째랑 같은게 있는지 확인
				//근데 초깃값 설정안되어 있는 경우
				//EX. int a;
				//toUpperCase() 이거는 소문자를 대문자로 바꾸는 함수
				System.out.println(dev[0]+"이거 넣을게 초기화 안해도대는거야 ");
				param.setParamType(dev[0]);
				param.setParamName(dev[1].replaceAll(";",""));
<<<<<<< HEAD
				
=======

>>>>>>> branch 'master' of https://github.com/ghwnswkd2002/C-Team.git
			} else if(dev[0].toUpperCase().equals(parameterType.toString())&&line.contains("=")) {
<<<<<<< HEAD
				//�ʱ�ȭ �ؼ� ������ ���
				System.out.println("else if��");
				//enum �ȿ� �ִ� String�� split�� �迭 ù��°�� ������ �ִ��� Ȯ��
				//�ٵ� �ʱ갪 ���� �Ǿ� ����
=======
				System.out.println("else if문");
				//enum 안에 있는 String과 split한 배열 첫번째랑 같은게 있는지 확인
				//근데 초깃값 설정 되어 있음
>>>>>>> branch 'master' of https://github.com/ghwnswkd2002/C-Team.git
				//EX. int a = 40;
				param.setParamType(dev[0]);
				System.out.println("setParamType============de[0]에 넣음");
				String[] temp = dev[1].split("=");//=을 기준을 다시 자른다
				System.out.println("dev[1] "+dev[1]);
				System.out.println("temp0  "+temp[0]);
				System.out.println("temp1  "+temp[1]);
				System.out.println("=기준 자름");
				param.setParamName(temp[0]);
				System.out.println("temp[0]에 넣음");
				param.setParamLine(String.valueOf(lineNumber));
				param.setParamValue(temp[1].replaceAll(";",""));
<<<<<<< HEAD
				System.out.println("��");
=======

				System.out.println("샷");
>>>>>>> branch 'master' of https://github.com/ghwnswkd2002/C-Team.git
			}
<<<<<<< HEAD
			//�ʱ�ȭ �Ҷ� ����� ����� ���
			else if(dev[0].toUpperCase().equals(parameterType.toString())&&line.contains("=")&&dev.length>2) {
				
			}
			//�ʱ�ȭ �� ������ char�� ���ڿ� ��������
			else if(dev[0].equals("char")) {
				
			}
			//������ �ΰ��
			
			
=======
			//초기화 할때 띄워서 선언된 경우
			else if(dev[0].toUpperCase().equals(parameterType.toString())&&line.contains("=")&&dev.length>2) {

			}
			//초기화 한 변수가 char에 문자열 담았을경우
			else if(dev[0].equals("char")) {

			}
			//포인터인 경우
>>>>>>> branch 'master' of https://github.com/ghwnswkd2002/C-Team.git
		}




		return param;
	}


	@Override		//함수정의부분 만났을 경우
	//이건아직하지마
	public MethodBean case_functionDefine(int lineNumber,String line,HashMap<String,String> splitcode) {
		method = new MethodBean();
		String[] dev = line.split(" ");
		//EX. int method(int a,int b);
		HashMap<String,String> methodcode = methodSplit(splitcode);






		return method;
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
	public ParamBean case_substitution(int lineNumber, String line) {
		//변수 연산 및 숫자 연산
		String[] temp = line.split("=");
		//EX. a+b=c-d;
		ParamBean param = new ParamBean();
		String[] oper = {"+","-","*","/"}; 
		
		
		
		
		if(temp[0].contains("+")||temp[0].contains("-")||temp[0].contains("*")||temp[0].contains("/")) {
			//만약에 대입하는 곳에 연산 기호가 있을 경우

			if(true) {//EX. a+b=

			}
			else if(false) {

			}
		}
		else if(!temp[0].contains("+")&&!temp[0].contains("-")&&!temp[0].contains("*")&&!temp[0].contains("/")) {
			//대입하는 곳에 연산기호가 없는 경우
			
			if(temp[1].contains("+")||temp[1].contains("-")||temp[1].contains("*")||temp[1].contains("/")) {
				//뒤에 연산기호가 있는 경우 = a+b
				
				//for문 돌려서 +_*/중에 어느하나라도 있니 없니 물어보고 난뒤에 있다고하면
				//스플릿해서 숫자인지 변수인지 확인하고
				//숫자일경우 그대로 연산
				//숫자가아니라 변수일 경우 Bean으로 가서 변수value를 데려와서 연산한다.
				//연산 기호를 어떻게 알아내지?
				
				for(String str : oper) {
					if(temp[1].contains(str)) {
						String[] splittemp = temp[1].split(str);
						
						//splittemp[0]
								
						/*switch(str) {
						case "+" :splittemp[0]
						case "-" :
						case "*" :
						case "/" :
						}*/
						
					}
					
				}
				
				
			}
			else if(!temp[1].contains("+")&&!temp[1].contains("-")&&!temp[1].contains("*")&&!temp[1].contains("/")) {
				//뒤에 연산기호가 없는경우 = a 그냥 대입하라
				
				//연산기호가 없는 경우는 앞의 변수에 뒤에 변수의 값을 전달 해 주기만 하면 된다.
				//여기서 문제는 어떻게 앞라인 변수의 값이 뒷라인과 달라졌는지 표시(?)가 있어야 하는데 이건 아직 연구해봐야할듯
				
			}

		}


		return null;
	}

	@Override
	public Object operation_result() {
		//수학적 연산하고 관련된 함수인데 리턴타입을 뭘로줄지 모르겠어서 일단 object로 줬음 더좋은거있으면 그걸로 반환



		return null;
	}

}

