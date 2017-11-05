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

		//Write tests here
		//input and output are always string objects
		{
			String input = "2\n6\n-1 5 2 -2 1 -1\n8\n-1 5 -2 3 0 -1 2 1\n";
			String expectedOutput = "7\n8\n";
			Method m = MaxSubarray.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
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
			Method m = MaxSubarray.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
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
			Method m = MaxSubarray.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}

		//Results
		int testsRun = TestHarness.getTestsRun();
		int failedTests = TestHarness.getFailedTests();
		System.out.print("\n" + TestHarness.YELLOW + "Ran " + testsRun + " test(s): ");
		System.out.println((failedTests == 0 ? "Success!": "Failed " + failedTests) + TestHarness.RESET);
	}
}
