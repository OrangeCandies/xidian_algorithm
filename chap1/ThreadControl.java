package algorithm.chap1;

import java.time.temporal.TemporalUnit;

public class ThreadControl {
    private double allsum = 0;
    public synchronized void sumToUp(double sum) {
	    allsum+=sum;
	}
    
    public double toRunTask(int number, int size) {
    	Object object = new Object();
    	
    	
    	MyThread.setTimes(number);
    	for(int i=0;i<number;i++) {
    		MyThread thread = new MyThread(size, object,this);
    		thread.start();
    	}
   
    	try {
			synchronized (object) {
			    object.wait();	
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	return allsum;
    }
}
