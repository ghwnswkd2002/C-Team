package com.owo.HelloWorld.Buffer;

import java.util.HashMap;

public class CoreBuffer {
	HashMap<Integer,Object> param = new HashMap();		//변수 선언
	HashMap<Integer,Object> method = new HashMap();		//함수 선언
	HashMap<Integer,Object> controlStatement = new HashMap();//제어문 정보
	HashMap<Integer,Object> allLine = new HashMap();//라인 통째로 해쉬맵에 저장
	public HashMap<Integer, Object> getParam() {
		return param;
	}
	public void setParam(HashMap<Integer, Object> param) {
		this.param = param;
	}
	public HashMap<Integer, Object> getMethod() {
		return method;
	}
	public void setMethod(HashMap<Integer, Object> method) {
		this.method = method;
	}
	public HashMap<Integer, Object> getControlStatement() {
		return controlStatement;
	}
	public void setControlStatement(HashMap<Integer, Object> controlStatement) {
		this.controlStatement = controlStatement;
	}
	public HashMap<Integer, Object> getAllLine() {
		return allLine;
	}
	public void setAllLine(HashMap<Integer, Object> allLine) {
		this.allLine = allLine;
	}
	
/*
 * 제어문과 관련한 정보를 담기위한 controlStetement의 object타입 value에 
 * 과연 각기 다른 bean을 담을수 있는지 궁리 해야함
 * for문이 있다면 for문과 관련된 객체를 hashmap에 담아야하고
 * switch문이 있으면 관련된 객체를 다르게 담아주어야 하기 때문이다.
 */
	
	
}
