package com.owo.HelloWorld.Buffer;

import java.util.HashMap;

import com.owo.HelloWorld.Buffer.Bean.ParamBean;

public class CoreBuffer {
	/*
	 * ����� ������ ������ ������� controlStetement�� objectŸ�� value�� 
	 * ���� ���� �ٸ� bean�� ������ �ִ��� �ø� �ؾ���
	 * for���� �ִٸ� for���� ���õ� ��ü�� hashmap�� ��ƾ��ϰ�
	 * switch���� ������ ���õ� ��ü�� �ٸ��� ����־�� �ϱ� �����̴�.
	 */
	
	HashMap<String,Object> param = new HashMap();		//���� ����
	HashMap<String,Object> method = new HashMap();		//�Լ� ����
	HashMap<String,Object> controlStatement = new HashMap();//��� ����
	HashMap<String,Object> allLine = new HashMap();//���� ��°�� �ؽ��ʿ� ����
	
	public HashMap<String, Object> getParam() {
		return param;
	}
	public void setParam(String string,Object pb) {
		System.out.println(pb+"���Ķ� ���� "+string);
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
