package com.bo.data;

public interface IDataProvider
{
    boolean loadInput();
    
    String getNextSymbol();

    int getCurrentPosition();
}
