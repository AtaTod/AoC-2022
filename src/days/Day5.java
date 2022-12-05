package days;

import java.io.File;
import java.util.Scanner;

public class Day5 {

    private final File inputFile = new File("src/files/input5.txt");

    public void one() {
        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        String line = input.nextLine();
        int numberStacks = (line.length()+1)/4;
        StringBuilder[] stacks = new StringBuilder[numberStacks];
        for (int i = 0; i < numberStacks; i++) {
            stacks[i] = new StringBuilder();
        }
        
        do {
            int j = -3;
            for (int i = 0; i < numberStacks; i++) {
                j += 4;
                if (line.charAt(j) != ' ')
                    stacks[i].append(line.charAt(j));
            }
            line = input.nextLine();
        } while (!Character.isDigit(line.charAt(1)));
        input.nextLine();
        
        for (int i = 0; i < numberStacks; i++) {
            stacks[i] = stacks[i].reverse();
        }

        while (input.hasNext()) {
            String[] command = input.nextLine().split(" ");
            int number = Integer.parseInt(command[1]);
            int from = Integer.parseInt(command[3])-1;
            int to = Integer.parseInt(command[5])-1;
            int fromLength = stacks[from].length();
            stacks[to].append(stacks[from].reverse().substring(0, number));
            stacks[from].reverse();
            stacks[from].delete(fromLength-number, fromLength);
            
        }

        for (int i = 0; i < numberStacks; i++) {
            System.out.print(stacks[i].charAt(stacks[i].length()-1));
        }
        System.out.println();
    }

    public void two() {

        Scanner input = ReaderHelper.openScanner(inputFile);
        if (input == null)
            return;

        String line = input.nextLine();
        int numberStacks = (line.length()+1)/4;
        StringBuilder[] stacks = new StringBuilder[numberStacks];
        for (int i = 0; i < numberStacks; i++) {
            stacks[i] = new StringBuilder();
        }

        do {
            int j = -3;
            for (int i = 0; i < numberStacks; i++) {
                j += 4;
                if (line.charAt(j) != ' ')
                    stacks[i].append(line.charAt(j));
            }
            line = input.nextLine();
        } while (!Character.isDigit(line.charAt(1)));
        input.nextLine();

        for (int i = 0; i < numberStacks; i++) {
            stacks[i] = stacks[i].reverse();
        }

        while (input.hasNext()) {
            String[] command = input.nextLine().split(" ");
            int number = Integer.parseInt(command[1]);
            int from = Integer.parseInt(command[3])-1;
            int to = Integer.parseInt(command[5])-1;
            int fromLength = stacks[from].length();
            stacks[to].append(stacks[from].substring(fromLength-number));
            stacks[from].delete(fromLength-number, fromLength);

        }

        for (int i = 0; i < numberStacks; i++) {
            System.out.print(stacks[i].charAt(stacks[i].length()-1));
        }
        System.out.println();
    }
}
