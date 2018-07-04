package com.owo.HelloWorld.Buffer.Bean;

import java.util.HashMap;

public class MethodBean {
	
	private String m_Name;
	private String m_Line;
	private String m_ExecuteLine;
	private String m_ReturnType;
	private String m_ReturnValue;
	HashMap<Integer,String> allOfMethodCode = new HashMap<Integer,String>();
	
	public HashMap<Integer, String> getAllOfMethodCode() {
		return allOfMethodCode;
	}
	public void setAllOfMethodCode(HashMap<Integer, String> allOfMethodCode) {
		this.allOfMethodCode = allOfMethodCode;
	}
	public String getM_Name() {
		return m_Name;
	}
	public void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}
	public String getM_Line() {
		return m_Line;
	}
	public void setM_Line(String m_Line) {
		this.m_Line = m_Line;
	}
	public String getM_ExecuteLine() {
		return m_ExecuteLine;
	}
	public void setM_ExecuteLine(String m_ExecuteLine) {
		this.m_ExecuteLine = m_ExecuteLine;
	}
	public String getM_ReturnType() {
		return m_ReturnType;
	}
	public void setM_ReturnType(String m_ReturnType) {
		this.m_ReturnType = m_ReturnType;
	}
	public String getM_ReturnValue() {
		return m_ReturnValue;
	}
	public void setM_ReturnValue(String m_ReturnValue) {
		this.m_ReturnValue = m_ReturnValue;
	}
}
