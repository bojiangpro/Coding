package com.bo.operation.factory;

import java.util.ArrayList;
import java.util.List;

import com.bo.operation.IOperator;
import com.bo.operation.numeric.NumericOperator;
import com.bo.operation.special.ClearOperaor;
import com.bo.operation.special.UndoOperator;

public class DefaultOperatorFactory implements IOperatorFactory
{
    private List<IOperatorCreater> creaters;

    public DefaultOperatorFactory()
    {
        var numberOperatorCreater = new NumberOperatorCreater();
        var symbolOperatorCreater = new SymbolOperatorCreater(){{
                registOperatorSupplier("*", () -> new NumericOperator(2, values -> values[0]*values[1]));
                registOperatorSupplier("+", () -> new NumericOperator(2, values -> values[0]+values[1]));
                registOperatorSupplier("-", () -> new NumericOperator(2, values -> values[0]-values[1]));
                registOperatorSupplier("/", () -> new NumericOperator(2, values -> values[0]/values[1]));
                registOperatorSupplier("sqrt", () -> new NumericOperator(1, values -> Math.sqrt(values[0])));
                registOperatorSupplier("undo", () -> new UndoOperator());
                registOperatorSupplier("clear", () -> new ClearOperaor());
            }};

        this.creaters = new ArrayList<IOperatorCreater>();
        this.creaters.add(numberOperatorCreater);
        this.creaters.add(symbolOperatorCreater);
    }

    public void addCreater(IOperatorCreater creater)
    {
        this.creaters.add(creater);
    }

    @Override
    public IOperator getOperator(String symbol) {
        var creater = this.creaters.stream()
                          .filter(c -> c.accept(symbol))
                          .findFirst().orElse(null);
        if (creater == null)
        {
            return null;
        }
        return creater.createOperator(symbol);
    }
    
}