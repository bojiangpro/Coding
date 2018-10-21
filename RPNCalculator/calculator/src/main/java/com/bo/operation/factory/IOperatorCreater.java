package com.bo.operation.factory;

import com.bo.operation.IOperator;

public interface IOperatorCreater
{
    boolean accept(String symbol);

    IOperator createOperator(String symbol);
}