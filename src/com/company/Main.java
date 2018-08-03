package com.company;
import java.util.Scanner;

/*
 * Holds the runner which handles getting user input and running the puzzle generation process.
 */
public class Main {
    //size errors
    private static final String puzzleSizeRangeError = "---Puzzle Size Range Error (3-10)---";

    //difficulty errors
    private static final String puzzleDifficultyRangeError = "---Puzzle Difficulty Range Error (1-7)---";

    //amount errors
    private static final String puzzleAmountRangeError = "---Puzzle Difficulty Range Error (1-1000)---";

    //prompts
    private static final String puzzleSizePrompt = "Enter Puzzle Size in integer form:";
    private static final String puzzleDifficultyPrompt = "Enter Difficulty Level (1-7):";
    private static final String puzzleAmountPrompt = "Enter Amount of levels to generate:";

    //constant format error
    private static final String formatError = "--!--Response Formatting Error--!--";
    //range constants
    private static final int MAX_PUZZLE_SIZE = 10;
    private static final int MIN_PUZZLE_SIZE = 3;
    private static final int MAX_PUZZLE_DIFF = 7;
    private static final int MIN_PUZZLE_DIFF = 1;
    private static final int MAX_PUZZLE_AMOUNT = 1000;
    private static final int MIN_PUZZLE_AMOUNT = 1;
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

        sizeVal = promptUser(sizeCorrect, mainScanner, puzzleSizePrompt, MAX_PUZZLE_SIZE, MIN_PUZZLE_SIZE, puzzleSizeRangeError, formatError);
        difficultyVal = promptUser(difficultyCorrect, mainScanner, puzzleDifficultyPrompt, MAX_PUZZLE_DIFF, MIN_PUZZLE_DIFF, puzzleDifficultyRangeError, formatError);
        amountVal = promptUser(amountCorrect, mainScanner, puzzleAmountPrompt, MAX_PUZZLE_AMOUNT, MIN_PUZZLE_AMOUNT, puzzleAmountRangeError, formatError);

        for (int i =0;  i<amountVal; i++){
            Puzzle currentPuzzle = new Puzzle(sizeVal, difficultyVal);
            currentPuzzle.initiate();
            currentPuzzle.randomize();
            currentPuzzle.print();
        }
    }

    private static int promptUser(boolean correctBoolean, Scanner mainScanner, String prompt, int maxVal, int minVal, String rangeError, String formatError) {
        int value;
        while (!correctBoolean) {
            System.out.println(prompt);
            String inputString = mainScanner.nextLine();
            try {
                value = Integer.parseInt(inputString);
                if (value <= maxVal && value >= minVal) {
                    correctBoolean = true;
                    return value;
                } else {
                    System.out.println(rangeError);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(formatError);
            }
        }
        return 0;
    }
}
