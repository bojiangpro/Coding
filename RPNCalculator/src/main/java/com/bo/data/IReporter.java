package com.bo.data;

import java.util.List;

import com.bo.operation.IValue;

public interface IReporter 
{
    void report(List<IValue> values);

    void report(String error);
}