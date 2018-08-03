import java.util.*;
import java.io.*;
class exclamation {
        public static void main(String[] args) {
                run(System.in, System.out);
        }

        private static void run(InputStream in, PrintStream out) {
                Scanner scan = new Scanner(in);
                int n = scan.nextInt();
                scan.nextLine();
                String[] strs = new String[n];
                for (int i = 0; i < n; i++) {
                	strs[i] = scan.nextLine();
                }
                scan.close();
                String exc = "!";
                for (int i = 0; i < strs.length; i++) {
                	System.out.println(strs[i] + exc);
                }
        }
}