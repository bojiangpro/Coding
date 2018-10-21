package com.bo.data;

import java.util.List;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

import com.bo.operation.IValue;

public class Reporter implements IReporter {

    private PrintStream out;
    private DecimalFormat format;
    public Reporter(PrintStream out) 
    {
        this(out, getDefaultFormat());
    }

    public Reporter(PrintStream out, DecimalFormat format) 
    {
        this.out = out;
        this.format = format;
    }
    
    private static DecimalFormat getDefaultFormat()
    {
        DecimalFormat format = new DecimalFormat("#.##########");
        format.setRoundingMode(RoundingMode.FLOOR);
        return format;
    }

	@Override
    public void report(List<IValue> stack) 
    {
        String report = stack.stream().map(r -> format.format((r.getValue())))
                            .collect(Collectors.joining(" "));
                            
        out.println("stack: " + report);
    }

	@Override
    public void report(String error) 
    {
		out.println(error);
	}
    
}