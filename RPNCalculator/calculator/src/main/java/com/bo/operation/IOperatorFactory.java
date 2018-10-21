package com.bo.operation;

import com.bo.operation.IOperator;

public interface IOperatorFactory 
{
    IOperator getOperator(String symbol);
}