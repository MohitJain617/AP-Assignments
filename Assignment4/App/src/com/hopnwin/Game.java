package com.hopnwin;

import java.util.Scanner;

public class Game {
    public static Scanner scn = new Scanner(System.in);
    private Calculator<String> stringCalc;
    private Calculator<Integer> intCalc;
    public Game(){
        stringCalc = null;
        intCalc = null;
    }

    public static void main(String[] args) {
	// write your code here
        Game game = new Game();
    }
}
