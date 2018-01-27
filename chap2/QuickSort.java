package algorithm.chap2;

public class QuickSort implements Sorter {

	@Override
	public void sort(int[] data, int size) {
		quickSort(data, 0, size-1);
	}
	
	private void quickSort(int[] data, int left,int right) {
		if(right <= left) { 
			return;
		}
		int i=left, j= right;
		int pos = data[i];
		while(i<j) {
			while(i<j && data[j] > pos) {
				j--;
			}
			if(i<j) {
				data[i++] = data[j];
			}
			
			while(i<j && data[i] <  pos) {
				i++;
			}
			if(i<j) {
				data[j--] = data[i];
			}
		}
		data[i] = pos;
		quickSort(data, left, i-1);
		quickSort(data, i+1, right);
	}
	
}
