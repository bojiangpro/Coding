package com.bo.operation.numeric;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.bo.operation.IOperator;
import com.bo.operation.IValue;
import com.bo.operation.InsufficientParameterException;
import java.util.function.Function;;;

public class NumericOperator implements IValue
{

    private List<IValue> values;
    private int number;
    private Function<double[], Double> compute;
    private double value;

    public NumericOperator(int requiredValues, Function<double[],Double> compute)
    {
        this.number = requiredValues;
        this.compute = compute;
    }

    @Override
    public void run(Stack<IOperator> operators) throws InsufficientParameterException 
    {
        var size = operators.size();
        if (size < this.number)
        {
            throw new InsufficientParameterException();
        }
        var offset = size-this.number;
        var ops = IntStream.range(0, this.number)
                            .mapToObj(i -> operators.get(offset+i))
                            .filter(o -> o instanceof IValue)
                            .map(v -> (IValue)v)
                            .collect(Collectors.toList());
        if (ops.size() < this.number)
        {
            throw new InsufficientParameterException();
        }
        for (int i = 0; i < this.number; i++) {
            operators.pop();
        }
        this.values = ops;

        var values = this.values.stream()
                                   .mapToDouble(o -> o.getValue()).toArray();
        this.value = this.compute.apply(values);
        operators.push(this);
    }

    @Override
    public void undo(Stack<IOperator> operators) 
    {
        for (var value : this.values) 
        {
            operators.push(value);
        }
    }

    @Override
    public double getValue() 
    {
		return this.value;
	}

}