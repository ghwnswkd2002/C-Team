package com.owo.HelloWorld.Buffer;

import java.util.HashMap;

import com.owo.HelloWorld.Buffer.Bean.ForBean;
import com.owo.HelloWorld.Buffer.Bean.MethodBean;
import com.owo.HelloWorld.Buffer.Bean.ParamBean;

public interface CodeBuffer {
	
	public ParamBean case_VariableDeclaration(int lineNumber,String line,HashMap<String,String> splitcode,CoreBuffer corebuffer); 
	//변수선언과 관련된 함수
	
	public MethodBean case_functionDefine(int lineNumber,String line,HashMap<String,String> splitcode);
	//메소드 선언과 정의 관련된 함수
	
	public HashMap<String, String> methodSplit(HashMap<String, String> sc);
	//메소드 별로 짤라줌 void main(){ ~~ } / int result(int a,int,b){ ~~ }
	
	public ParamBean case_substitution(int lineNumber,String line);
	//변수연산 및 숫자 연산과 관련된 함수
	
	public Object operation_result();
	//수학적연산과 관련된 함수
	//float, double, int등 여러가지 변수형태를 써야할 것 같아서 object로 리턴값 주긴 했는데 더 좋은거 있으면 말좀 (후보 : math, )
	
	public ForBean Iterators();
	//반복문
	public ForBean case_forLoop (int lineNumber,String line,HashMap<String,String> splitcode); //for문

    public int nameSearch(CoreBuffer corebuffer, String code);

	
}
