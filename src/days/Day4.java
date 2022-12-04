package days;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {

    private final File inputFile = new File("src/files/input4.txt");

    public void one() {
        int totalScore = 0;

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        while (input.hasNext()) {
            int[] data = Arrays.stream(input.nextLine().split("[-,]")).mapToInt(Integer::parseInt).toArray();
            if ((data[0] >= data[2] && data[1] <= data[3]) || (data[2] >= data[0] && data[3] <= data[1]))
                totalScore++;
        }

        System.out.println(totalScore);
    }

    public void two() {
        int totalScore = 0;

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        while (input.hasNext()) {
            int[] data = Arrays.stream(input.nextLine().split("[-,]")).mapToInt(Integer::parseInt).toArray();
            if (data[1] >= data[2] && data[0] <= data[3])
                totalScore++;
        }

        System.out.println(totalScore);
    }
}
