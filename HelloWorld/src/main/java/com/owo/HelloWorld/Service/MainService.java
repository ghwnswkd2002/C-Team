package com.owo.HelloWorld.Service;

import java.util.HashMap;

import com.owo.HelloWorld.Buffer.CoreBuffer;

public interface MainService {

	public HashMap<String, String> splitCode(String text);
	public HashMap<String, String> methodSplit(HashMap<String, String> sc);
	public void onelineread(String code);
	public CoreBuffer allRead(HashMap<String, String> hashmap);
	
}
