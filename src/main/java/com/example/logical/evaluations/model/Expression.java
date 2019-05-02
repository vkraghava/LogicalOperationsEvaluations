package com.example.logical.evaluations.model;

public class Expression {

    private String expressionString;
    private boolean value;
    private Expression nextExpression;
    private String operator;

    public String getExpressionString() {
        return expressionString;
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public Expression getNextExpression() {
        return nextExpression;
    }

    public void setNextExpression(Expression nextExpression) {
        this.nextExpression = nextExpression;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
