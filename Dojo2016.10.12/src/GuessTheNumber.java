import java.util.Scanner;

public class GuessTheNumber {
	public static void main(String[] args) {
		guessTheNum();
	}

	public static void guessTheNum() {
		int numberToGuess = (int) (Math.random() * 100);
		System.out.println(numberToGuess);
		System.out.println("Please give your guessed number!(1-99)");
		int guessedNumber = takeNumberFromConsole();
		while (numberToGuess != guessedNumber) {
			if (guessedNumber < numberToGuess) {
				System.out.println("The number to guess is higher than yours, please try again!");
				guessedNumber = takeNumberFromConsole();
			} else if (guessedNumber > numberToGuess) {
				System.out.println("The number to guess is lower than yours, please try again!");
				guessedNumber = takeNumberFromConsole();
			}
		}
		System.out.println("You guessed the right number, good job!");
		return;

	}

	@SuppressWarnings("resource")
	public static int takeNumberFromConsole() {
		Scanner scanIn = new Scanner(System.in);
		String result = scanIn.nextLine();
		System.out.println(result);
		while (!(result.matches("[0-9]+") && result.length() >= 1 && 3 > result.length())) {
			System.out.println("Your input is invalid! Please give your guessed number!(1-99)");
			result = scanIn.nextLine();
		}
		return Integer.parseInt(result);
	}

}
