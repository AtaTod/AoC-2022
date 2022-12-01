package days;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Day1 {
    private final File inputFile = new File("src/files/input1.txt");

    public void one() {
        int currentElfCalories = 0;
        int mostElfCalories = 0;

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        while (input.hasNext()) {
            String s = input.nextLine();
            if (s.length() != 0) {
                currentElfCalories += Integer.parseInt(s);
            } else {
                if (currentElfCalories > mostElfCalories)
                    mostElfCalories = currentElfCalories;
                currentElfCalories = 0;
            }
        }

        System.out.println(mostElfCalories);
    }

    public void two() {
        int currentElfCalories = 0;
        int[] topElfCalories = {0, 0, 0};

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        while (input.hasNext()) {
            String s = input.nextLine();
            if (s.length() != 0) {
                currentElfCalories += Integer.parseInt(s);
            } else {
                if (currentElfCalories > topElfCalories[0]) {
                    topElfCalories[2] = topElfCalories[1];
                    topElfCalories[1] = topElfCalories[0];
                    topElfCalories[0] = currentElfCalories;
                } else if (currentElfCalories > topElfCalories[1]) {
                    topElfCalories[2] = topElfCalories[1];
                    topElfCalories[1] = currentElfCalories;
                } else if (currentElfCalories > topElfCalories[2]) {
                    topElfCalories[2] = currentElfCalories;
                }
                currentElfCalories = 0;
            }
        }
        int topCombinedCalories = topElfCalories[0] + topElfCalories[1] + topElfCalories[2];
        System.out.println(Arrays.toString(topElfCalories) + " : " + topCombinedCalories);
    }
}
