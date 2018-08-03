import java.util.*;
import java.io.*;
class Translate_greek {
        public static void main(String[] args) {
            run(System.in, System.out);
        }

        private static void run(InputStream in, PrintStream out) {
            Scanner scan = new Scanner(in);
            int n = scan.nextInt();
            scan.nextLine();
            Map<String, String> strs = new HashMap<>();
            for (int i = 0; i < n; i++) {
            	String eng = scan.next();
            	String gre = scan.next();
            	strs.put(gre, eng);
            }
            scan.nextLine();

            String [] sent = scan.nextLine().split(" ");
            for (int i = 0; i < sent.length; i++) {
            	out.print(strs.get(sent[i]));
            	out.print(" ");
            }
            out.println();
      	}  
}