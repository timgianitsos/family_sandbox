import java.util.*;
import java.io.*;
class plus_minus {
        public static void main(String[] args) {
            run(System.in, System.out);
        }

        private static void run(InputStream in, PrintStream out) {
            Scanner scan = new Scanner(in);
            int n = scan.nextInt();
            scan.nextLine();
            int[] nums = new int[n]; 
            for (int i = 0; i < n; i++) {
                nums[i] = scan.nextInt();
            }
            double pos = 0;
            double neg = 0;
            double zer = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    pos++;
                }
                if (nums[i] < 0) {
                    neg++;
                }
                if (nums[i] == 0) {
                    zer++;
                }
            }
            out.println(pos/n);
            out.println(neg/n);
            out.println(zer/n);
        }
}