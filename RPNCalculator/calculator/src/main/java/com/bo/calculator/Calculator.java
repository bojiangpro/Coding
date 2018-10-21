package com.bo.calculator;

import java.util.Stack;
import com.bo.data.IDataProvider;
import com.bo.data.IReporter;
import com.bo.operation.IOperator;
import com.bo.operation.factory.IOperatorFactory;
import com.bo.operation.InsufficientParameterException;

public class Calculator
{
    private Stack<IOperator> operators;
    private IOperatorFactory operatorFactory;

    public Calculator(IOperatorFactory operatorFactory)
    {
        this.operatorFactory = operatorFactory;
        this.operators = new Stack<>();
    }

    public void calculate(IDataProvider dataProvider, IReporter reporter)
    {
        while (dataProvider.loadInput())
        {
            while (true)
            {
                String symbol = dataProvider.getNextSymbol();
                IOperator operator = this.operatorFactory.getOperator(symbol);
                if (operator == null)
                {
                    reporter.report(operators);
                    break;
                }
                try 
                {
                    operator.run(operators);
                } 
                catch (InsufficientParameterException e) 
                {
                    String error = String.format("operator %s (position: %d): insucient parameters", 
                                                    symbol, dataProvider.getCurrentPosition());
                    reporter.report(error);
                    reporter.report(operators);
                    break;
                }
            }
        }
    }
}