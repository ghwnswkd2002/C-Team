package com.owo.HelloWorld.Service;

import java.util.HashMap;

import com.owo.HelloWorld.Buffer.CoreBuffer;

public interface MainService {

	public HashMap<String, String> splitCode(String text);
	//���� �ڵ带 ���͸� �������� ¥���� �Լ�
	
	public HashMap<String, String> methodSplit(HashMap<String, String> sc);
	//�޼ҵ� ���� �ڸ��� �Լ�
	
	public CoreBuffer allRead(HashMap<String, String> hashmap);
	// ���͸� �������� �ڸ� �ڵ带 ������
	// �������� �м��ϴ� �Լ� for�� ������ i = line 
	
	public Object lineRead(int lineNumber,String code,HashMap<String, String> splitcode,CoreBuffer corebuffer);
	// ���κ��� ���� String�� �߶� �м��ϴ� �Լ�
	
	
}
