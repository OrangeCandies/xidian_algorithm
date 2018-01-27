package algorithm.chap3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dijkstra {
	private Graph graph;
	// 标记数组不是必须需要的东西，但是有的话会快  :-)
	private boolean[] marked;
	private double[] distTo;
	private int[] from;
	
	public Dijkstra(Graph graph) {
		this.graph = graph;
		int size = graph.getSize();
		marked = new boolean[size];
		distTo = new double[size];
		from = new int[size];
		
		for(int i=0;i<distTo.length;i++) {
			distTo[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<from.length;i++) {
			from[i] = i;
		}
		
	}
	
	public List<Integer> getMinPath(int from,int to){
		List<Integer> list = null;
		distTo[from] = 0;
		marked[from] = true;
		MinIndexHeap<Double> minIndexHeap = new MinIndexHeap(graph.getSize());
		minIndexHeap.insert(from, 0.0);
		while(!minIndexHeap.isEmpty()) {
			int  minIndex = minIndexHeap.extractMinIndex();
			marked[minIndex] = true;
			
			List<Edge> edges = graph.getEdges(minIndex);
			for(Edge e : edges) {
				int pos = e.getTo();
				if(!marked[pos]) {
					if(distTo[pos] > distTo[minIndex]+e.getWeight()) {
						distTo[pos] = distTo[minIndex] + e.getWeight();
						this.from[pos] = minIndex;
						
						if(minIndexHeap.contains(pos)) {
							minIndexHeap.change(pos, distTo[pos]);
						}else{
							minIndexHeap.insert(pos, distTo[pos]);
						}
					}
				}
			}
		}
		if(distTo[to] < Integer.MAX_VALUE) {
			System.out.println("The min path is "+distTo[to]);
			return showPathTo(from,to);
		}
		return list;
	}
	
	private List<Integer> showPathTo(int f,int to){
		Stack<Integer>stack = new Stack<>();
		List<Integer> ans = new ArrayList<>();
		
		while(from[to] != to) {
			stack.push(to);
			to = from[to];
		}
		stack.push(f);
		while(!stack.isEmpty()) {
			ans.add(stack.pop());
		}
		return ans;
	}
}
