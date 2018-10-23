package com.bo.operation.special;

import java.util.Stack;

import com.bo.operation.IOperator;
import com.bo.operation.InsufficientParameterException;

public class UndoOperator implements IOperator {

    @Override
    public void run(Stack<IOperator> operators) throws InsufficientParameterException 
    {
        if(operators.isEmpty())
        {
            return;
        }
        IOperator operator = operators.pop();
        operator.undo(operators);
    }

    @Override
    public void undo(Stack<IOperator> operators) 
    {
    }
}