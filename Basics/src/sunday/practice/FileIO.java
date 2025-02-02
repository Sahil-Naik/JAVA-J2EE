/*17. File I/O:
 Read from and write to a file using Java's file I/O capabilities.*/

package sunday.practice;

import java.io.*;

public class FileIO {
    private static final String FILE_NAME = "employee.txt";

    // Method to read from a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Reading from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to write to a file
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(content);
            writer.newLine(); // Adds a new line after writing
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Read original content from the file
        readFile();

        // Write new employee data to the file
        String newData = "name: John\nsalary: 5000";
        writeFile(newData);

        // Read file again to confirm changes
        System.out.println("\nAfter writing new data:");
        readFile();
    }
}

