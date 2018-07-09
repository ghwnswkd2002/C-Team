package com.owo.HelloWorld.Buffer;

import java.util.HashMap;

import com.owo.HelloWorld.Buffer.Bean.MethodBean;
import com.owo.HelloWorld.Buffer.Bean.ParamBean;

public interface CodeBuffer {
	
	public ParamBean case_VariableDeclaration(int lineNumber,String line); 
	public MethodBean case_functionDefine(int lineNumber,String line,HashMap<String,String> splitcode);
	
}
