package com.hopnwin;

import java.util.ArrayList;

public class TileCarpet {
    private ArrayList<SoftToy> tiles;
    public TileCarpet(){
        tiles = new ArrayList<SoftToy>();
        String[] toys = {"Tom","Jerry","Mickey Mouse","Thanos",
                "Donald Duck","Pluto","Courage the Cowardly Dog", "Simpson",
                "Rick","Morty","Unicorn","Plagiarism Monster",
                "Minion","Chasm Fiend","The Linux Penguin","Fudge",
                "Hooman","Monke","Tungsten","Tyrannosaurus Rex" };
        for(int i = 0; i < 20; i++){
            tiles.add(new SoftToy(toys[i]));
        }
    }
    public SoftToy getToyAt(int index){
        //Clone and return toy at an index
        SoftToy st = null;
        try{
            st = tiles.get(index).clone();
        } catch (CloneNotSupportedException e){
            //this shouldn't occur
            e.printStackTrace();
        }
        return st;
    }
}
