package algorithm.chap1;

import java.util.Random;
/**
 *  
 *  @author liuhui
 *  @date 2017 09 30
 */
public class NewUnionSet {
	private int number;
	private int[] map;
	private boolean[] blocks;
	private int N;
/**
 * @param size
 */
	public NewUnionSet(int N) {
		this.N = N;
		map = new int[N * N];
		blocks = new boolean[N * N];
		number = 0;
		for (int i = 0; i < N; i++) {
			map[i] = 0;
			blocks[i] = false;
		}
		for (int i = N; i < N * N - N; i++) {
			map[i] = i;
			blocks[i] = false;
		}
		for(int i=N*N-N;i<N*N;i++) {
			map[i] = N*N-N;
			blocks[i] = false;
		}
	}

	public void clear() {
		number = 0;
		for (int i = 0; i < N; i++) {
			map[i] = 0;
			blocks[i] = false;
		}
		for (int i = N; i < N * N - N; i++) {
			map[i] = i;
			blocks[i] = false;
		}
		for(int i=N*N-N;i<N*N;i++) {
			map[i] = N*N-N;
			blocks[i] = false ;
		}
	}
	/**
	 * 
	* @Title: isBlock 
	* @Description: TODO 
	* @param n
	* @return   
	* @return boolean
	 */
	public boolean isBlock(int n) {
		if (n > 0) {
			return !blocks[n];
		} else {
			return false;
		}

	}

	public int find(int n) {
		if (n != map[n]) {
			map[n] = find(map[n]);
		}
		return map[n];
	}

	public void union(int n1, int n2) {

		int father1 = find(n1);
		int father2 = find(n2);
		if (father1 != father2) {
			map[father1] = father2;
		}
	}

	public void makeAccess(int n) {
		number++;
		blocks[n] = true;
		if ((n - 1) / N == n / N) {
			if (n - 1 >= 0 && !isBlock(n - 1)) {
				union(n - 1, n);
			}
		}
		if ((n - N) >= 0) {
			if (!isBlock(n - N)) {
				union(n - N, n);
			}
		}
		if ((n + N) < N * N) {
			if (!isBlock(n + N)) {
				union(n + N, n);
			}
		}
		if ((n + 1) / N == n / N) {
			if (n + 1 < N * N && !isBlock(n + 1)) {
				union(n + 1, n);
			}
		}
	}

	public double getPossible() {

		return number * 1.0 / (N * N);
	}

	public boolean isAccess() {
		return find(0) == find(N * N-N);
	}

}
