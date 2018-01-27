package algorithm.chap3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int size;
	private List<List<Edge>> eLists;
	
	public Graph(int size) {
		this.size = size;
		eLists = new ArrayList<>(size);
		for(int i=0;i<size;i++) {
			eLists.add(new LinkedList<>());
		}
	}
	
	public void insert(int from, int to , double weight) {
		List<Edge> list = eLists.get(from);
		list.add(new Edge(to, weight));
	}
	
	public List<Edge> getEdges(int pos){
		return eLists.get(pos);
	}
	
	public int getSize() {
		return size;
	}
}

