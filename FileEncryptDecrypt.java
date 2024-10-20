import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Choose an option: ");
            System.out.println("1. Encrypt a file");
            System.out.println("2. Decrypt a file");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            System.out.print("Enter the file name or path: ");
            String filePath = scanner.nextLine();

            System.out.print("Enter the key (a number for Caesar cipher): ");
            int key = scanner.nextInt();

            if (choice == 1) {
                processFile(filePath, key, true);
            } else if (choice == 2) {
                processFile(filePath, -key, false);
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void processFile(String filePath, int key, boolean isEncryption) throws IOException {
        File inputFile = new File(filePath);
        File outputFile = new File((isEncryption ? "encrypted_" : "decrypted_") + inputFile.getName());

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = processLine(line, key);
                writer.write(processedLine);
                writer.newLine();
            }
        }

        System.out.println("File " + (isEncryption ? "encrypted" : "decrypted") + " successfully. Output file: " + outputFile.getName());
    }

    private static String processLine(String line, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : line.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + key + 26) % 26 + base);
            }
            result.append(ch);
        }
        return result.toString();
    }
}
