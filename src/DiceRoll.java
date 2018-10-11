import java.util.Scanner;

public class DiceRoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			input();
	}

	private static void input() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sides of dice: " );
		int diceSides = 0;
		if (sc.hasNextInt()) {
			diceSides = sc.nextInt();
			int counter = 1;
			askToPlayFirstTime(diceSides, counter);
		}
		else {
			System.out.println("Oops");
			input();
		}
	}


	private static void askToPlayFirstTime(int diceSides, int counter) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to roll the dice? y/n?");
		if (sc.next().equals("y")) {
			System.out.println("For roll 1 your score is " + generateRandomDieRoll(diceSides, counter));
		}
		else {
			System.out.println(".");
		}
		askToPlayAgain(diceSides, counter);
	}

	private static void askToPlayAgain(int diceSides, int counter) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to roll those dice again? y/n?");
		counter++;
		if (sc.next().equals("y")) {
			System.out.println("OK, now for roll " + counter + " your score is " + generateRandomDieRoll(diceSides, counter));
			askToPlayAgain(diceSides, counter);
		}
		else {
			System.out.println("Well then.");
		}
	}

	private static int generateRandomDieRoll(int sides, int counter) {
		// TODO Auto-generated method stub
		int dice1 = (int) (Math.random() * sides) + 1;
		int dice2 = (int) (Math.random() * sides) + 1;
		int sum =  dice1 + dice2;
		System.out.println("Dice 1 is " + dice1);
		System.out.println("Dice 2 is " + dice2);
		if ((dice1 == 1) && (dice2 == 1)) {
			System.out.print("Snake Eyes! ");
		} if ((dice1 == 6) && (dice2 == 6)) {
			System.out.print("You got boxcars! ");
		} if (sum == 7) {
			System.out.print("OUCH. Craps! ");
		}
		return sum;
	}

}
