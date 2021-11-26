package com.hopnwin;

public class SoftToy implements Cloneable {
    private final String name;
    public SoftToy(String s){
        this.name = s;
    }
    @Override
    public SoftToy clone() throws CloneNotSupportedException{
        return (SoftToy)super.clone();
    }
    @Override
    public String toString(){
        return this.name;
    }
}
