import java.util.*;
import java.io.*;
class Zip_it {
        public static void main(String[] args) {
            run(System.in, System.out);
        }

        private static void run(InputStream in, PrintStream out) {
            Scanner scan = new Scanner(in);
            String[] a = scan.nextLine().split(" ");
            String[] b = scan.nextLine().split(" ");
            for (int i = 0; i < a.length; i++) {
            	out.print(a[i]);
            	out.print(b[i]);
            }
           
            out.println();
            
        }}