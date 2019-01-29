import testharness.TestHarness;

import java.lang.reflect.Method;
import java.io.*;
import java.util.*;

/*
Run the following to test:
javac -cp "./:../../" TestFactor.java && java -cp "./:../../" TestFactor
*/

class TestFactor {
	public static void main(String args[]) throws Exception {
		simplifyFractionTests();
		gcdTests();
		timeTrials();
	}

	private static void simplifyFractionTests() throws Exception {
		System.out.println();
		{
			String input = "6 / 8\n";
			String expectedOutput = "3 / 4\n";
			Method m = SimplifyFraction.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "7 / 9\n";
			String expectedOutput = "7 / 9\n";
			Method m = SimplifyFraction.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			for (int i = 2; i < 27; i++) {
				String input = "" + (i - 1) + " / " + i + "\n";
				String expectedOutput = "" + (i - 1) + " / " + i + "\n";
				Method m = SimplifyFraction.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
				TestHarness.test(input, expectedOutput, m);
			}
		}
		{
			String input = "51 / 2147483647\n";
			String expectedOutput = "51 / 2147483647\n";
			Method m = SimplifyFraction.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "51 / 204\n";
			String expectedOutput = "1 / 4\n";
			Method m = SimplifyFraction.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "51 / 205\n";
			String expectedOutput = "51 / 205\n";
			Method m = SimplifyFraction.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		TestHarness.printResults();

	}

	private static void gcdTests() throws Exception {
		{
			String input = "25 35\n";
			String expectedOutput = "5\n";
			Method m = GreatestCommonDivisor.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
	    }

	    {
			String input = "10 30\n";
			String expectedOutput = "10\n";
			Method m = GreatestCommonDivisor.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
	    }

	    {
			String input;
			String expectedOutput;
			Method m = GreatestCommonDivisor.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			int n = 50;

			//Test every combination of numbers from 1 to n
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= a; b++) {
					
					//test a and b
					input = a + " " + b + "\n";
					expectedOutput = GreatestCommonDivisor.gcdEuclidBinary(a, b) + "\n";
					invokeAllGCD(input, expectedOutput, m);
					
					//flip a and b and test again
					if (a != b) {
						input = b + " " + a + "\n";
						expectedOutput = GreatestCommonDivisor.gcdEuclidBinary(b, a) + "\n";
						invokeAllGCD(input, expectedOutput, m);
					}
				}
			}
		}
		{
			String input = "121393 75025\n";
			String expectedOutput = "1\n";
			Method m = GreatestCommonDivisor.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			invokeAllGCD(input, expectedOutput, m);
		}
		{
			String input = "1134903170 1836311903\n";
			String expectedOutput = "1\n";
			Method m = GreatestCommonDivisor.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			invokeAllGCD(input, expectedOutput, m);
		}
		//Causes stack overflow on recursive method
		// {
		// 	String input = "1 2147483647\n";
		// 	String expectedOutput = "1\n";
		// 	Method m = GreatestCommonDivisor.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
		// 	invokeAllGCD(input, expectedOutput, m);
		// }
		TestHarness.printResults();
	}

	private static void timeTrials() throws Exception {
		System.out.println();
		int n = 2000;
		{
			//Get methods and sort them
			Method[] methods = GreatestCommonDivisor.class.getDeclaredMethods();
			Arrays.sort(methods, new Comparator<Method>() {
				@Override
				public int compare(Method m1, Method m2) {
					return m1.getName().compareTo(m2.getName());
				}
			});

			System.out.println("Timing gcd methods with all values between 1 and " + n + ":");

			//For each gcd method, do a time trial
			for (Method m: methods) {
				if (m.getName().startsWith("gcd")) {
					long startTime = System.nanoTime();
					for (int a = 1; a <= n; a++) {
						for (int b = 1; b <= a; b++) {
							m.invoke(null, a, b);
							if (a != b) {
								m.invoke(null, b, a);
							}
						}
					}
					double elapsedTime = (System.nanoTime() - startTime) / 1000000000.0;
					System.out.printf("%-36s %-1.9f seconds%n", m.getName() + " elapsed time:", elapsedTime);
				}
			}
		}
		System.out.println();
	}

	private static void invokeAllGCD(String input, String expectedOutput, Method runner) {
		for (Method m: GreatestCommonDivisor.class.getDeclaredMethods()) {
			if (m.getName().startsWith("gcd")) {
				GreatestCommonDivisor.implementation = m.getName();
				TestHarness.test(input, expectedOutput, runner);
			}
		}
	}
}
