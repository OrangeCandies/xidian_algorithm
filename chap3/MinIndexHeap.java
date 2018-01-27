package algorithm.chap3;



public class MinIndexHeap <Item extends Comparable> {
	private Item[] data;
	private int[] indexes;
	private int[] reverse;
	
	private int capacity;
	private int count;
	
	@SuppressWarnings("unchecked")
	public MinIndexHeap(int capacity) {
		this.capacity = capacity;
		count =0;
		data = (Item[]) new Comparable[capacity];
		indexes = new int[capacity];
		reverse = new int[capacity];
		for(int i=0;i<capacity;i++){
			reverse[i] = -1;
		}
	}
	
	public boolean contains(int i) {
		return reverse[i] != -1;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	public void insert(int pos,Item item) {
		if(count == capacity) {
			throw new ArrayIndexOutOfBoundsException("capacity is full");
		}
		
		data[pos] = item;
		indexes[count] = pos;
		reverse[pos] = count;
		shiftUp(count);
		count++;
	}
	
	
	public Item extractMin() {
		Item value = data[indexes[0]];
		swapIndexes(0,count-1);
		count--;
		reverse[indexes[count]] = -1;
		shiftDown(0);
		return value;
	}

	public int extractMinIndex() {
		int index = indexes[0];
		swapIndexes(0, count-1);
		count--;
		reverse[indexes[count]] = -1;
		shiftDown(0);
		return index;
	}
	
	public void change(int i,Item value) {
		if(contains(i)) {
			data[i] = value;
			shiftDown(reverse[i]);
			shiftUp(reverse[i]);
		}
	}
	
	
	private void swapIndexes(int i,int j) {
		int indexi = indexes[i];
		int indexj = indexes[j];
		indexes[i] = indexj;
		indexes[j] = indexi;
		reverse[indexi] = j;
		reverse[indexj] = i;
	}
	@SuppressWarnings("unchecked")
	private void shiftUp(int pos) {
		while(pos > 0 && data[indexes[pos]].compareTo( data[indexes[(pos-1)/2]]) < 0) {
			swapIndexes(pos, (pos-1)/2);
			pos =(pos-1)/2;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void shiftDown(int pos) {
		while(pos*2+1 < count) {
			int l = pos*2+1;
			if(pos*2+2 < count && data[indexes[pos*2+2]].compareTo(data[indexes[l]]) <0) {
				l++;
			}
			if(data[indexes[l]].compareTo( data[indexes[pos]]) >0) {
				break;
			}else {
				swapIndexes(l, pos);
			}
			pos = l;
		}
	}
}
