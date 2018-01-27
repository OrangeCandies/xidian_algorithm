package algorithm.chap2;

import java.util.Random;


public class DataHelper {
	
	public static int[] getRandomDataArray(int size, int lRandom,int rRandom) {
		int [] data = new int[size];
		Random random = new Random();
		for(int i=0;i<size;i++) {
			data[i] = random.nextInt(rRandom-lRandom)+lRandom;
		}
		
		return data;
	}
	
	public static int[] copyWithDataArray(int []data,int size) {
		int [] newData = new int[size];
		for(int i=0;i<size;i++) {
			newData[i] = data[i];
		}
		return newData;
	}
	
	public static boolean checkArray(int[] data, int size) {
		for(int i=1;i<size;i++) {
			if(data[i] < data[i-1]) {
				return false;
			}	
		}
		return true;
	}
	
	public static void main(String[] args) {
		int [] data = DataHelper.getRandomDataArray(100000, 0, 10000);
		Sorter q1 = new QuickSort();
		int[] copydata1 = copyWithDataArray(data, data.length);
		sort(q1, copydata1);
		Sorter q2 = new QuickSortThreeWay();
		int[] copydata2 = copyWithDataArray(data, data.length);
		sort(q2, copydata2);
		Sorter q4 = new MergcBottomToUp();
		int[] copydata4 = copyWithDataArray(data, data.length);
		sort(q4, copydata4);
		Sorter q5 = new TopToButtomMergcSort();
		int[] copydata5 = copyWithDataArray(data, data.length);
		sort(q5, copydata5);
		Sorter q3 = new InsertSort();
		int[] copydata3 = copyWithDataArray(data, data.length);
		sort(q3, copydata3);
		
		
	}
	
	public static void sort(Sorter s,int[]data) {
		long beginTime = System.currentTimeMillis();
		s.sort(data, data.length);
		long endTime = System.currentTimeMillis();
		System.out.println(s.getClass().getName()+" cost time "+(endTime-beginTime)+" ms "+checkArray(data, data.length));
		
	}
}
