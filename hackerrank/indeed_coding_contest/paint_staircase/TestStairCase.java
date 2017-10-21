import testharness.TestHarness;

import java.lang.reflect.Method;
import java.io.*;

// javac -cp "./:../../../" TestStairCase.java && java -cp "./:../../../" TestStairCase

class TestStairCase {
	public static void main(String[] args) throws NoSuchMethodException{

		//Tests here
		//input and output are always string objects
		{
			String input = "2 3";
			String expectedOutput = "24\n";
			Method m = PaintStaircase.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
		{
			String input = "1 4";
			String expectedOutput = "28\n";
			Method m = PaintStaircase.class.getDeclaredMethod("run", InputStream.class, PrintStream.class);
			TestHarness.test(input, expectedOutput, m);
		}
	}
}