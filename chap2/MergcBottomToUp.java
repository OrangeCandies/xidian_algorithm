package algorithm.chap2;

public class MergcBottomToUp implements Sorter{

	@Override
	public void sort(int[] data, int size) {
		for(int sz = 1; sz < size; sz = sz+sz) {
			for(int i = 0; i +sz < size; i += sz+sz ) {
				megrc(data, i, i+sz-1, Math.min(i+sz+sz- 1, size-1));
			}
		}
		
	}
	
	private void megrc(int[] data,int left,int mid,int right) {
		int[] aux = new int[right-left+1];
		int i=left,j=mid+1;
		int pos = 0;
		while(i<=mid || j <= right) {
			if(i<=mid && (j > right || data[i] < data[j])) {
				aux[pos++] = data[i++];
			}else {
				aux[pos++] = data[j++];
			}
		}
		
		for(i=0;i<pos;i++) {
			data[i+left] = aux[i];
		}
	}

}
