package com.bo.operation;

import java.util.HashMap;
import java.util.function.Supplier;

import com.bo.operation.IOperator;

class SymbolOperatorCreater implements IOperatorCreater
{
    private HashMap<String, Supplier<IOperator>> operators;

    public SymbolOperatorCreater()
    {
        this.operators = new HashMap<>();
    }

    @Override
    public boolean accept(String symbol) 
    {
        return this.operators.containsKey(symbol);
    }

    @Override
    public IOperator createOperator(String symbol) 
    {
        return this.operators.get(symbol).get();
    }

    public boolean registOperatorSupplier(String symbol, Supplier<IOperator> supplier)
    {
        if (this.operators.containsKey(symbol))
        {
            return false;
        }
        this.operators.put(symbol, supplier);
        return true;
    }
}