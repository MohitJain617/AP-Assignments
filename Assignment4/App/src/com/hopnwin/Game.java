package com.hopnwin;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
    public static Scanner scn = new Scanner(System.in);
    private Calculator<String> stringCalc;
    private Calculator<Integer> intCalc;
    private final Player player;
    private final TileCarpet carpet;
    public Game(){
        stringCalc = null;
        intCalc = null;
        player = new Player();
        carpet = new TileCarpet();
    }
    public void startGame(){
        System.out.print("Hit enter to initialize the game");
        scn.nextLine();
        System.out.println("Game is ready");
        String[] num = {"st","nd","rd","th","th"};
        for(int i = 0; i < 5; i++){
            System.out.print("Hit enter for your "+(i+1)+num[i]+" hop.");
            scn.nextLine();
            int v = randomIntGenerator(0,21);
            if(v == 20){
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
            } else if((v+1) % 2 != 0){
                System.out.println("You landed on tile "+(v+1));
                System.out.println("Question answer round. Integer or string?");
                String entry = scn.nextLine();
                entry = entry.toLowerCase();
                while(!(entry.equals("integer") || entry.equals("string"))){
                    System.out.println("Invalid entry. Try again:");
                    entry = scn.nextLine();
                    entry = entry.toLowerCase();
                }
                if(entry.equals("integer")){
                    int arg2 = randomIntGenerator(-5000,5001);
                    int arg1 = arg2 * randomIntGenerator(-5000,5001);
                    if(arg2 == 0) arg2 = 1;
                    try {
                        if (intCalc == null) intCalc = new Calculator<Integer>(arg1, arg2);
                        else intCalc.update(arg1, arg2);
                    } catch (InvalidCalculatorException e){
                        e.printStackTrace();
                    }
                    System.out.println("Calculate the result of "+arg1+" divided by "+arg2);
                    int val = takeIntegerInput();
                    if(intCalc.checkAnswer(val)){
                        //correct
                        System.out.println("Correct Answer");
                        SoftToy x = carpet.getToyAt(v);
                        try {
                            player.addToy(x);
                            System.out.println("You won a " + x + " soft toy");
                        }
                        catch (NullPointerException e) { e.printStackTrace();}
                    } else {
                        //incorrect
                        System.out.println("Incorrect Answer");
                        System.out.println("You did not win any soft toy");
                    }
                } else {
                    String arg1 = randomStringGenerator();
                    String arg2 = randomStringGenerator();
                    try{
                        if(stringCalc == null) stringCalc = new Calculator<String>(arg1,arg2);
                        else stringCalc.update(arg1,arg2);
                    } catch (InvalidCalculatorException e){
                        e.printStackTrace();
                    }
                    System.out.println("Calculate the concatenation of Strings "+arg1 + " and "+arg2);
                    String ans = scn.nextLine();
                    if(stringCalc.checkAnswer(ans)){
                        //correct
                        System.out.println("Correct Answer");
                        SoftToy x = carpet.getToyAt(v);
                        try {
                            player.addToy(x);
                            System.out.println("You won a " + x + " soft toy");
                        }
                        catch (NullPointerException e) { e.printStackTrace();}
                    } else {
                        //incorrect
                        System.out.println("Incorrect Answer");
                        System.out.println("You did not win any soft toy");
                    }
                }
            } else {
                //always correct
                System.out.println("You landed on tile "+(v+1));
                SoftToy x = carpet.getToyAt(v);
                try {
                    player.addToy(x);
                    System.out.println("You won a " + x + " soft toy");
                }
                catch (NullPointerException e) { e.printStackTrace();}
            }
        }
        System.out.println("Game Over");
        System.out.println("Soft toys won by you are:");
        player.printSoftToys();
    }
    private int takeIntegerInput(){
        boolean done = false;
        int inp = 0;
        while(!done) {
            try {
                //using the previous scanner scn would cause infinite loop
                Scanner scint = new Scanner(System.in);
                inp = scint.nextInt();
                done = true;
                scint.close();
            } catch (InputMismatchException e){
                System.out.println("Invalid input, Try again");
            }
        }
        return inp;
    }
    private int randomIntGenerator(int low, int high){
        Random rd = new Random();
        return rd.nextInt(low,high);
    }
    private String randomStringGenerator(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            int c = randomIntGenerator(0, 26);
            int caps = randomIntGenerator(0,2);
            char ch;
            if(caps == 0) ch = (char)(c+'a');
            else ch = (char)(c+'A');
            s.append(ch);
        }
        return s.toString();
    }

    public static void main(String[] args) {
	// write your code here
        Game game = new Game();
        game.startGame();
    }
}
