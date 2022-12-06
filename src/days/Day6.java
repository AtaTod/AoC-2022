package days;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Day6 {

    private final File inputFile = new File("src/files/input6.txt");
    
    public void one() {
        getDistinctChars(4);
    }

    public void two() {
        getDistinctChars(14);
    }

    private void getDistinctChars(int n) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            List<Integer> queue = new LinkedList<>();
            queue.add(bufferedReader.read());
            int position = 1;
            while (queue.size() < n) {
                position++;
                int last = bufferedReader.read();
                if (queue.contains(last)) {
                    queue = queue.stream().dropWhile(i -> i != last).collect(Collectors.toList());
                    queue.remove(0);
                }
                queue.add(last);
            }
            for (int i = 0; i < n; i++) {
                System.out.print((char) queue.get(i).intValue());
            }
            System.out.println(" : " + position);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
