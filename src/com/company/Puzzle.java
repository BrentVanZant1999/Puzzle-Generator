package com.company;

import java.util.Random;

public class Puzzle {
    private Piece[][] contents;
    private int size;
    private int colorWheelSize;
    private Random myRandom;
    Puzzle(int coreSize, int activePieces, int colorWheelSize) {
        this.myRandom = new Random();
        this.size = coreSize;
        this.colorWheelSize = colorWheelSize;
        this.contents = new Piece[this.size][this.size];
    }

    public void initiate(){
        //select a random integer one though colorWheelSize
        int randomInt = this.myRandom.nextInt(colorWheelSize);
        randomInt ++;
        //populate contents with that number
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.contents[i][j].setColorVal(randomInt);
            }
        }
    }

    //randomly stimulate the puzzle
    public void randomize(){
        int randomXCord = myRandom.nextInt(this.size);
        int randomYCord = myRandom.nextInt(this.size);
        this.contents[randomXCord][randomYCord].colorSwitch(this.colorWheelSize);
        if (randomXCord + 1 < this.size) {
            this.contents[randomXCord+1][randomYCord].colorSwitch(this.colorWheelSize);
        }
        if (randomXCord - 1 > 0) {
            this.contents[randomXCord-1][randomYCord].colorSwitch(this.colorWheelSize);
        }
        if (randomYCord + 1 < this.size) {
            this.contents[randomXCord][randomYCord+1].colorSwitch(this.colorWheelSize);
        }
        if (randomYCord - 1 > 0) {
            this.contents[randomXCord][randomYCord-1].colorSwitch(this.colorWheelSize);
        }
    }

    //print out the contents of the puzzle
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
