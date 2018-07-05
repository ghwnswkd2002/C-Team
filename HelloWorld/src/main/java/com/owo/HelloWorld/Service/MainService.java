package com.owo.HelloWorld.Service;

import java.util.HashMap;

import com.owo.HelloWorld.Buffer.CoreBuffer;

public interface MainService {

	public HashMap<Integer, String> splitCode(String text);
	public HashMap<Integer, String> methodSplit(HashMap<Integer, String> sc);
	public void onelineread(String code);
	public CoreBuffer allRead(HashMap<Integer, String> hashmap);
	
}
