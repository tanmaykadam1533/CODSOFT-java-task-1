import java.util.Random;
import java.util.Scanner;

public class codsoft_task_1 {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Random rand = new Random();

            int roundsWon = 0;
            boolean playAgain = true;

            System.out.println("🎮 Welcome to the Number Guessing Game!");

            while (playAgain) {
                int lowerBound = 1;
                int upperBound = 100;
                int numberToGuess = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
                int maxAttempts = 7;  // limit attempts
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.println("\nI have chosen a number between " + lowerBound + " and " + upperBound + ".");
                System.out.println("You have " + maxAttempts + " attempts to guess it.");

                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("Enter your guess: ");
                    int guess = sc.nextInt();
                    attempts++;

                    if (guess == numberToGuess) {
                        System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                        roundsWon++;
                        guessedCorrectly = true;
                    } else if (guess < numberToGuess) {
                        System.out.println("📉 Too low! Try again.");
                    } else {
                        System.out.println("📈 Too high! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("❌ You've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
                }

                // Ask if user wants to play again
                System.out.print("\nDo you want to play another round? (yes/no): ");
                String response = sc.next().toLowerCase();
                playAgain = response.equals("yes");
            }

            // Final Score
            System.out.println("\n🏆 Game Over! You won " + roundsWon + " round(s). Thanks for playing!");
            sc.close();
        }
    }

