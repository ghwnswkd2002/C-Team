package com.owo.HelloWorld.Buffer.Bean;

public class ForBean {
	
	private String paramName;			//���� ��
    private String initialValue;		//�ʱⰪ
    private String signOfInequality;   	//�ε�ȣ
    private String SOIValue;			//�ε�ȣ ������ ���� �� (ex) a<10 ���� 10�� �ǹ�)
    private String operator;			//����������
    private String error;				//�������� �ƴ��� 
    private int loopNumber;			//�ݺ� Ƚ��
    
	public int getLoopNumber() {
		return loopNumber;
	}
	public void setLoopNumber(int loopNumber) {
		this.loopNumber = loopNumber;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getInitialValue() {
		return initialValue;
	}
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}
	public String getSignOfInequality() {
		return signOfInequality;
	}
	public void setSignOfInequality(String signOfInequality) {
		this.signOfInequality = signOfInequality;
	}
	public String getSOIValue() {
		return SOIValue;
	}
	public void setSOIValue(String sOIValue) {
		SOIValue = sOIValue;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

}
