/*
Given two numbers, return the greatest common factor (or divisor) between them. Assume inputs are positive

in:
25 35

out:
5

in:
10 30

out:
10
*/
import java.util.*;
import java.io.*;

class GreatestCommonDivisor {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	static String implementation = "gcdEuclidIterativeSlow";

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.nextLine();
		scan.close();
		try {
			out.println(GreatestCommonDivisor.class.getDeclaredMethod(implementation, int.class, int.class).invoke(null, a, b));
		}
		catch (Exception e) {
			e.printStackTrace(out);
		}
	}

	/*
	 * If n is the smaller number between a and b, then this method is 
	 * O(n) on the VALUE of n but 
	 * O(2^n) on the SIZE (digits) of n (the traditional definition of complexity uses size, not value)
	 *
	 * Observe the following: The number 10001010 is binary for 138. If we double 138, we 
	 * get 276. This number in binary is 100010100. Notice how DOUBLING a number in binary 
	 * is simply a matter of adding a zero digit on the end. The binary VALUE of 276 is 
	 * twice the value of 138. But the binary SIZE of 276 is only one digit larger. This 
	 * is true in general of binary numbers.
	 *
	 * What does this mean? When the SIZE of a number only increases by one digit, the 
	 * amount of work required to process it is DOUBLED. This is the definition of O(2^n)
	 */
	private static int gcdExponential(int a, int b) {
		int divisor = 0;
		for (int i = 1; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				divisor = i;
			}
		}
		return divisor;
	}

	/*
	 * Euclid's algorithm comes from an eponymous book written in Ancient Greece circa 300 B.C.
	 *
	 * Observe how the GCD between 138 and 139 is 1. How do we know for sure? The distance 
	 * between them is 1, so any number that "hops" from 138 to 139 must be less than or equal 
	 * to 1 - otherwise it would overshoot 139 when hopping from 138. We can use the distance 
	 * between a and b to tell us more information about the GCD between a and b.
	 *
	 * Assume a is greater than or equal to b. From this principle, we can assert that the GCD 
	 * between b and (a - b) is the same as the GCD between a and b. Why? The GCD is a factor that 
	 * "hops" from b to a. This "hop" is either the distance between a and b, or it is itself a factor 
	 * of the distance between a and b. So if the distance between a and b is 10, then the GCD could be 
	 * 1, 2, 5, or 10 because all these numbers fit evenly into 10. It couldn't possibly be a number 
	 * like 3, because you can't get from b to a by "hopping" 3 units - you'll either land short, or 
	 * land too far.
	 *
	 * gcd(25, 35) == gcd(10, 25) == gcd(10, 35)
	 * gcd(10, 25) == gcd(10, 15)
	 * gcd(10, 15) == gcd(5, 10)
	 * gcd(5, 10) == gcd(5, 5)
	 * gcd(5, 5) == 5
	 *
	 * Euclid's algorithm works by starting with a and b, but then simplifies the problem by replacing 
	 * a and b with smaller and smaller numbers. When the numbers are the same, the problem can't be 
	 * simplified anymore, and we have our answer for the GCD - namely, the number we are left with.
	 */
	private static int gcdEuclidIterativeSlow(int a, int b) {
		while (a != b) {
			int difference = Math.max(a, b) - Math.min(a, b);
			a = Math.min(a, b);
			b = difference;
		}
		return a;
	}

	private static int gcdEuclidRecursiveSlow(int a, int b) {
		return 0;
	}

	private static int gcdEuclidIterativeFast(int a, int b) {
		return 0;
	}

	private static int gcdEuclidRecursiveFast(int a, int b) {
		return 0;
	}
}
