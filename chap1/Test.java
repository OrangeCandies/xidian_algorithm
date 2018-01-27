package algorithm.chap1;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random random = new Random();
		double sum = 0;
		int s = 10000;
		Long begin = System.currentTimeMillis();
		ThreadControl control = new ThreadControl();
		 sum = control.toRunTask(4, 25);
		Long end = System.currentTimeMillis();

		System.out.println("Had 100 times 2000*2000 repeat test cost " + (Long) (end - begin) / 1000.00 + " s "
				+ "and get " + sum / 100 + " on average");

	}
}
