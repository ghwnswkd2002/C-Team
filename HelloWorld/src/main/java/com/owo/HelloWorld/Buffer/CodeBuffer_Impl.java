package com.owo.HelloWorld.Buffer;

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

//		System.out.println(line +"여긴 변수부분 찍히냐");
//		for(int i = 0; i<dev.length; i++) {
//			System.out.println("dev"+i+"="+dev[i]);
//		}
		
		for(ParameterType parameterType : ParameterType.values()) {//일반적으로안띄우고 선언한경우
			System.out.println("for문 들어옴");
			if(dev[0].toUpperCase().equals(parameterType.toString())&&!line.contains("=")) {
				System.out.println("if문");
				//enum 안에 있는 Strind과 split한 배열 첫번째랑 같은게 있는지 확인
				//근데 초깃값 설정안되어 있는 경우
				//EX. int a;
				//toUpperCase() 이거는 소문자를 대문자로 바꾸는 함수
				System.out.println(dev[0]+"이거 넣을게 초기화 안해도대는거야 ");
				param.setParamType(dev[0]);
				param.setParamName(dev[1].replaceAll(";",""));
				
			} else if(dev[0].toUpperCase().equals(parameterType.toString())&&line.contains("=")) {
				//초기화 해서 선언한 경우
				System.out.println("else if문");
				//enum 안에 있는 String과 split한 배열 첫번째랑 같은게 있는지 확인
				//근데 초깃값 설정 되어 있음
				//EX. int a = 40;
				param.setParamType(dev[0]);
				System.out.println("setParamType============dev[0]에 넣음");
				String[] temp = dev[1].split("=");//=을 기준을 다시 자른다
				System.out.println("dev[1] "+dev[1]);
				System.out.println("temp0  "+temp[0]);
				System.out.println("temp1  "+temp[1]);
				System.out.println("=기준 자름");
				param.setParamName(temp[0]);
				System.out.println("temp[0]에 넣음");
				param.setParamLine(String.valueOf(lineNumber));
				param.setParamValue(temp[1].replaceAll(";",""));
				System.out.println("샷");
			}
			//초기화 할때 띄워서 선언된 경우
			else if(dev[0].toUpperCase().equals(parameterType.toString())&&line.contains("=")&&dev.length>2) {
				
			}
			//초기화 한 변수가 char에 문자열 담았을경우
			else if(dev[0].equals("char")) {
				
			}
			//포인터 인경우
			
			
		}
		return param;
	}



	@Override		//함수정의부분 만났을 경우
	public MethodBean case_functionDefine(int lineNumber,String line,HashMap<String,String> splitcode) {
		method = new MethodBean();
		String[] dev = line.split(" ");
		//EX. int method(int a,int b);
		
		
		
		
		
		
		
		return method;
	}
	
	


}
