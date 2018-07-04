package com.owo.HelloWorld.Buffer;

import java.util.ArrayList;
import java.util.HashMap;

import com.owo.HelloWorld.Buffer.Bean.ParamBean;

public class CodeBuffer {
	/* 
	 * �ھ� ���ۿ� �Ѳ����� ��Ƽ� ��ü�� ������ �����̱� ������
	 * ���� ���۱��� ���� �ʿ䰡 ���� ���� �ֱ⶧��
	 * ����� �ڵ� ���θ� ��Ƽ� �ٷ� core�� ������ �Լ��� ���� �����.
	 * line���� ���ø��� �ؽø��� ���μ���� �������ʰ˻��ϸ鼭
	 * corebuffer�� �ִ� �ؽøʿ� �ٽ� ����ִ� �۾��� �ǽ��Ѵ�.
	 */



	public HashMap<Integer, String> splitCode(String text) {
		System.out.println("split ����");
		HashMap<Integer, String> res = new HashMap<Integer, String>();
		if(text != null) { 								//�ؽ�Ʈ �� �ƴϸ�
			String[] sp = text.split("\n"); 			// �ڸ���
			for(int i = 0; i < sp.length; i++) { 		//��������
				res.put((i+1), sp[i]); 					//res�ؽ��ʿ� �־�
				System.out.println(res.get(i+1)); 		//���
			}
			return res; 								//��Ʈ�ѷ����� �ҷ���; ;;������
		}
		return null;
	}




	public HashMap<Integer, String>  methodSplit(HashMap<Integer, String> sc){ //�޼ҵ� �߶� ���̴°���

		HashMap<Integer, String> res = new HashMap<Integer, String>();	//�ؽ�����
		ArrayList list = new ArrayList();								//���� ������ ������ get�Ѱ� ���� ����Ʈ��
		String result; 										//�������
		ArrayList<Integer> start = new ArrayList<Integer>(); 			//���۶��� ��̸���Ʈ��
		ArrayList<Integer> end = new ArrayList<Integer>(); 				//�������� ����
		//String[] msd = null; 											//msd�迭�� null�� �ʱ�ȭ ���� �ϴ��ּ�
		int Sindex = 0; 									//��ŸƮ�ε���
		int Eindex = 0;										//���ε���
		int Toindex = 0; 									//�� �ε���
		int startcbcnt = 0;									//���� �߰�ȣ { ī��Ʈ
		int endcbcnt = 0;									//�ݴ� �߰�ȣ } ī��Ʈ
		
		for(int i=0; i<sc.size(); i++) { 								//�������� for����!
			if(sc.get(i+1).contains("{")) {
				startcbcnt++;
			}
			if(sc.get(i+1).contains("}")) {
				endcbcnt++;
			}
			
			if((startcbcnt-endcbcnt)==1&&sc.get(i+1).contains("(")&&!sc.get(i+1).contains(";")) { //���࿡~����~
				System.out.println("���۶��� Ȯ��"); 						//�� ��
				start.add(i+1); 										//��ŸƮ �־���
				list.add(sc.get(i+1)); 									//����Ʈ�� �־� if���� �ɸ��°�
				System.out.println("���۶���"+list.get(Toindex)+"���ι�ȣ = "+start.get(Sindex)); //���R��
				Sindex++; 												//��
				Toindex++; 												//��
			}
			if((startcbcnt==endcbcnt)&&sc.get(i+1).contains("}")) { 							//��ã��

				System.out.println("������ üũ");
				end.add(i+1); 											//end ����Ʈ�� ����
				list.add(sc.get(i+1)); 									// ������ ����
				System.out.println("������"+list.get(Toindex) + "���ι�ȣ = " +end.get(Eindex));
				Eindex++; 												//��
				Toindex++; 												//to the ��
			}
			
		}


		for(int ind = 0; ind<end.size(); ind++) { 						//�������� for����!
			result = ""; 												//result�� �ʱ�ȭ
			for(int st=start.get(ind); st<end.get(ind)+1; st++) { 		//�Լ��������� ����� ���� �ѹ� �� ����
				result +=sc.get(st)+"\n";								//���� ������ �ٿ��ش�
				System.out.println("���� ���̱� ="+result); 
			}
			res.put((ind+1), result); 									//res�� �־���
			System.out.println((ind+1)+"�� ��");
		}

		System.out.println("LineBuffer\n"+res.get(1));
		System.out.println("LineBuffer\n"+res.get(2));
		for(int i=0; i<sc.size();i++) { 								//����Ȯ���Ϸ��� ������
			System.out.println(i+1+"��° ���� = "+sc.get(i+1));
		}
		return res;
	}


}
