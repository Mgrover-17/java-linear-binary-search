import java.io.*;

public class CountOccurenceOfWord {
    public static void main(String[] args) {
        String filePath = "example";  // Path to the file
        String targetWord = "Java";       // Word to search (case-sensitive)
        int wordCount = 0;                // Counter for occurrences

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) { // Read each line
                String[] words = line.split("\\s+");  // Split by spaces, tabs, newlines

                for (String word : words) {
                    if (word.equals(targetWord)) {  // Check if word matches
                        wordCount++;
                    }
                }
            }

            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
