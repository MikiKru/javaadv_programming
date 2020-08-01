package z30;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileInverter {
    private static String path =
            Paths.get("").toAbsolutePath().toString()+ "\\src\\main\\java\\z30\\example.txt";

    public String readFile() {
        try {
            Scanner scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void writeInvertedFile(){

    }

    public static void main(String[] args) {
        FileInverter fileInverter = new FileInverter();
        fileInverter.readFile();
    }
}
