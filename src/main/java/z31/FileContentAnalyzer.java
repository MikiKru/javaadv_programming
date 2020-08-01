package z31;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileContentAnalyzer {
    private static String path =
            Paths.get("").toAbsolutePath().toString()+ "\\src\\main\\java\\z31\\Sentences.txt";
    private static String pathResults =
            Paths.get("").toAbsolutePath().toString()+ "\\src\\main\\java\\z31\\SentencesResults.txt";
    private String fileContent = "";
    public void getFileContent(){
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()){
                fileContent += scanner.nextLine();
            }
            fileContent = fileContent.replaceAll(",","").replaceAll("\\.","");     // usunięcie interpunkcji
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public String analyzeFileContent(){
        String words [] = fileContent.split(" ");
        Map<String, Integer> wordsCounter = new HashMap<>();
        for (String word : words) {
            if(!wordsCounter.containsKey(word)){
                wordsCounter.put(word, 1);                          // gdy slowa jeszcze nie ma w mapie
            } else {
                wordsCounter.put(word, wordsCounter.get(word) + 1); // gdy zliczamy kolejne wystąpienie słowa
            }
        }
        System.out.println(wordsCounter);
        System.out.println(fileContent);
        return wordsCounter.keySet().stream()
                .map(word -> String.format("| %15s | %3d |", word, wordsCounter.get(word)))
                .collect(Collectors.joining("\n"));
    }
    public void writeResultsToFile(){
        try {
            FileWriter fw = new FileWriter(new File(pathResults));
            fw.write(analyzeFileContent());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        FileContentAnalyzer fca = new FileContentAnalyzer();
        fca.getFileContent();
        fca.writeResultsToFile();
    }
}
