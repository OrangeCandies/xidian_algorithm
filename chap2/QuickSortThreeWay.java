package algorithm.chap2;

public class QuickSortThreeWay implements Sorter {

	@Override
	public void sort(int[] data, int size) {
		quickSort(data, 0, data.length-1);
	}
	
	private void quickSort(int[] data,int left,int right) {
		
		if(right <= left) {
			return;
		}
		int lt = left,li = lt+1;
		int ht = right+1;
		int pos = data[lt];
		while(li<ht) {
			if(data[li] < pos) {
				int temp = data[li];
				data[li++] = pos;
				data[++lt] = temp;
			}else if(data[li] > pos) {
				int temp = data[--ht];
				data[ht] = data[li];
				data[li] = temp;
			}else {
				li++;
			}
		}
		
		int temp = data[left];
		data[left] = data[lt];
		data[lt] = temp;
		quickSort(data, left, lt-1);
		quickSort(data, ht, right);
	}
}
