import java.util.Scanner;

public class Progression {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("This program will calculate the geometric and ");
		System.out.println("harmonic progression for the number you enter.");
		System.out.print("Enter an integer that is greater than or equal to 1:  ");
		int input = keyboard.nextInt();
		int geomAnswer = geometricRecursive(input);
		double harmAnswer = harmonicRecursive(input);
		System.out.println("Using recursion:");
		System.out.println("The geometric progression of " + input + " is " + geomAnswer);
		System.out.println("The harmonic progression of " + input + " is " + harmAnswer);

		geomAnswer = geometricIterative(input);
		harmAnswer = harmonicIterative(input);
		System.out.println("Using iteration:");
		System.out.println("The geometric progression of " + input + " is " + geomAnswer);
		System.out.println("The harmonic progression of " + input + " is " + harmAnswer);
		keyboard.close();
	}

	public static int geometricIterative(int input) {
		int output = 1;
		if (input <= 0) {
			return 1;
		}
		for (int n = input; n >= 1; --n) {
			output *= n;
		}
		return output;
	}

	public static double harmonicIterative(int input) {
		double output = 1.0;
		if (input <= 0) {
			return 1;
		}
		for (int n = input; n >= 1; --n) {
			output = output / n;
		}
		return output;
	}

	public static int geometricRecursive(int input) {
		if (input <= 1) {
			return 1;
		} else {
			return input * geometricRecursive(input - 1);
		}
	}

	public static double harmonicRecursive(int input) {
		if (input <= 1) {
			return 1;
		} else {
			return (1.0/input)*harmonicRecursive(input - 1);
		}
	}

}