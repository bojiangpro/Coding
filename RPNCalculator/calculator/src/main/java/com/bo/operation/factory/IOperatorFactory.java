package com.bo.operation.factory;

import com.bo.operation.IOperator;

public interface IOperatorFactory 
{
    IOperator getOperator(String symbol);
}