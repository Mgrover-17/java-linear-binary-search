import java.io.*;

public class ChallengeProblem {
    public static void main(String[] args) {
        compareStringConcatenation();
        compareFileReading("example");  // Replace with a large file path (100MB)
    }

    public static void compareStringConcatenation() {
        int iterations = 1_000_000;  // 1 million iterations
        String text = "hello";

        // Measure time for StringBuilder
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long stringBuilderTime = System.nanoTime() - startTime;

        // Measure time for StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long stringBufferTime = System.nanoTime() - startTime;

        // Print results
        System.out.println("StringBuilder Time: " + (stringBuilderTime / 1_000_000) + " ms");
        System.out.println("StringBuffer Time:  " + (stringBufferTime / 1_000_000) + " ms");
    }

    // Compare FileReader and InputStreamReader Performance
    public static void compareFileReading(String filePath) {
        try {
            // Measure time for FileReader
            long startTime = System.nanoTime();
            int wordCountFileReader = countWordsUsingFileReader(filePath);
            long fileReaderTime = System.nanoTime() - startTime;

            // Measure time for InputStreamReader
            startTime = System.nanoTime();
            int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
            long inputStreamReaderTime = System.nanoTime() - startTime;

            // Print results
            System.out.println("FileReader: " + wordCountFileReader + " words, " + (fileReaderTime / 1_000_000) + " ms");
            System.out.println("InputStreamReader: " + wordCountInputStreamReader + " words, " + (inputStreamReaderTime / 1_000_000) + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 🔹 Count words using FileReader
    public static int countWordsUsingFileReader(String filePath) throws IOException {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            int wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;  // Split on whitespace
            }
            return wordCount;
        }
    }

    //  Count words using InputStreamReader
    public static int countWordsUsingInputStreamReader(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            int wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;  // Split on whitespace
            }
            return wordCount;
        }
    }
}
