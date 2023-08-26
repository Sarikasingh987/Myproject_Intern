import java.util.Scanner;
import java.util.Random;

public class Numbergame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            int secretNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;

                try {
                    userGuess = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                String result = evaluateGuess(secretNumber, userGuess);
                System.out.println(result);

                if (result.equals("Correct")) {
                    System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                    totalScore++;
                    break;
                }
                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thank you for playing! Your total score is: " + totalScore);
        sc.close();
    }

    private static String evaluateGuess(int secretNumber, int userGuess) {
        if (userGuess < secretNumber) {
            return "Too low";
        } else if (userGuess > secretNumber) {
            return "Too high";
        } else {
            return "Correct";
        }
    }
}