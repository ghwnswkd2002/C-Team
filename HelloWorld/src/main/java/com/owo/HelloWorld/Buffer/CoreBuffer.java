package com.owo.HelloWorld.Buffer;

import java.util.HashMap;

public class CoreBuffer {
	HashMap<Integer,Object> param = new HashMap();		//���� ����
	HashMap<Integer,Object> method = new HashMap();		//�Լ� ����
	HashMap<Integer,Object> controlStatement = new HashMap();//��� ����
	HashMap<Integer,Object> allLine = new HashMap();//���� ��°�� �ؽ��ʿ� ����
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
 * ����� ������ ������ ������� controlStetement�� objectŸ�� value�� 
 * ���� ���� �ٸ� bean�� ������ �ִ��� �ø� �ؾ���
 * for���� �ִٸ� for���� ���õ� ��ü�� hashmap�� ��ƾ��ϰ�
 * switch���� ������ ���õ� ��ü�� �ٸ��� ����־�� �ϱ� �����̴�.
 */
	
	
}
