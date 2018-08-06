package com.company;

import java.util.Random;

public class Puzzle {
    private Piece[][] contents;
    private int size;
    private int colorWheelSize;
    private int difficulty;
    private Random myRandom;
    //main puzzle constructor
    Puzzle(int size, int difficulty, int colorWheelSize) {
        this.myRandom = new Random();
        this.size = size;
        this.colorWheelSize = colorWheelSize;
        this.difficulty = difficulty;
        this.contents = new Piece[this.size][this.size];
    }

    public void initiate(){
        //select a random integer one though colorWheelSize
        int randomInt = this.myRandom.nextInt(colorWheelSize);
        randomInt ++;
        //populate contents with that number
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.contents[i][j] = new Piece(randomInt);
            }
        }
    }

    //randomly stimulate the puzzle
    public void randomize(){
        System.out.println("---Randomizing Puzzle---");
        for (int j = 0; j <difficulty; j ++) {
            int randomXCord = myRandom.nextInt(this.size);
            int randomYCord = myRandom.nextInt(this.size);
            this.contents[randomXCord][randomYCord].colorSwitch(this.colorWheelSize);
            if (randomXCord + 1 < this.size) {
                this.contents[randomXCord + 1][randomYCord].colorSwitch(this.colorWheelSize);
            }
            if (randomXCord - 1 >= 0) {
                this.contents[randomXCord - 1][randomYCord].colorSwitch(this.colorWheelSize);
            }
            if (randomYCord + 1 < this.size) {
                this.contents[randomXCord][randomYCord + 1].colorSwitch(this.colorWheelSize);
            }
            if (randomYCord - 1 >= 0) {
                this.contents[randomXCord][randomYCord - 1].colorSwitch(this.colorWheelSize);
            }
            System.out.println("Random center touch:" + randomXCord + "," + randomYCord);
        }
    }

    //print out the contents of the puzzle in grid form
    public void print(){
        System.out.println("--Printing Puzzle--");
        for (int i = 0; i<this.size; i++){
            for (int j =0; j<this.size; j++) {
                contents[i][j].print();
            }
            System.out.println();
        }
    }
}
