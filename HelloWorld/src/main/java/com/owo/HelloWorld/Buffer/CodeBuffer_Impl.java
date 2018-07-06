package com.owo.HelloWorld.Buffer;

import org.springframework.stereotype.Repository;

import com.owo.HelloWorld.Buffer.Bean.ParamBean;
import com.owo.HelloWorld.Buffer.Enum.ParameterType;
@Repository
public class CodeBuffer_Impl implements CodeBuffer{
	/*
	 * service���� �θ�
	 * 
	 * �ַ� line�� ���� ���� �д� ����
	 * ���� ���� �о hashmap���� ��ȯ�ϰų� ��ü�� ��ȯ�ؼ� service���� ���ļ�  controller�� ������
	 * ���⼭�� ������ �ϳ��ϳ� �д� ����� ���� �����ؼ� �Լ� ����� �����
	 * 	1. ù ���ڰ� ���������� ��
	 *		- ���� ����		- �Լ� ����
	 *	2. ��� ���
	 *		- �ݺ���			- ���
	 *	3. �����Լ�
	 *		- printf/scanf	- ��Ÿ
	 *	4. ��Ÿ(���� ���� �� ����);	
	 */
	
	
	ParameterType parameterType;//enum������
	ParamBean param;

	
	
	public ParamBean case_VariableDeclaration(String line) {
		
		//String line ="char name;"
		System.out.println("���̽� �������� ����");
		String[] dev = line.split(" ");
		param = new ParamBean();
		
		System.out.println(line +"���� �����κ� ������");
		
		for(int i=0;i<dev.length;i++) {
			System.out.println(dev[i]);
		}
		
		if(parameterType.values().equals(dev[0])&&!line.contains("=")) {
			//enum �ȿ� �ִ� Strind�� split�� �迭 ù��°�� ������ �ִ��� Ȯ��
			//�ٵ� �ʱ갪 �����ȵǾ� �ִ� ���
			//EX. int a;
			
			param.setParamType(dev[0]);
			param.setParamName(dev[1].substring(0,dev[1].length()-1));
		} else if(parameterType.values().equals(dev[0])&&line.contains("=")) {
			//enum �ȿ� �ִ� String�� split�� �迭 ù��°�� ������ �ִ��� Ȯ��
			//�ٵ� �ʱ갪 ���� �Ǿ� ����
			//EX. int a = 40;
			param.setParamType(dev[0]);
			String[] temp = dev[1].split("=");//=�� ������ �ٽ� �ڸ���
			
			
			param.setParamName(temp[0]);
			param.setParamValue(temp[1].substring(0,dev[1].length()-1));
		}
		
		return param;
	}
	
	
}
