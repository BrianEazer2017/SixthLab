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
			int total = 0;
			askToPlayFirstTime(diceSides, counter, total);
		}
		else {
			System.out.println("Oops");
			input();
		}
	}


	private static void askToPlayFirstTime(int diceSides, int counter, int total) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to roll the dice? y/n?");
		if (sc.next().equals("y")) {
			int roll = generateRandomDieRoll(diceSides, counter, total);
			total = calcTotal(roll, total);
			System.out.println("For roll 1 your score is " + roll);
		}
		else {
			System.out.println(".");
		}
		askToPlayAgain(diceSides, counter, total);
	}

	private static void askToPlayAgain(int diceSides, int counter, int total) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to roll those dice again? y/n?");
		counter++;
		if (sc.next().equals("y")) {
			int roll = generateRandomDieRoll(diceSides, counter, total);
			total = calcTotal(roll, total);
			System.out.println("OK, now for roll " + counter + " your score is " + roll + " and your total score is " + total + "");
			askToPlayAgain(diceSides, counter, total);
		}
		else {
			System.out.println("Well then.");
		}
	}

	private static int generateRandomDieRoll(int sides, int counter, int total) {
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
	private static int calcTotal(int score, int total) {
		total += score;
		return total;
	}

}