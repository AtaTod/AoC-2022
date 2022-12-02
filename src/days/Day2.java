package days;

import java.io.File;
import java.util.Scanner;

public class Day2 {
    private final File inputFile = new File("src/files/input2.txt");

    public void one() {
        int totalScore = 0;

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        while (input.hasNext()) {
            String currentHandDraw = input.nextLine();
            int enemyHandScore = this.getHandScore(currentHandDraw.charAt(0));
            int ownHandScore = this.getHandScore(currentHandDraw.charAt(2));
            int roundScore = this.getRoundScore(enemyHandScore, ownHandScore);

            totalScore += roundScore;
        }

        System.out.println(totalScore);
    }

    public void two() {
        int totalScore = 0;

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        while (input.hasNext()) {
            String currentHandDraw = input.nextLine();
            int enemyHandScore = getHandScore(currentHandDraw.charAt(0));
            int roundObjective = getHandScore(currentHandDraw.charAt(2));
            int objectiveHandScore = getObjectiveHandScore(enemyHandScore, roundObjective);
            int roundScore = this.getRoundScore(enemyHandScore, objectiveHandScore);

            totalScore += roundScore;
        }

        System.out.println(totalScore);
    }


    private int getObjectiveHandScore(int enemyHandScore, int roundObjective) {
        if (roundObjective == 0) {          //lose
            return ((enemyHandScore+2)%3);
        } else if (roundObjective == 1) {   //draw
            return enemyHandScore;
        } else {                            //win
            return ((enemyHandScore+1)%3);
        }
    }

    private int getHandScore(char hand) {
        switch (hand) {
            case 'A': //rock
            case 'X':
                return 0;
            case 'B': //paper
            case 'Y':
                return 1;
            case 'C': //scissors
            case 'Z':
                return 2;
        }
        System.err.println("INVALID CHAR IN THE INPUT");
        return 0;
    }

    private int getRoundScore(int enemyHandScore, int ownHandScore) {
        if (enemyHandScore == ownHandScore) {              //draw
            return 3 + ownHandScore + 1;
        } else if (enemyHandScore == (ownHandScore+2)%3) { //win
            return 6 + ownHandScore + 1;
        } else {                        //lose
            return ownHandScore + 1;
        }
    }
}
