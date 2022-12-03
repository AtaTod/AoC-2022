package days;

import java.io.File;
import java.util.Scanner;

public class Day3 {
    private final File inputFile = new File("src/files/input3.txt");

    public void one() {
        int totalScore = 0;

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        while (input.hasNext()) {
            String line = input.nextLine();
            totalScore += getItemScore(returnDuplicatedItem(line));
        }

        System.out.println(totalScore);
    }

    public void two() {
        int totalScore = 0;

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        while (input.hasNext()) {
            totalScore += getItemScore(returnTeamBadge(input.nextLine(), input.nextLine(), input.nextLine()));
        }

        System.out.println(totalScore);
    }

    private char returnTeamBadge(String elf1, String elf2, String elf3) {
        for (char badgeElf1 : elf1.toCharArray()) {
            for (char badgeElf2 : elf2.toCharArray()) {
                if (badgeElf1 == badgeElf2) {
                    for (char badgeElf3 : elf3.toCharArray()) {
                        if (badgeElf2 == badgeElf3) {
                            return badgeElf3;
                        }
                    }
                }
            }
        }
        System.out.println("ERROR");
        return 0;
    }

    private char returnDuplicatedItem(String rucksack) {
        int endFirstCompartment = rucksack.length() / 2;
        int endSecondCompartment = rucksack.length();
        for (int i = 0; i < endFirstCompartment; i++) {
            for (int j = endFirstCompartment; j < endSecondCompartment; j++) {
                if (rucksack.charAt(i) == rucksack.charAt(j)) {
                    return rucksack.charAt(i);
                }
            }
        }
        System.out.println("ERROR");
        return 0;
    }

    private int getItemScore(char item) {
        if (Character.isLowerCase(item)) {
            return item - 96;
        }
        return item - 38;
    }
}
