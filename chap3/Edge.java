package algorithm.chap3;

public class Edge{
	double weight;
	int to;

	public Edge(int to, double weight) {
		this.weight = weight;
		this.to = to;
	}
	
	public double getWeight() {
		return (Double)weight;
	}
	public int getTo() {
		return to;
	}
}

