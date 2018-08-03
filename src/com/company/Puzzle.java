package com.company;

import java.util.Random;

public class Puzzle {
    private Piece[][] contents;
    private int coreSideSize;
    private int activePieces;
    private int sideSize;
    private int colorWheelSize;
    private Random myRandom;
    Puzzle(int coreSize, int activePieces, int colorWheelSize) {
        thissmyRandom = newRandom();
        this.coreSideSize = coreSize;
        this.activePieces = activePieces;
        this.colorWheelSize = colorWheelSize;
        this.sideSize = this.coreSideSize;
        if (this.activePieces > coreSideSize*coreSideSize) {
            sideSize +=1;
        }
        this.contents = new Piece[sideSize][sideSize];
    }
    public void initiate(){
        //select a random integer one though colorWheelSize
        int randomInt = this.myRandom.nextInt(colorWheelSize);
        randomInt ++;
        //populate contents with that number except outer ring
        for (int i = 0; i<coreSize; i++){
            for (int j =0; j<coreSize; j++) {
                this.contents[i+1][j+1].setColorVal(randomInt);
            }
        }

        //populate contents with that number except outer ring
    }
    public void print(){
        System.out.println("--Printing Puzzle--");
        for (int i = 0; i<sideSize; i++){
            for (int j =0; j<sideSize; j++) {
                contents[i][j].print();
            }
            System.out.println();
        }
    }
}
