package com.owo.HelloWorld.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import com.owo.HelloWorld.Buffer.CodeBuffer;
import com.owo.HelloWorld.Buffer.CoreBuffer;

@Service
public class Service_Impl implements MainService{

	CodeBuffer codebuffer;
	
	@Override
	public HashMap<Integer, String> splitCode(String text) {
		return codebuffer.splitCode(text);
	}

	@Override
	public HashMap<Integer, String> methodSplit(HashMap<Integer, String> sc) {
		return codebuffer.methodSplit(sc);
	}

	@Override
	public void onelineread(String code) {
		codebuffer.onelineread(code);
		
	}

	@Override
	public CoreBuffer allRead(HashMap<Integer, String> hashmap) {
		return codebuffer.allRead(hashmap);
		
	}

}
