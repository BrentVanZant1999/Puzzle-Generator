package com.company;
import java.util.Scanner;

/*
 * Holds the runner which handles getting user input and running the puzzle generation process.
 */
public class Main {
    //size errors
    private static final String puzzleSizeRangeError = "---Puzzle Size Range Error (3-10)---";

    //difficulty errors
    private static final String puzzleDifficultyRangeError = "---Puzzle Difficulty Range Error (1-10)---";

    //amount errors
    private static final String puzzleAmountRangeError = "---Puzzle Amount to Generate Range Error (1-1000)---";

    //colors erros
    private static final String puzzleColorRangeError = "---Puzzle Colors Range Error (3-6)---";

    //print error
    private static final String puzzlePrintRangeError = "---Puzzle Print Format Range Error (0-1)---";

    //prompts
    private static final String puzzleSizePrompt = "Enter Puzzle Size in integer form (3-12):";
    private static final String puzzleDifficultyPrompt = "Enter Difficulty Level (1-14):";
    private static final String puzzleAmountPrompt = "Enter Amount of Levels to generate (1-10000):";
    private static final String puzzleColorPrompt = "Enter Amount of Colors in puzzle (3-6):";
    private static final String puzzlePrintPrompt = "Enter Type Of print (0 for grid form, 1 for array form):";
    //constant format error
    private static final String formatError = "--!--Response Formatting Error--!--";
    //range constants
    private static final int MAX_PUZZLE_SIZE = 12;
    private static final int MIN_PUZZLE_SIZE = 3;
    private static final int MAX_PUZZLE_DIFF = 14;
    private static final int MIN_PUZZLE_DIFF = 1;
    private static final int MAX_PUZZLE_AMOUNT = 10000;
    private static final int MIN_PUZZLE_AMOUNT = 1;
    private static final int MAX_PUZZLE_COLOR = 6;
    private static final int MIN_PUZZLE_COLOR = 3;
    private static final int MAX_PRINT = 1;
    private static final int MIN_PRINT = 0;
    /*
     * Prompts user through scanner for integer input.
     */
    public static void main(String[] args) {
        //prompt user for puzzle starting size.
        boolean sizeCorrect = false;
        boolean difficultyCorrect = false;
        boolean amountCorrect = false;
        boolean colorCorrect = false;
        boolean typePrintCorrect= false;

        int sizeVal;
        int difficultyVal;
        int amountVal;
        int colorVal;
        int typePrintVal;
        Scanner mainScanner=new Scanner(System.in);

        sizeVal = promptUser(sizeCorrect, mainScanner, puzzleSizePrompt, MAX_PUZZLE_SIZE, MIN_PUZZLE_SIZE, puzzleSizeRangeError, formatError);
        difficultyVal = promptUser(difficultyCorrect, mainScanner, puzzleDifficultyPrompt, MAX_PUZZLE_DIFF, MIN_PUZZLE_DIFF, puzzleDifficultyRangeError, formatError);
        amountVal = promptUser(amountCorrect, mainScanner, puzzleAmountPrompt, MAX_PUZZLE_AMOUNT, MIN_PUZZLE_AMOUNT, puzzleAmountRangeError, formatError);
        colorVal = promptUser(colorCorrect, mainScanner, puzzleColorPrompt, MAX_PUZZLE_COLOR, MIN_PUZZLE_COLOR, puzzleColorRangeError, formatError);
        typePrintVal = promptUser(typePrintCorrect, mainScanner,puzzlePrintPrompt, MAX_PRINT, MIN_PRINT,puzzlePrintRangeError,formatError  );
        for (int i =0;  i<amountVal; i++){
            Puzzle currentPuzzle = new Puzzle(sizeVal, difficultyVal, colorVal);
            currentPuzzle.initiate();
            currentPuzzle.randomize();
            if (typePrintVal == 0) {
                currentPuzzle.print();
            }
            else {
                currentPuzzle.arrayPrint();
            }
            }
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
