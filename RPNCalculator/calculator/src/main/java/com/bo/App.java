package com.bo;

import com.bo.calculator.Calculator;
import com.bo.data.DataProvider;
import com.bo.data.Reporter;
import com.bo.operation.factory.DefaultOperatorFactory;

public class App 
{
    public static void main( String[] args )
    {
        var operatorFactory = new DefaultOperatorFactory();
        var dataProvider = new DataProvider(System.in);
        var reporter = new Reporter(System.out);
        var calculator = new Calculator(operatorFactory);

        calculator.calculate(dataProvider, reporter);
    }
}
