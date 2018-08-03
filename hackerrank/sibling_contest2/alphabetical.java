import java.util.*;
import java.io.*;
class alphabetical {
        public static void main(String[] args) {
            run(System.in, System.out);
        }

        private static void run(InputStream in, PrintStream out) {
            Scanner scan = new Scanner(in);
            String str = scan.nextLine();
            String newstr = "";
            Set<Character> alpha = new TreeSet<>();
            for (int i = 0; i < str.length(); i++) {
            	alpha.add(str.charAt(i));
            }
            for (Character c: alpha) {
            	out.print(c);
            }
            out.println();
            

        }    
}