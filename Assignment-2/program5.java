import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCountSystem {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split by whitespace and remove non-alphanumeric characters
                String[] words = line.toLowerCase().split("\\s+");
                
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z0-9]", "");
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            System.out.println("--- Word Occurrences ---");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.printf("%-15s : %d\n", entry.getKey(), entry.getValue());
            }
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
