package algorithm.chap3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataDecode {
	public static void main(String[] args) throws IOException {
		
		File file = new File("10000.txt");
		File file2 = new File("10000EWD.txt");
		Scanner scanner = new Scanner(file2);
		DataOutputStream stream = new DataOutputStream(new FileOutputStream(file));
		int size = scanner.nextInt();
		int edges = scanner.nextInt();
		stream.writeInt(size);
		stream.writeInt(edges);
		int from , to;
		double weight;
		for(int i=0;i<edges;i++) {
			from = scanner.nextInt();
			to = scanner.nextInt();
			weight = scanner.nextDouble();
			stream.writeInt(from);
			stream.writeInt(to);
			stream.writeDouble(weight);;
		}
		scanner.close();
		stream.close();
	}
}
