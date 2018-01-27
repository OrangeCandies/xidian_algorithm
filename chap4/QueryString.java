package algorithm.chap4;


import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *  
 */
public class QueryString {
	public static void main(String[] args) throws FileNotFoundException {
		// temp.txt  	
		// alice29.txt  	152098
		// bible.txt 		4047392
		String fileName = "bible.txt";
		Scanner scanner = new Scanner(System.in);
		TextIndex.getTextIndex(fileName);
		while(true) {
			String string = scanner.nextLine();
			TextIndex.getIndex(string);
		}
	}
}
