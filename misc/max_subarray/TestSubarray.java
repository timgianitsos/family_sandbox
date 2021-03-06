import testharness.TestHarness;

import java.lang.reflect.Method;
import java.io.*;

/*
Run the following to test:
javac -cp "./:../../" TestSubarray.java && java -cp "./:../../" TestSubarray
*/
class TestSubarray {

	public static void main(String[] args) throws NoSuchMethodException {
		System.out.println();

		// maxSubArrayTests();
		stockTests();

		//Results
		int testsRun = TestHarness.getTestsRun();
		int failedTests = TestHarness.getFailedTests();
		System.out.print("\n" + TestHarness.YELLOW + "Ran " + testsRun + " test(s): ");
		System.out.println((failedTests == 0 ? "Success!": "Failed " + failedTests) + TestHarness.RESET);
	}

	private static void stockTests() throws NoSuchMethodException {
		{
			String input = "6\n5 15 6 3 9 14 12\n";
			String expectedOutput = "buy @ time 3\nsell @ time 5\n";
			Method m = Stocks.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "4\n4 600 2 20\n";
			String expectedOutput = "buy @ time 0\nsell @ time 1\n";
			Method m = Stocks.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "9\n4 400000 400001 3 30000 3000001 5 50005505 1\n";
			String expectedOutput = "buy @ time 3\nsell @ time 7\n";
			Method m = Stocks.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
	}

	private static void maxSubArrayTests() throws NoSuchMethodException {
		{
			String input = "2\n6\n-1 5 2 -2 1 -1\n8\n-1 5 -2 3 0 -1 2 1\n";
			String expectedOutput = "7\n8\n";
			Method m = MaxSubarray.class.getDeclaredMethod("runSlow", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "8\n3\n8 -7 1000\n3\n8 -8 1000\n3\n8 -9 1000\n5\n1 1 1 -4 1000\n5\n3 -1 5 -20 2\n5\n-3 -5 -1 -2 -14\n5\n3 5 1 2 14\n1\n-13\n";
			String expectedOutput = "1001\n1000\n1000\n1000\n7\n-1\n25\n-13\n";
			Method m = MaxSubarray.class.getDeclaredMethod("runSlow", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			int numElements = 40000;
			StringBuilder sb = new StringBuilder(2 * numElements + 4 + String.valueOf(numElements).length());
			sb.append("1\n" + numElements + "\n");
			for (int i = 0; i < numElements; i++) {
				sb.append('0');
				sb.append(' ');
			}
			sb.append('\n');

			String input = sb.toString();
			String expectedOutput = "0\n";
			Method m = MaxSubarray.class.getDeclaredMethod("runSlow", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			int numElements = 80000;
			StringBuilder sb = new StringBuilder(2 * numElements + 4 + String.valueOf(numElements).length());
			sb.append("1\n" + numElements + "\n");
			for (int i = 0; i < numElements; i++) {
				sb.append('0');
				sb.append(' ');
			}
			sb.append('\n');

			String input = sb.toString();
			String expectedOutput = "0\n";
			Method m = MaxSubarray.class.getDeclaredMethod("runSlow", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "2\n6\n-1 5 2 -2 1 -1\n8\n-1 5 -2 3 0 -1 2 1\n";
			String expectedOutput = "7\n8\n";
			Method m = MaxSubarray.class.getDeclaredMethod("runFast", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "8\n3\n8 -7 1000\n3\n8 -8 1000\n3\n8 -9 1000\n5\n1 1 1 -4 1000\n5\n3 -1 5 -20 2\n5\n-3 -5 -1 -2 -14\n5\n3 5 1 2 14\n1\n-13\n";
			String expectedOutput = "1001\n1000\n1000\n1000\n7\n-1\n25\n-13\n";
			Method m = MaxSubarray.class.getDeclaredMethod("runFast", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			int numElements = 40000;
			StringBuilder sb = new StringBuilder(2 * numElements + 4 + String.valueOf(numElements).length());
			sb.append("1\n" + numElements + "\n");
			for (int i = 0; i < numElements; i++) {
				sb.append('0');
				sb.append(' ');
			}
			sb.append('\n');

			String input = sb.toString();
			String expectedOutput = "0\n";
			Method m = MaxSubarray.class.getDeclaredMethod("runFast", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			int numElements = 80000;
			StringBuilder sb = new StringBuilder(2 * numElements + 4 + String.valueOf(numElements).length());
			sb.append("1\n" + numElements + "\n");
			for (int i = 0; i < numElements; i++) {
				sb.append('0');
				sb.append(' ');
			}
			sb.append('\n');

			String input = sb.toString();
			String expectedOutput = "0\n";
			Method m = MaxSubarray.class.getDeclaredMethod("runFast", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
	}
}
