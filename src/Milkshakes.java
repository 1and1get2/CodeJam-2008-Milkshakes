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

public class Milkshakes {
	static boolean DEBUG = false;
//	static boolean DEBUG = true;

	static int cases, counter = 0;
	// static Scanner scanner = new Scanner(System.in);
	static Scanner scanner;
	static File inputFile, outputFile;
	static BufferedWriter bw;

	public static void main(String args[]) throws IOException {

//		 String fileName = "B-large-practice";
		String fileName = "B-small-practice";
		String outPutString;
		inputFile = new File(fileName + ".in");
		outputFile = new File(fileName + ".out");
		scanner = new Scanner(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		cases = scanner.nextInt();
		while (++counter <= cases) {
			int totalFlavors = scanner.nextInt();
			int totalCustomers = scanner.nextInt();
			// for every customer:
			List<Map<Integer, Integer>> customers = new ArrayList<Map<Integer, Integer>>();
			for (int i = 0; i < totalCustomers; i++) {
				int flavors = scanner.nextInt();
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int j = 0; j < flavors; j++) {
					map.put(scanner.nextInt(), scanner.nextInt());
				}
				customers.add(map);
			}
			
			outPutString = ("Case #" + counter + ": " + 
					checkAvailablity(customers, totalFlavors));
			bw.write(outPutString);
			bw.newLine();
			System.out.println(outPutString);
			
		}
		bw.flush();
		bw.close();
	}
	
	// check if valid for every single case
	private static String checkAvailablity(List<Map<Integer, Integer>> customers, int totalFlavors) {
		// enum every position of the "1"
		for (int position = 0; position < totalFlavors; position++) {
			boolean isStillSatisfied = true;
			// for every customer:
			for (int j = 0; j < customers.size(); j++){
				if (!isCustomerSatisfied(customers.get(j), position)){
					isStillSatisfied = false;
					break;
				}
				
			}
			// every customer is satisfied
			if (isStillSatisfied){
				return getReturnString(totalFlavors, position);
			}
		}
		return "IMPOSSIBLE";
	}
	// check if one specified customer is satisfied
	private static boolean isCustomerSatisfied(Map<Integer, Integer> map, int position){
		//Map.Entry<Integer, Integer> entry = (Entry<Integer, Integer>) map.entrySet();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
		    //System.out.println("position: " + position + ", Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    if ( entry.getKey()-1 == position ? value == 1 : value == 0){
		    	return true;
		    }
		}
		if (DEBUG) System.out.println("customer is not happy, position: " + position );
		return false;
	}
	private static String getReturnString(int length, int position) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += (i == position ? "1 " : "0 ");
		}
		return str;
	}
}
