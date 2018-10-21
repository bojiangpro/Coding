package com.bo.calculator;

import com.bo.data.DataProvider;
import com.bo.data.IDataProvider;
import com.bo.data.IReporter;
import com.bo.data.Reporter;
import com.bo.operation.factory.DefaultOperatorFactory;
import com.bo.operation.factory.IOperatorFactory;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalculatorTest
{
    private Calculator calculator;

    @Before
    public void setUp() throws Exception 
    {
        IOperatorFactory operatorFactory = new DefaultOperatorFactory();
        this.calculator = new Calculator(operatorFactory);
    }

    @Test
    public void test1()
    {
        String[] inputs = new String[]{"5 2"};
        String[] outputs = new String[]{"5 2"};
        testValue(inputs, outputs);
    }

    @Test
    public void test2()
    {
        String[] inputs = new String[]{"2 sqrt", "clear    9 sqrt"};
        String[] outputs = new String[]{"1.4142135623", "3"};
        testValue(inputs, outputs);
    }

    @Test
    public void test3()
    {
        String[] inputs = new String[]{"5 2  -", "3 - ", "clear"};
        String[] outputs = new String[]{"3", "0", ""};
        testValue(inputs, outputs);
    }

    @Test
    public void test4()
    {
        String[] inputs = new String[]{"5 4 3 2", "undo undo *","5 *","undo "};
        String[] outputs = new String[]{"5 4 3 2","20", "100", "20 5"};
        testValue(inputs, outputs);
    }

    @Test
    public void test5()
    {
        String[] inputs = new String[]{"7 12 2 /", "*","4 /"};
        String[] outputs = new String[]{"7 6","42", "10.5"};
        testValue(inputs, outputs);
    }

    @Test
    public void test6()
    {
        String[] inputs = new String[]{"1 2 3 4 5", "*","clear 3 4 - "};
        String[] outputs = new String[]{"1 2 3 4 5", "1 2 3 20", "-1"};
        testValue(inputs, outputs);
    }

    @Test
    public void test7()
    {
        String[] inputs = new String[]{"1 2 3 4 5", "* * * *"};
        String[] outputs = new String[]{"1 2 3 4 5", "120"};
        testValue(inputs, outputs);
    }

    @Test
    public void test8()
    {
        String[] expected = new String[]
        {
            "operator * (position: 15): insucient parameters",
            getExpected("11")
        };
        test(new String[]{"1 2 3 * 5 + * * 6 5"}, expected);
    }

    @Test
    public void testPrecision()
    {
        String[] inputs = new String[]{"1 3", "/", "5 /", "7 /"};
        String[] outputs = new String[]{"1 3", "0.333333333333333", "0.066666666666666", "0.009523809523809"};
        DecimalFormat format = new DecimalFormat("#.###############");
        format.setRoundingMode(RoundingMode.FLOOR);
        testValue(inputs, outputs, format);
    }

    private void testValue(String[] inputs, String[] values)
    {
        testValue(inputs, values, null);
    }

    private void testValue(String[] inputs, String[] values, DecimalFormat format)
    {
        for (int i = 0; i < values.length; i++) 
        {
            values[i] = getExpected(values[i]);
        }
        test(inputs, values, format);
    }

    private void test(String[] inputs, String[] expected)
    {
        test(inputs, expected, null);
    }

    private void test(String[] inputs, String[] expected, DecimalFormat format)
    {
        InputStream in = new ByteArrayInputStream(String.join(System.lineSeparator(), inputs).getBytes());
        OutputStream out = new ByteArrayOutputStream();
        IDataProvider dataProvider = new DataProvider(in);
        IReporter reporter = format == null ? new Reporter(new PrintStream(out)) 
                                            : new Reporter(new PrintStream(out), format);
        
        this.calculator.calculate(dataProvider, reporter);

        String[] actual = out.toString().split(System.lineSeparator());

        assertArrayEquals(expected, actual);
    }

    private static String getExpected(String value)
    {
        return "stack: "+value;
    }
}
