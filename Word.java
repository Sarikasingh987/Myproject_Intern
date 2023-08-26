import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Word Counter!");
            System.out.println("Enter a string to count its words:");

            String inputText = scanner.nextLine();
            int wordCount = countWords(inputText);

            System.out.println("Total word count: " + wordCount);
        }
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }
}