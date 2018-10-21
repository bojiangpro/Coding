package com.bo.data;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProvider implements IDataProvider {
    
    private static Pattern pattern;
    private int index;
    private Matcher matcher;
    private Scanner scanner;

    static
    {
        pattern = Pattern.compile("[^\\s]+");
    }

    public DataProvider(InputStream inputStream)
    {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public boolean loadInput() 
    {
        try 
        {
            var rawData = this.scanner.nextLine();
            this.matcher = pattern.matcher(rawData);
            this.index = 0;
            return true;
        } 
        catch(NoSuchElementException e) 
        {
            this.scanner.close();
            return false;
        }
        catch(IllegalStateException e)
        {
            return false;
        }
    }

    @Override
    public int getCurrentPosition() 
    {
        return this.index;
    }

    @Override
    public String getNextSymbol() 
    {
        if (matcher.find(this.index))
        {
            this.index = matcher.end();
            return matcher.group();
        }
        return null;
    }
}