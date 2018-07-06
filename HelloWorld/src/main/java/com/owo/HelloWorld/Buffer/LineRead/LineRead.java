package com.owo.HelloWorld.Buffer.LineRead;

import org.springframework.stereotype.Repository;

import com.owo.HelloWorld.Buffer.Bean.ParamBean;
import com.owo.HelloWorld.Buffer.Enum.ParameterType;

@Repository
public class LineRead {

	ParameterType parameterType;
	ParamBean paramBean;
	
	
	public ParamBean case_VariableDeclaration(String line) {
		//String line = "char name;";
		System.out.println("케이스 들어옴");
		String[] dev = line.split(" ");
		paramBean = new ParamBean();
		
		System.out.println(line + "여긴 변수선언부분 찍히니?");
		
		for(int i=0;i<dev.length;i++) {
		System.out.println(dev[i]);
		}
		if(parameterType.values().equals(dev[0])&&!line.contains("=")) {
			//enum안에 있는 String과 split한 배열 첫번째랑 같은게 있는지 확인 근데 초깃값 설정안돼있는경우
			System.out.println("이프다"+dev[0]);
			paramBean.setParamType(dev[0]);
			paramBean.setParamName(dev[1].substring(0,dev[1].length()-1));
			
		} else if (parameterType.values().equals(dev[0])&&line.contains("=")) {
			//enum안에 있는 String과 split한 배열 첫번째랑 같은게 있는지 확인   초깃값 설정 되어있는경우
			System.out.println("이프엘스"+dev[1]);
			paramBean.setParamType(dev[0]);
			paramBean.setParamName(dev[1].substring(0,dev[1].length()-1));
			
			
		}
		return paramBean;
	}
}
