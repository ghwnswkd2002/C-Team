package com.owo.HelloWorld.Buffer.LineRead;

import org.springframework.stereotype.Repository;

import com.owo.HelloWorld.Buffer.Bean.ParamBean;
import com.owo.HelloWorld.Buffer.Enum.ParameterType;

@Repository
public class LineRead {

	ParameterType parameterType;
	ParamBean paramBean;
	
	
	public ParamBean case_VariableDeclaration(String line) {
		//String line = "char name;";
		System.out.println("���̽� ����");
		String[] dev = line.split(" ");
		paramBean = new ParamBean();
		
		System.out.println(line + "���� ��������κ� ������?");
		
		for(int i=0;i<dev.length;i++) {
		System.out.println(dev[i]);
		}
		if(parameterType.values().equals(dev[0])&&!line.contains("=")) {
			//enum�ȿ� �ִ� String�� split�� �迭 ù��°�� ������ �ִ��� Ȯ�� �ٵ� �ʱ갪 �����ȵ��ִ°��
			System.out.println("������"+dev[0]);
			paramBean.setParamType(dev[0]);
			paramBean.setParamName(dev[1].substring(0,dev[1].length()-1));
			
		} else if (parameterType.values().equals(dev[0])&&line.contains("=")) {
			//enum�ȿ� �ִ� String�� split�� �迭 ù��°�� ������ �ִ��� Ȯ��   �ʱ갪 ���� �Ǿ��ִ°��
			System.out.println("��������"+dev[1]);
			paramBean.setParamType(dev[0]);
			paramBean.setParamName(dev[1].substring(0,dev[1].length()-1));
			
			
		}
		return paramBean;
	}
}
