public class Recursion
{
	public static void main(String[] args)
	{
		int n = 7;

		//Test out the factorial
		System.out.println(n + " factorial equals ");
		System.out.println(Recursion.factorial(n));
		System.out.println();

	}

	public static int factorial(int n)
	{
		int temp;
		// Added for task #1
		System.out.println("Method call -- calculating Factorial of: " + n);
		if (n==1)
		{
			return 1;
		}
		else
		{
			// Removed for task #1
			// return (factorial(n-1) *n);
			
			// Added for task #1
			temp = factorial(n-1);
			System.out.println("Factorial of: " + (n-1) + " is " + temp);
			return (temp * n);
		}
	}
}
