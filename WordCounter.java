import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Word Counting Program");
            System.out.println("1. Enter 'text' to input text manually");
            System.out.println("2. Enter 'file' to provide a file path");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            String inputText = "";
            if (choice.equalsIgnoreCase("text")) {
                System.out.print("Enter your text: ");
                inputText = scanner.nextLine();
            } else if (choice.equalsIgnoreCase("file")) {
                System.out.print("Enter the file path: ");
                String filePath = scanner.nextLine();
                try {
                    inputText = readTextFromFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                    return;
                }
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            String[] words = inputText.split("[\\s\\p{Punct}]+");
            int wordCount = words.length;

            System.out.println("Total words: " + wordCount);
        }
    }

    public static String readTextFromFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
        }
        return content.toString();
    }
}
