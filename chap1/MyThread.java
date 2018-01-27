package algorithm.chap1;

import java.util.Random;

public class MyThread extends Thread{
	
	private static int times = 0;
	public static void setTimes(int times) {
		MyThread.times = times;
	}
	private int s;
	private ThreadControl control;
	private Object lock = null;
	public MyThread(int s, Object object,ThreadControl control) {
		this.s = s;
		this.lock = object;
		this.control = control;
	}
    @Override
    public void run() {
    	NewUnionSet set = new NewUnionSet(2000);
    	Random random = new Random();
    	double sum = 0;
		while (s > 0) {
			while (true) {
				if (set.isAccess()) {
					sum += set.getPossible();
					break;
				}
				int n = random.nextInt(4000000);
				while (!set.isBlock(n)) {
					n = random.nextInt(4000000);
				}
				set.makeAccess(n);
			}
			set.clear();
			s--;
		}
		control.sumToUp(sum);
	
		synchronized (lock) {
			times--;
			if(times == 0) {
				lock.notify();
			}
		}
    }
}
