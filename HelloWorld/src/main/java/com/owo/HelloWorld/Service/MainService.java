package com.owo.HelloWorld.Service;

import java.util.HashMap;

import com.owo.HelloWorld.Buffer.CoreBuffer;

public interface MainService {

	public HashMap<String, String> splitCode(String text);
	//들어온 코드를 엔터를 기준으로 짜르는 함수
	
	public HashMap<String, String> methodSplit(HashMap<String, String> sc);
	//메소드 별로 자르는 함수
	
	public CoreBuffer allRead(HashMap<String, String> hashmap);
	// 엔터를 기준으로 자른 코드를 가지고
	// 한줄한줄 분석하는 함수 for문 돌려서 i = line 
	
	public Object lineRead(int lineNumber,String code,HashMap<String, String> splitcode,CoreBuffer corebuffer);
	// 라인별로 들어온 String을 잘라서 분석하는 함수
	
	
}
