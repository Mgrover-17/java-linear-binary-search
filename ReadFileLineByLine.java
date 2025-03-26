import java.io.*;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        String filePath = "example";  // Change this to your file path

        try (FileReader fileReader = new FileReader(filePath); //file reader reads character one at a time
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {  //buffered reader reads one line at time

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);  // Print each line
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
