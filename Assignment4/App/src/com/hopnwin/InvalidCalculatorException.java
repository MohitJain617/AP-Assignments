package com.hopnwin;

public class InvalidCalculatorException extends Exception{
    public InvalidCalculatorException(String msg){
        super(msg);
    }
    public InvalidCalculatorException(){
        super("Not supported Datatype");
    }
}
