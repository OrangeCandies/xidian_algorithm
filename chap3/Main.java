package algorithm.chap3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File("largeEWD.txt");
		Scanner scanner = new Scanner(new FileInputStream(file));
		long beginRead = System.currentTimeMillis();   
		
		int size = scanner.nextInt();
		Graph graph = new Graph(size);
		int edges = scanner.nextInt();
		int from ,to;
		double weight;
		for(int i=0;i<edges;i++) {
			from = scanner.nextInt();
			to = scanner.nextInt();
			weight = scanner.nextDouble();
			graph.insert(from, to, weight);
		}
		long endRead= System.currentTimeMillis();
		System.out.println("Read File Cost time "+(endRead-beginRead)+" ms");
		
		long begin = System.currentTimeMillis();
		Dijkstra dijkstra = new Dijkstra(graph);
		
		
		List<Integer> ans = dijkstra.getMinPath(0,9999);
		long end = System.currentTimeMillis();
		System.out.println("Find shortest path Cost time "+(end-begin)+" ms");
		for(int i:ans) {
			System.out.print("->"+i);
		}
	}
}
