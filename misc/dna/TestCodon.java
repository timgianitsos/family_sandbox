import testharness.TestHarness;

import java.lang.reflect.Method;
import java.io.*;

/*
Run the following to test:
javac -cp "./:../../" TestCodon.java && java -cp "./:../../" TestCodon
*/

class TestCodon {
	
	public static void main(String[] args) throws NoSuchMethodException {
		System.out.println();

		//Write tests here
		{
			String input = "1\n5\nCATCATCATCATCAT\n";
			String expectedOutput = "YES\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "1\n1\nGATGATGATGATGAT\n";
			String expectedOutput = "YES\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "3\n2\nGATC\n2\nGTACGCTAC\n3\nATTACGATTACATT\n";
			String expectedOutput = "NO\nYES\nYES\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "3\n2\nAAA\n2\nAAAA\n4\nGATTACA\n";
			String expectedOutput = "NO\nYES\nNO\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "3\n1\nCAT\n2\nGTCAGTAGGTA\n2\nACGACGA\n";
			String expectedOutput = "YES\nYES\nYES\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "1\n1\nGGG\n";
			String expectedOutput = "YES\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "1\n5\nCATCATCATCATCA\n";
			String expectedOutput = "NO\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			int size = 67;
			String header = "1\n2\n";
			StringBuilder sb = new StringBuilder(header.length() + size + 1);
			sb.append(header);
			for (int i = 0; i < size; i++) {
				sb.append(CodonAppearance.NUCLEOTIDES[(int)(Math.random() * 4)]);
			}
			sb.append('\n');

			String input = sb.toString();
			String expectedOutput = "YES\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			int size = 1000000;
			String header = "1\n15625\n";
			StringBuilder sb = new StringBuilder(header.length() + size + 1);
			sb.append(header);
			for (int i = 0; i < size; i++) {
				sb.append(CodonAppearance.NUCLEOTIDES[(int)(Math.random() * 4)]);
			}
			sb.append('\n');

			String input = sb.toString();
			String expectedOutput = "YES\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			int size = 10000000;
			String header = "1\n156250\n";
			StringBuilder sb = new StringBuilder(header.length() + size + 1);
			sb.append(header);
			for (int i = 0; i < size; i++) {
				sb.append(CodonAppearance.NUCLEOTIDES[(int)(Math.random() * 4)]);
			}
			sb.append('\n');

			String input = sb.toString();
			String expectedOutput = "YES\n";
			Method m = CodonAppearance.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}

		//Results
		int testsRun = TestHarness.getTestsRun();
		int failedTests = TestHarness.getFailedTests();
		System.out.print("\n" + TestHarness.YELLOW + "Ran " + testsRun + " test(s): ");
		System.out.println((failedTests == 0 ? "Success!": "Failed " + failedTests) + TestHarness.RESET);
	}
}
