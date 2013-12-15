import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Milkshakes {
//	static boolean DEBUG = false;
	static boolean DEBUG = true;
	
	static int cases, counter = 0;
//	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner;
	static File inputFile, outputFile;
	static BufferedWriter bw;
	
	public static void main(String args[]) throws IOException{

//		String fileName = "B-large-practice";
		String fileName = "B-small-practice";
		String outPutString;
		inputFile = new File(fileName + ".in");
		outputFile = new File(fileName + ".out");
		scanner = new Scanner(new FileReader(inputFile));
		bw = new BufferedWriter(new FileWriter(outputFile));
		cases = scanner.nextInt();
		while(++counter <= cases){
			int totalFlavors = scanner.nextInt();
			int totalCustomers = scanner.nextInt();
			// for every customer:
			List<Map<Integer, Integer>> customer = new ArrayList<Map<Integer, Integer>>();
			for (int i = 0; i < totalCustomers; i++){
				int flavors = scanner.nextInt();
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int j = 0; j < flavors; j++){
					map.put(scanner.nextInt(), scanner.nextInt());
				}
				customer.add(map);
			}
		}
	}
}
