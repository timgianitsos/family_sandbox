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

	static String implementation = "gcdEuclidIterativeFast";

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
	static int gcdExponential(int a, int b) {
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
	static int gcdEuclidIterativeSlow(int a, int b) {
		while (a != b) {
			int difference = Math.max(a, b) - Math.min(a, b);
			a = Math.min(a, b);
			b = difference;
		}
		return a;
	}

	/*
	 * Recursion can be used to simplify an instance of a hard problem into a simpler 
	 * version of itself
	 */
	static int gcdEuclidRecursiveSlow(int a, int b) {
		return (a != b ? gcdEuclidRecursiveSlow(Math.min(a, b), Math.max(a, b) - Math.min(a, b)) : a);
	}

	/*
	 * We can improve this algorithm. Observe the following example: gcd(6, 124).
	 * The first several steps look like this:
	 * gcd(6, 124) == gcd(6, 118) == gcd(6, 112) == gcd(6, 106) == gcd(6, 100) ...
	 * Our algorithm gets the difference between "a" and "b", and chooses the smallest two numbers 
	 * from the triple [a, b, a - b]. In our example, "b" is so much less than "a", that "a" keeps 
	 * getting replaced with a - b over and over. 
	 *
	 * Eventually the sequence looks like this:
	 * ... gcd(6, 22) == gcd(6, 16) == gcd(6, 10) == gcd(6, 4)
	 * The sequence only gets interesting when a - b is less then both a and b. Up until that point, 
	 * we see that a - b is between a and b over and over again.
	 *
	 * Finally, the algorithm concludes:
	 * gcd(6, 4) == gcd(2, 4) == gcd(2, 2) == 2
	 * 
	 * We know that if we have gcd(6, 124) that we are going to keep subtracting 6 from 124 until 
	 * that number is less than 6. We can immediately go to the case where the number is less than 6 
	 * by using modulus: 124 % 6 == 4. This takes us directly to the case where a - b is less than 
	 * both a and b. We can avoid repeated subtraction by using modulus. So when starting with 
	 * gcd(6, 124), we can go directly to gcd(6, 4).
	 *
	 * The sequence using modulus looks like this:
	 * gcd(6, 124) == gcd(124, 6) == gcd(6, 4) == gcd(4, 2) == gcd(2, 0) == 2
	 * This took only 6 steps - a large improvement over what previously took 24 steps.
	 * We stop iterating whenever b is 0.
	 *
	 * The fast versions of Euclid's algorithm are O(n) on the SIZE of the smaller number, 
	 * and O(log n) on the VALUE of the smaller number.
	 */
	static int gcdEuclidIterativeFast(int a, int b) {
		while (a != 0 && b != 0) {
			int difference = Math.max(a, b) % Math.min(a, b);
			a = Math.min(a, b);
			b = difference;
		}
		return Math.max(a, b);
	}

	/*
	 * Recursion can be used to simplify an instance of a hard problem into a simpler 
	 * version of itself
	 */
	static int gcdEuclidRecursiveFast(int a, int b) {
		return a != 0 && b != 0 ? gcdEuclidRecursiveFast(Math.max(a, b) % Math.min(a, b), Math.min(a, b)) : Math.max(a, b);
	}

	/*
	 * Method to implement Binary Euclid Algorithm, also known as Stein's Algorithm
	 * Use this method to test against other implementations of Euclid's algorithm
	 * Obtained from http://www.geeksforgeeks.org/steins-algorithm-for-finding-gcd/
	 * This has the same computational complexity as Euclid's algorithm, but uses 
	 * bit shifting instead of modular arithmetic with the intention of performance 
	 * improvements. In practice it may be slower if the appropriate intrinsic bitwise 
	 * instructions aren't utilized however.
	 * https://stackoverflow.com/questions/7814571/why-is-the-binary-gcd-algorithm-so-much-slower-for-me
	 * https://hbfs.wordpress.com/2013/12/10/the-speed-of-gcd/
	 * https://lemire.me/blog/2013/12/26/fastest-way-to-compute-the-greatest-common-divisor/
	 * https://en.wikipedia.org/wiki/Intrinsic_function
	 */
	static int gcdEuclidBinary(int a, int b)
	{
		/* GCD(0, b) == b; GCD(a,0) == a, GCD(0,0) == 0 */
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		/*Finding K, where K is the greatest power of 2
		  that divides both a and b. */
		int k;
		for (k = 0; ((a | b) & 1) == 0; ++k) {
			a >>= 1;
			b >>= 1;
		}

		/* Dividing a by 2 until a becomes odd */
		while ((a & 1) == 0)
			a >>= 1;

		/* From here on, 'a' is always odd. */
		do {
			/* If b is even, remove all factor of 2 in b */
			while ((b & 1) == 0)
				b >>= 1;

			/* Now a and b are both odd. Swap if necessary
			   so a <= b, then set b = b - a (which is even).*/
			if (a > b) {
				//swap a and b
				a = a ^ b;
				b = b ^ a;
				a = a ^ b;
			}

			b = (b - a);
		} while (b != 0);

		/* restore common factors of 2 */
		return a << k;
	}

	/*
	 * Found on internet
	 */
	// static int gcdEuclidIterativeFast(int a, int b) {
	// 	while (b != 0) {
	// 		int remainder = a % b;
	// 		a = b;
	// 		b = remainder;
	// 	}
	// 	return a;
	// }
}
