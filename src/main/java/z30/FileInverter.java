package z30;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileInverter {
    private static String path =
            Paths.get("").toAbsolutePath().toString()+ "\\src\\main\\java\\z30\\example.txt";
    private String fileContent = "";
    public String readFile() {
        try {
            Scanner scanner = new Scanner(new File(path));
            StringBuffer sb = new StringBuffer(fileContent);
            while(scanner.hasNextLine()){
                sb.append("\n");
                sb.append(scanner.nextLine());
            }
            sb.reverse();
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void writeInvertedFile(){
        String fileURL [] = path.split("\\\\");
        String fileName = fileURL[fileURL.length - 1].replace(".txt","");
        String invertedPath = path.replace(fileName,new StringBuffer(fileName).reverse().toString());
        try {
            FileWriter pw = new FileWriter(new File(invertedPath));
            pw.write(readFile());
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        FileInverter fileInverter = new FileInverter();
        fileInverter.writeInvertedFile();
    }
}
