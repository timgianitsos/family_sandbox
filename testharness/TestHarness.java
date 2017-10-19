package testharness;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import java.lang.reflect.Method;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Tim Gianitsos
 */
public class TestHarness {

	private static final Charset ENCODING = StandardCharsets.UTF_8;

	private static int testNo = 0;
	private static int failedTests = 0;

	public static final String RED = "\033[0;31m";
	public static final String GREEN = "\033[0;32m";
	public static final String YELLOW = "\033[0;33m";
	public static final String RESET = "\033[0m";

	public static void test(String input, String expectedOutput, Method method) {
		if (input == null || expectedOutput == null || method == null) {
			throw new IllegalArgumentException("Parameters cannot be null");
		}

		method.setAccessible(true);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();

		InputStream in;
		PrintStream out;
		try {
			in = new ByteArrayInputStream(input.getBytes(ENCODING));
			out = new PrintStream(stream, true, ENCODING.name());
		}
		catch (UnsupportedEncodingException e) {
			in = new ByteArrayInputStream(input.getBytes());
			out = new PrintStream(stream, true);
		}

		double elapsedTime;
		boolean exceptionThrown;
		try {
			long start = System.nanoTime();
			method.invoke(null, in, out);
			elapsedTime = (System.nanoTime() - start) / 1000000000.0;
			exceptionThrown = false;
		}
		catch (Exception e) {
			e.printStackTrace(out);
			elapsedTime = 0;
			exceptionThrown = true;
		}

		String result;
		try {result = stream.toString(ENCODING.name());}
		catch (UnsupportedEncodingException e) {result = stream.toString();}
		System.out.println("Test " + testNo + " elapsed time: " + elapsedTime + " seconds");

		if (!expectedOutput.equals(result) || exceptionThrown) {
			failedTests++;
			System.out.println(RED + "FAILED: " + (exceptionThrown ? "Exception thrown": "Invalid output") + RESET);
			System.out.println("Expected output:\n" + expectedOutput);
			System.out.println("Actual output:\n" + result);
		}
		else {
			System.out.println(GREEN + "PASSED" + RESET);
		}

		System.out.println(YELLOW + "--------------------------------" + RESET);
		out.close();
		testNo++;
	}

	public static int getTestsRun() {
		return testNo;
	}

	public static int getFailedTests() {
		return failedTests;
	}
}
