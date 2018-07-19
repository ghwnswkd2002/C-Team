package com.owo.HelloWorld.Buffer.Bean;

public class ParamBean {

    private String paramName;
    private String paramType;
    private String paramValue;
    private String paramLine;

    private String pointValue; // 포인터인 경우 값을 출력

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamLine() {
        return paramLine;
    }

    public void setParamLine(String paramLine) {
        this.paramLine = paramLine;
    }

    public String getPointValue() {
        return this.pointValue;
    }

    public void setPointValue(String pointValue) {
        this.pointValue = pointValue;
    }

    @Override
    public String toString() {

        return getParamLine() + " " + getParamType() + " " + getParamName() + " " + getParamValue();

    }
}
