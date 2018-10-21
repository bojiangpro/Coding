package com.bo.data;

import java.util.Stack;

import com.bo.operation.IOperator;

public interface IReporter {
    void report(Stack<IOperator> stack);

    void report(String error);
}