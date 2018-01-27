package algorithm.chap2;

public class TopToButtomMergcSort implements Sorter{

	@Override
	public void sort(int[] data, int size) {
		int [] temp = new int[data.length];
		mergcSort(data, temp, 0, data.length-1);
	
	}
	
	private void mergcSort(int[]data,int[] temp,int left,int right) {
		if(right<=left) {
			return;
		}
		
		int mid = (left+right)/2;
		mergcSort(data, temp, left, mid);
		mergcSort(data, temp, mid+1, right);
		for(int i=left;i<=right;i++) {
			temp[i] = data[i];
		}
		int i=left,j=mid+1;
		int pos = left;
		while(i<=mid||j<=right) {
			if(i<=mid &&(j > right || temp[i]<temp[j])) {
				data[pos++] = temp[i++];
			}else {
				data[pos++] = temp[j++];
			}
		}
	}
	
}
