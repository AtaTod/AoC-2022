package days;

import java.io.*;
import java.util.ArrayList;

public class Day7 {

    private final File inputFile = new File("src/files/input7.txt");

    public void one() {
        execDay7(true);
    }

    public void two() {
        execDay7(false);
    }

    private void execDay7(boolean isOne) {
        Day7Dir root = new Day7Dir("/", null);

        Day7Dir current = root;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            reader.readLine(); // Hardcoded first input line.

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");

                switch (line[0]) {
                    case "$":
                        if (line[1].equals("cd"))
                            current = current.changeDir(line[2]);
                        break;
                    case "dir":
                        current.addFile(line[1]);
                        break;
                    default:
                        current.addFile(Integer.parseInt(line[0]), line[1]);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        if (isOne) {
            System.out.println(root.getDirSizeAtMost100k());
        } else {
            System.out.println(root.getDeletedDirSize(root.getSize() - 40000000));
        }
    }

    class Day7Dir extends Day7File {

        ArrayList<Day7File> files = new ArrayList<>();

        Day7Dir(String name, Day7Dir parent) {
            super(0, name, parent);
        }

        @Override
        public int getSize() {
            int out = 0;
            for (Day7File file : files) {
                out += file.getSize();
            }
            return out;
        }

        public void addFile(String name) {
            files.add(new Day7Dir(name, this));
        }

        public void addFile(int size, String name) {
            files.add(new Day7File(size, name, this));
        }

        public Day7Dir changeDir(String name) {
            if (name.equals(".."))
                return getParent();
            for (Day7File file : files) {
                if (file instanceof Day7Dir && file.getName().equals(name))
                    return (Day7Dir) file;
            }
            System.err.println("U FUCKED UP");
            return null;
        }

        public int getDirSizeAtMost100k() {
            int out = 0;
            if (getSize() < 100000)
                out = getSize();

            for (Day7File file : files) {
                if (file instanceof Day7Dir)
                    out += ((Day7Dir) file).getDirSizeAtMost100k();
            }

            return out;
        }

        public int getDeletedDirSize(int size) {
            int out = getSize();
            if (out < size)
                out = Integer.MAX_VALUE;

            for (Day7File file : files) {
                if (file instanceof Day7Dir && file.getSize() >= size) {
                    int tmp = ((Day7Dir) file).getDeletedDirSize(size);
                    if (tmp < out)
                        out = tmp;
                }
            }

            return out;
        }


    }

    class Day7File {
        private final Day7Dir parent;
        private final int size;
        private final String name;

        Day7File(int size, String name, Day7Dir parent) {
            this.parent = parent;
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        public Day7Dir getParent() {
            if (parent == null)
                System.err.println("U FUCKED UP");
            return parent;
        }
    }
}
