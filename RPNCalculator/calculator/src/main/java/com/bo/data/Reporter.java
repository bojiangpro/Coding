package com.bo.data;

import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;
import java.util.stream.Collectors;

import com.bo.operation.IOperator;
import com.bo.operation.IValue;

public class Reporter implements IReporter {

    private PrintStream out;
    private DecimalFormat format;
    public Reporter(PrintStream out) 
    {
        this.out = out;
        this.format = new DecimalFormat("#.##########");
        this.format.setRoundingMode(RoundingMode.FLOOR);
	}

	@Override
    public void report(Stack<IOperator> stack) 
    {
        String report = stack.stream().filter(r -> r instanceof IValue)
                            .map(r -> format.format(((IValue)r).getValue()))
                            .collect(Collectors.joining(" "));
                            
        out.println("stack: " + report);
    }

	@Override
    public void report(String error) 
    {
		out.println(error);
	}
    
}