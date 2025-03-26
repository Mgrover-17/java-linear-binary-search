import java.io.*;

public class ReadWriteToFile {
    public static void main(String[] args) {
        String filePath = "example";  // File to save user input

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {  // Read user input
                bufferedWriter.write(line);   // Write input to file
                bufferedWriter.newLine();     // Move to a new line in file
            }

            System.out.println("User input saved to " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
