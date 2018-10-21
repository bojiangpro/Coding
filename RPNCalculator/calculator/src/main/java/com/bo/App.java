package com.bo;

import com.bo.calculator.Calculator;
import com.bo.data.DataProvider;
import com.bo.data.IDataProvider;
import com.bo.data.IReporter;
import com.bo.data.Reporter;
import com.bo.operation.factory.DefaultOperatorFactory;
import com.bo.operation.factory.IOperatorFactory;

public class App 
{
    public static void main( String[] args )
    {
        IOperatorFactory operatorFactory = new DefaultOperatorFactory();
        IDataProvider dataProvider = new DataProvider(System.in);
        IReporter reporter = new Reporter(System.out);
        Calculator calculator = new Calculator(operatorFactory);

        calculator.calculate(dataProvider, reporter);
    }
}
