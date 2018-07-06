package com.owo.HelloWorld.Buffer;

import org.springframework.stereotype.Repository;

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
	 *	2. 제어문 경우
	 *		- 반복문			- 제어문
	 *	3. 내장함수
	 *		- printf/scanf	- 기타
	 *	4. 기타(좀더 생각 해 볼것);	
	 */
	
	
	ParameterType parameterType;//enum쓸꼬얌
	ParamBean param;

	
	
	public ParamBean case_VariableDeclaration(String line) {
		
		//String line ="char name;"
		System.out.println("케이스 변수선언 들어옴");
		String[] dev = line.split(" ");
		param = new ParamBean();
		
		System.out.println(line +"여긴 변수부분 찍히냐");
		
		for(int i=0;i<dev.length;i++) {
			System.out.println(dev[i]);
		}
		
		if(parameterType.values().equals(dev[0])&&!line.contains("=")) {
			//enum 안에 있는 Strind과 split한 배열 첫번째랑 같은게 있는지 확인
			//근데 초깃값 설정안되어 있는 경우
			//EX. int a;
			
			param.setParamType(dev[0]);
			param.setParamName(dev[1].substring(0,dev[1].length()-1));
		} else if(parameterType.values().equals(dev[0])&&line.contains("=")) {
			//enum 안에 있는 String과 split한 배열 첫번째랑 같은게 있는지 확인
			//근데 초깃값 설정 되어 있음
			//EX. int a = 40;
			param.setParamType(dev[0]);
			String[] temp = dev[1].split("=");//=을 기준을 다시 자른다
			
			
			param.setParamName(temp[0]);
			param.setParamValue(temp[1].substring(0,dev[1].length()-1));
		}
		
		return param;
	}
	
	
}
