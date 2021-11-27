package com.hopnwin;

import java.util.ArrayList;

public class Player {
    private ArrayList<SoftToy> bucket;
    public Player(){
        bucket = new ArrayList<SoftToy>();
    }
    public void addToy(SoftToy st){
        if(st == null) throw new NullPointerException();
        bucket.add(st);
    }
    public void printSoftToys(){
        int len = bucket.size();
        for(int i = 0; i < len-1; i++){
            System.out.print(bucket.get(i)+", ");
        }
        System.out.print(bucket.get(len-1));
        System.out.println();
    }
}
