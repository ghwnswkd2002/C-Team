package com.owo.HelloWorld.Buffer;

import java.util.HashMap;

import com.owo.HelloWorld.Buffer.Bean.ParamBean;

public class CoreBuffer {
	/*
	 * 제어문과 관련한 정보를 담기위한 controlStetement의 object타입 value에 
	 * 과연 각기 다른 bean을 담을수 있는지 궁리 해야함
	 * for문이 있다면 for문과 관련된 객체를 hashmap에 담아야하고
	 * switch문이 있으면 관련된 객체를 다르게 담아주어야 하기 때문이다.
	 */
	
	HashMap<String,Object> param = new HashMap();		//변수 선언
	HashMap<String,Object> method = new HashMap();		//함수 선언
	HashMap<String,Object> controlStatement = new HashMap();//제어문 정보
	HashMap<String,Object> allLine = new HashMap();//라인 통째로 해쉬맵에 저장
	
	public HashMap<String, Object> getParam() {
		return param;
	}
	public void setParam(String string,Object pb) {
		System.out.println(pb+"셋파람 들어옴 "+string);
		param.put("p"+string, pb);
	}
	public HashMap<String, Object> getMethod() {
		return method;
	}
	public void setMethod(HashMap<String, Object> method) {
		this.method = method;
	}
	public HashMap<String, Object> getControlStatement() {
		return controlStatement;
	}
	public void setControlStatement(HashMap<String, Object> controlStatement) {
		this.controlStatement = controlStatement;
	}
	public HashMap<String, Object> getAllLine() {
		return allLine;
	}
	public void setAllLine(HashMap<String, Object> allLine) {
		this.allLine = allLine;
	}
	
	
}
