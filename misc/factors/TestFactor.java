import testharness.TestHarness;

import java.lang.reflect.Method;
import java.io.*;

/*
Run the following to test:
javac -cp "./:../../" TestFactor.java && java -cp "./:../../" TestFactor
*/

class TestFactor {
	public static void main(String args[]) throws Exception {
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
	}
}
