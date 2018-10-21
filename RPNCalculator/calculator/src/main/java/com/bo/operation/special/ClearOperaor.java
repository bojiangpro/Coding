package com.bo.operation.special;

import java.util.Stack;

import com.bo.operation.IOperator;
import com.bo.operation.InsufficientParameterException;

public class ClearOperaor implements IOperator {

    private Stack<IOperator> clearedOperators;
    @Override
    public void run(Stack<IOperator> operators) throws InsufficientParameterException 
    {
        this.clearedOperators = new Stack<IOperator>();
        while(!operators.isEmpty())
        {
            clearedOperators.push(operators.pop());
        }
        operators.push(this);
    }

    @Override
    public void undo(Stack<IOperator> operators) 
    {
        while(!this.clearedOperators.isEmpty())
        {
            operators.push(this.clearedOperators.pop());
        }
    }
}