package com.bo.operation.numeric;

import java.util.Stack;

import com.bo.operation.IOperator;
import com.bo.operation.IValue;
import com.bo.operation.InsufficientParameterException;;

public class PushNumberOperator implements IValue {

    private double number;

    public PushNumberOperator(double number) 
    {
        this.number = number;
	}

	@Override
    public void run(Stack<IOperator> operators) throws InsufficientParameterException {
        operators.push(this);
    }

    @Override
    public void undo(Stack<IOperator> operators) {
    }

    @Override
    public double getValue() {
		return this.number;
	}
}