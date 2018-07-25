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
	
	HashMap<String,ParamBean> param = new HashMap<String,ParamBean>();		//���� ����
	HashMap<String,Object> method = new HashMap<String,Object>();		//�Լ� ����
	HashMap<String,Object> controlStatement = new HashMap<String,Object>();//��� ����
	HashMap<String,Object> allLine = new HashMap<String,Object>();//���� ��°�� �ؽ��ʿ� ����
	HashMap<String,String> allOfLine = new HashMap<String,String>();
	
	public HashMap<String, String> getAllOfLine() {
		return allOfLine;
	}
	public void setAllOfLine(String key,String value) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~������");
		allOfLine.put(key, value);
	}
    public HashMap<String, ParamBean> getParam() {
		return param;
	}
	public void setParam(String string,ParamBean pb) {
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
