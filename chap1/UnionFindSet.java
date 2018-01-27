package algorithm.chap1;

import java.util.Random;

public class UnionFindSet {
	private int number;
	private int[] map;
	private boolean[] blocks;
	private int N;

	public UnionFindSet(int input_n) {
		N = input_n;
		map = new int[N * N + 2];
		blocks = new boolean[N * N];
		number = 0;
		
		for (int i = 0; i < N * N; i++) {
			map[i] = i;
			blocks[i] = false;
		}
		map[N * N] = N * N;
		map[N * N + 1] = N * N + 1;
	}

	public void clear() {
		number = 0;
		for (int i = 0; i < N * N; i++) {
			map[i] = i;
			blocks[i] = false;
		}
		map[N * N] = N * N;
		map[N * N + 1] = N * N + 1;
	}

	public boolean isBlock(int n) {
		if (n > 0) {
			return !blocks[n];
		} else {
			return false;
		}

	}

	public int find(int n) {
		if (0 <= n && n < N) {
			return map[N * N];
		}
		if (n >= N * N - N - 1 && n < N * N) {
			return map[N * N + 1];
		}
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
		return find(N * N) == find(N * N + 1);
	}

	public static void main(String[] args) {
		Random random = new Random();

		double sum = 0;
		int s = 10000;
		Long begin = System.currentTimeMillis();
		UnionFindSet set = new UnionFindSet(200);
		while (s > 0) {

			while (true) {
				if (set.isAccess()) {
					sum += set.getPossible();
					break;
				}
				int n = random.nextInt(40000);
				while (!set.isBlock(n)) {
					n = random.nextInt(40000);
				}
				set.makeAccess(n);
			}
			set.clear();
			s--;
		}
		Long end = System.currentTimeMillis();

		System.out.println("Had 100000 times 200*200 repeat test cost " + (Long) (end - begin) / 1000 + " s "
				+ "and get " + sum / 100000 + " on average");

	}

}
