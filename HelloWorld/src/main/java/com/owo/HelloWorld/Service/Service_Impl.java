package com.owo.HelloWorld.Service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.owo.HelloWorld.Buffer.CodeBuffer;
import com.owo.HelloWorld.Buffer.CoreBuffer;

@Service
public class Service_Impl implements MainService{
    
    @Inject
	CodeBuffer codebuffer;
	
	@Override
	public HashMap<String, String> splitCode(String text) {
	    System.out.println("서비스부분"+text);
	    HashMap<String, String> res = new HashMap<String, String>();
	   res = codebuffer.splitCode(text);
		return res;
	}

	@Override
	public HashMap<String, String> methodSplit(HashMap<String, String> sc) {
		return codebuffer.methodSplit(sc);
	}

	@Override
	public void onelineread(String code) {
		codebuffer.onelineread(code);
		
	}

	@Override
	public CoreBuffer allRead(HashMap<String, String> hashmap) {
		return codebuffer.allRead(hashmap);
		
	}

}
