package com.owo.HelloWorld.Buffer;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.owo.HelloWorld.Buffer.Bean.MethodBean;
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
	 *
	 *	2. ��� ���
	 *		- �ݺ���			- ���
	 *
	 *	3. �����Լ�
	 *		- printf/scanf	- ��Ÿ
	 *
	 *	4. ��Ÿ(���� ���� �� ����);
	 *
	 */


	//ParameterType parameterType;//enum������
	ParamBean param;
	MethodBean method;

	@Override		//���� ����κ� ������ ���
	public ParamBean case_VariableDeclaration(int lineNumber,String line) {

		//String line ="char name;"
		System.out.println("���̽� �������� ����");
		String[] dev = line.split(" ");
		param = new ParamBean();

//		System.out.println(line +"���� �����κ� ������");
//		for(int i = 0; i<dev.length; i++) {
//			System.out.println("dev"+i+"="+dev[i]);
//		}
		
		for(ParameterType parameterType : ParameterType.values()) {//�Ϲ������ξȶ��� �����Ѱ��
			System.out.println("for�� ����");
			if(dev[0].toUpperCase().equals(parameterType.toString())&&!line.contains("=")) {
				System.out.println("if��");
				//enum �ȿ� �ִ� Strind�� split�� �迭 ù��°�� ������ �ִ��� Ȯ��
				//�ٵ� �ʱ갪 �����ȵǾ� �ִ� ���
				//EX. int a;
				//toUpperCase() �̰Ŵ� �ҹ��ڸ� �빮�ڷ� �ٲٴ� �Լ�
				System.out.println(dev[0]+"�̰� ������ �ʱ�ȭ ���ص���°ž� ");
				param.setParamType(dev[0]);
				param.setParamName(dev[1].replaceAll(";",""));
				
			} else if(dev[0].toUpperCase().equals(parameterType.toString())&&line.contains("=")) {
				//�ʱ�ȭ �ؼ� ������ ���
				System.out.println("else if��");
				//enum �ȿ� �ִ� String�� split�� �迭 ù��°�� ������ �ִ��� Ȯ��
				//�ٵ� �ʱ갪 ���� �Ǿ� ����
				//EX. int a = 40;
				param.setParamType(dev[0]);
				System.out.println("setParamType============dev[0]�� ����");
				String[] temp = dev[1].split("=");//=�� ������ �ٽ� �ڸ���
				System.out.println("dev[1] "+dev[1]);
				System.out.println("temp0  "+temp[0]);
				System.out.println("temp1  "+temp[1]);
				System.out.println("=���� �ڸ�");
				param.setParamName(temp[0]);
				System.out.println("temp[0]�� ����");
				param.setParamLine(String.valueOf(lineNumber));
				param.setParamValue(temp[1].replaceAll(";",""));
				System.out.println("��");
			}
			//�ʱ�ȭ �Ҷ� ����� ����� ���
			else if(dev[0].toUpperCase().equals(parameterType.toString())&&line.contains("=")&&dev.length>2) {
				
			}
			//�ʱ�ȭ �� ������ char�� ���ڿ� ��������
			else if(dev[0].equals("char")) {
				
			}
			//������ �ΰ��
			
			
		}
		return param;
	}



	@Override		//�Լ����Ǻκ� ������ ���
	public MethodBean case_functionDefine(int lineNumber,String line,HashMap<String,String> splitcode) {
		method = new MethodBean();
		String[] dev = line.split(" ");
		//EX. int method(int a,int b);
		
		
		
		
		
		
		
		return method;
	}
	
	


}
