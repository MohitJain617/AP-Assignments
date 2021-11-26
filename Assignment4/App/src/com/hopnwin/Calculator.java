package com.hopnwin;

public class Calculator <T>{
    private T arg1;
    private T arg2;
    public Calculator(T arg1, T arg2) throws InvalidCalculatorException{
        if((arg1 == null) || (arg2 == null)) throw new NullPointerException();
        if((arg1.getClass() == String.class) || (arg1.getClass() == Integer.class)){
            this.arg1 = arg1;
            this.arg2 = arg2;
        } else {
            throw new InvalidCalculatorException();
        }
    }
    public void Update(T arg1, T arg2){
        if((arg1 == null) || (arg2 == null)) throw new NullPointerException();
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    public boolean checkAnswer(T result){
        if(result == null){
            throw new NullPointerException();
        }
        if(result.getClass() == String.class){
            String answer = (String)arg1+arg2;
            return result.equals(answer);
        } else {
            //This calculator can only be either of type String or Integer,
            //so after checking if it is not String then its Integer
            if((Integer)arg2 == 0) throw new ArithmeticException();
            int answer = (Integer)arg1 / (Integer)arg2;
            return answer == (Integer)result;
        }
    }
}
