import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (playAgain) {
            int random_number = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;

            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("Guess the number between 1 and 100.");

            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < random_number) {
                    System.out.println("Too low! Try again.");
                } else if (guess > random_number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + random_number);
                    break;
                }
            }

            totalAttempts += attempts;
            roundsWon++;

            System.out.println("You took " + attempts + " attempts to guess the number.");
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();

            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over! You won " + roundsWon + " rounds.");
        System.out.println("Total attempts taken: " + totalAttempts);
    }
}