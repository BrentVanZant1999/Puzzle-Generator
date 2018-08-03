package com.company;
import java.util.Scanner;

/*
 * Holds the runner which handles getting user input and running the puzzle generation process.
 */
public class Main {
   private static final String puzzleSizeFormatError = "---Puzzle Size Format Error---";
   private static final String puzzleSizeRangeError = "---Puzzle Size Range Error (3-10)---";
   private static final String puzzleDifficultyFormatError = "---Puzzle Difficulty Format Error---";
   private static final String puzzleDifficultyRangeError = "---Puzzle Difficulty Range Error---";
   private static final String puzzleSizePrompt = "Enter Puzzle Size in integer form:";
   private static final String puzzleDifficultyPrompt = "Enter Difficulty Level (1-7):";
   private static final int  MAX_PUZZLE_SIZE = 10;
   private static final int MIN_PUZZLE_SIZE = 3;
    /*
     * Prompts user through scanner for integer input.
     */
    public static void main(String[] args) {
        //prompt user for puzzle starting size.
        boolean sizeCorrect = false;
        boolean difficultyCorrect = false;
        boolean amountCorrect = false;
        int sizeVal;
        int difficultyVal;
        int amountVal;
        Scanner mainScanner=new Scanner(System.in);

        while (!sizeCorrect) {
            System.out.println(puzzleSizePrompt);
            String inputedSizeString=mainScanner.nextLine();
            try
            {
                sizeVal = Integer.parseInt(inputedSizeString);
                if (sizeVal <= MAX_PUZZLE_SIZE && sizeVal >= MIN_PUZZLE_SIZE) {
                    sizeCorrect = true;
                }
                else {
                    System.out.println(puzzleSizeRangeError);
                }
            }
            catch (NumberFormatException nfe) {
                System.out.println(puzzleSizeFormatError);
            }
        }
            System.out.println("Enter Difficulty Level (1-7):");
        //prompt user for how many
    }
}
