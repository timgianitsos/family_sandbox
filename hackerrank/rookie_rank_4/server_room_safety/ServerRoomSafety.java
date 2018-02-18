import java.util.*;
import java.io.*;

class ServerRoomSafety {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		TreeMap<Integer, Integer> positionToHeight = new TreeMap<>();
		int[] positions = new int[n];
		for (int i = 0; i < n; i++) {
			positions[i] = scan.nextInt();
		}
		for (int i = 0; i < positions.length; i++) {
			positionToHeight.put(positions[i], scan.nextInt());
		}

		Iterator<Map.Entry<Integer, Integer>> it = positionToHeight.entrySet().iterator();
		Map.Entry<Integer, Integer> prev = it.next();
		boolean left = true;
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> current = it.next();
			if (prev.getKey() + prev.getValue() < current.getKey()) {
				left = false;
				break;
			}
			prev = current;
		}

		Iterator<Integer> it2 = positionToHeight.descendingKeySet().iterator();
		Integer prevKey = it2.next();
		Integer prevVal = positionToHeight.get(prevKey);
		boolean right = true;
		while (it2.hasNext()) {
			Integer currentKey = it2.next();
			if (prevKey - prevVal > currentKey) {
				right = false;
				break;
			}
			prevKey = currentKey;
			prevVal = positionToHeight.get(prevKey);
		}
		out.println(left && right ? "BOTH" : left ? "LEFT" : right ? "RIGHT" : "NONE");
	}
}
/*
in:

out:

*/
	
