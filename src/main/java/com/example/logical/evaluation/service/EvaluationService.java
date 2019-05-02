package com.example.logical.evaluation.service;

import com.example.logical.evaluations.model.Expression;
import com.example.logical.evaluations.model.GeneralConstants;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.BooleanUtils;

public class EvaluationService {

    public static void main(String args[]) {
        Expression expression1 = new Expression();
        Expression expression2 = new Expression();

        expression1.setExpressionString(GeneralConstants.EXPRESSION_1);
        expression1.setValue(false);
        expression2.setExpressionString(GeneralConstants.EXPRESSION_2);
        expression2.setValue(false);
        expression1.setNextExpression(expression2);
        expression1.setOperator(GeneralConstants.OR);
        expression2.setOperator(GeneralConstants.AND);
        expression2.setValue(false);

        if(!BooleanUtils.toBoolean(evaluate(expression1))) {
            System.out.println("Evaluation Worked");
        } else {
            System.out.println("Evaluation did not Work");
        }

    }

    public static int evaluate(Expression expression) {
        int value1 = getIntValue(expression);
        int value2;
        if(expression.getNextExpression() != null) {
          value2 = evaluate(expression.getNextExpression());
        } else {
            return value1;
        }

        if (GeneralConstants.AND.equals(expression.getOperator())) {
           return Integer.min(value1, value2);
        }
        if (GeneralConstants.OR.equals(expression.getOperator())) {
            return Integer.max(value1, value2);
        }
        return  0;
    }
    public static final int getIntValue(Expression expression) {
        return BooleanUtils.toInteger(expression.isValue());
    }

}
