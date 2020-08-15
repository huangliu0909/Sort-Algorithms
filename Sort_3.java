import java.util.Arrays;

public class Sort_3 {
	
	public static void Quicksort(int[] array, int start, int end) {
		if(end > start) {
			int pivot = array[end];
			int i = start, j = end;
			while(i < j) {
				swap(array, i, j);
				if(array[i] < pivot) i ++;
				if(array[j] > pivot) j --;
			}
			Quicksort(array, start, i - 1);  // Before pi
			Quicksort(array, i + 1, end); // After pi
		}
	}
	
	public static int[] heapsort(int[] array) {
		int[] h = new int[0];
		for(int i = 0; i < array.length; i ++) {
			h = arrAppend(h, array[i]);
			int k = i;
			while(h[k] > h[(int) Math.floor(k/2)]) {
				swap(h, k, (int) Math.floor(k/2));
				k = (int) Math.floor(k/2);
			}
		}
		swap(h, 0, h.length - 1);
		return heapify(h, h.length - 2);
	}
	
	public static int[] heapify(int[] array, int i) {
		if(0 < i) {
			int k = 0;
			while(k + 2 <= i) {
				if(array[k + 1] < array[k + 2]) {
					swap(array, k, k + 2);
					k = k + 2;
				}
				else {
					swap(array, k, k + 1);
					k = k + 1;
				}
			}
			swap(array, 0, i);
			return heapify(array, i - 1);
		}
		else return array;
	}
	
	public static void main(String[] args) {
		 int[] array = new int[] {123, 2, 34, 678, 345, 890, 235, 789, 23, 49, 843, 56, 234};
		 //Quicksort(array, 0, array.length - 1);
		 System.out.println(Arrays.toString(heapsort(array)));
		 //[2, 23, 34, 49, 56, 123, 234, 235, 345, 678, 789, 843, 890]
	}
	
	private static void swap(int[] array, int i, int j) {
		int flag = array[i];
		array[i] = array[j];
		array[j] = flag;
	}
	
	private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

}
