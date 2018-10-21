package com.bo.operation;

import com.bo.operation.IOperator;

public interface IOperatorCreater
{
    boolean accept(String symbol);

    IOperator createOperator(String symbol);
}