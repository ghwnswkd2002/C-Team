package com.owo.HelloWorld.Buffer.Bean;

public class ForBean {
	
	private String paramName;			//변수 명
    private String initialValue;		//초기값
    private String signOfInequality;   	//부등호
    private String SOIValue;			//부등호 다음에 오는 값 (ex) a<10 에서 10을 의미)
    private String operator;			//증감연산자
    private String error;				//오류인지 아닌지 
    private int loopNumber;			//반복 횟수
    
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
