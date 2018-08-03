import java.util.*;
import java.io.*;
class DNA {
        public static void main(String[] args) {
            run(System.in, System.out);
        }

        private static void run(InputStream in, PrintStream out) {
            Scanner scan = new Scanner(in);
            String str = scan.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            map.put('G', 0);
            map.put('A', 0);
            map.put('T', 0);
            map.put('C', 0);
            for (int i = 0; i < str.length(); i++) {
            	map.put(str.charAt(i), map.get(str.charAt(i)) + 1);

            }
            int big = Integer.MIN_VALUE;
            char giant = '\0';
            for (Map.Entry<Character, Integer> pear : map.entrySet()) {
            	if (pear.getValue() > big) {
            		big = pear.getValue();
            		giant = pear.getKey();
            	}
            }
            out.print(giant);
            out.print(" " + map.get(giant));
        }
}