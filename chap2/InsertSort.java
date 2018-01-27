package algorithm.chap2;

public class InsertSort implements Sorter {

	@Override
	public void sort(int[] data, int size) {
		for (int i = 1; i < size; i++) {
			int value = data[i];
			int j;
			for (j = i; j > 0 && data[j - 1] > value; j--) {
				data[j] = data[j - 1];
			}
			data[j] = value;
		}
		
	}

}
