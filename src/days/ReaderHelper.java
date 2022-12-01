package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderHelper {
    public static Scanner openScanner(File file) {
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
