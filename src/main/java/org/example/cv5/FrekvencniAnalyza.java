package org.example.cv5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FrekvencniAnalyza {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        //System.out.println("Zadej text pro analyzu: ");
        //String text = input.nextLine();
        //String filename = "C:\\Users\\jarah\\Downloads\\text.txt";
        //String text = readFileAsString(filename);
        //frekvencniAnalyza(text);

        String filename = "C:\\Users\\jarah\\Downloads\\text.txt";
        List<String> lines = readFileWithScanner(filename);
        System.out.println(lines);
        frekvencniAnalyzaSlov(lines);
    }

    private static void frekvencniAnalyza(String text){
        Map<Character, Integer> analysis = new HashMap<>();
        //text = Zdarec, zase to PRO1, co?
        //string = pole znaku
        char[] chars = text.replaceAll("\\s", "").toCharArray();

        for(char c : chars) {
            if (analysis.containsKey(c)){
                analysis.put(c, analysis.get(c) + 1);
            } else {
                analysis.put(c, 1);
            }
        }

        System.out.println(analysis);
    }

    private static void frekvencniAnalyzaSlov(List<String> lines) {
        Map<String, Integer> analysis = new HashMap<>();
        for (String line : lines) {
            String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            for (String word : words) {
                if (analysis.containsKey(word)) {
                    analysis.put(word, analysis.get(word) + 1);
                } else {
                    analysis.put(word, 1);
                }
            }
        }
        System.out.println(analysis);
    }

    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static List<String> readFileWithScanner(String fileName){
        List<String> lines = new ArrayList<>();

        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor neexistuje");
            throw new RuntimeException(e);
        }

        return lines;

    }
}
