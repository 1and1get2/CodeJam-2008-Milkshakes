import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
/* http://www.hankcs.com/uncategorized/google-code-jam-2008-round-1a-b-milkshakes-tan-xin-suan-fa-shi-xian.html
 * http://blog.csdn.net/logic_nut/article/details/4536505
 * Start with every flavor unmalted and consider the customers one by one.
 * If there is an unsatisfied customer who only likes unmalted flavors, and all those flavors have been made malted, then no solution is possible.
 * If there is an unsatisfied customer who has one favorite malted flavor, then we must make that flavor malted. We do this, then go back to step 2.
 * If there are no unsatisfied customers, then we already have a valid solution and can leave the remaining flavors unmalted.
 */
public class Milkshakes2 {
	static boolean DEBUG = false;
//	static boolean DEBUG = true;

	static int cases, counter = 0;
	// static Scanner scanner = new Scanner(System.in);
	static Scanner scanner;
	static File inputFile, outputFile;
	static BufferedWriter bw;
	private class Milkshakes{

	}
	private static int abs(int integer){
		return integer > 0 ? integer : -integer;
	}
	

	public static void main(String args[]) throws IOException {

//		 String fileName = "B-large-practice";
		String fileName = "B-small-practice-my";
		String outPutString;
		inputFile = new File(fileName + ".in");
		outputFile = new File(fileName + ".out");
		scanner = new Scanner(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		cases = scanner.nextInt();
		while (++counter <= cases) {
			int totalFlavors = scanner.nextInt();
			int totalCustomers = scanner.nextInt();
			List<Map<Integer, Integer>> customers = new ArrayList<Map<Integer, Integer>>();
			// for every customer:
			for (int i = 0; i < totalCustomers; i++) {
				int flavors = scanner.nextInt();
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int j = 0; j < flavors; j++) {
					map.put(scanner.nextInt(), scanner.nextInt());
				}
				customers.add(map);
				
				
			}
			
			outPutString = ("Case #" + counter + ": " + (customers + " " + totalFlavors));
			bw.write(outPutString);
			bw.newLine();
			System.out.println(outPutString);
			
		}
		bw.flush();
		bw.close();
	}

}
