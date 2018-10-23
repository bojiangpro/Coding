package com.bo.operation;

import java.util.Stack;

public interface IOperator
{
    void run(Stack<IOperator> operators) throws InsufficientParameterException;

    void undo(Stack<IOperator> operators);
}