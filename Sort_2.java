import java.util.Arrays;

public class Sort_2 {
	
	public static void merge_sort(int[] array, int start, int end) {
		if(start < end) {
			int mid = (end + start)/2;
			merge_sort(array, start, mid);
			merge_sort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}
	

	public static void merge(int[] array, int start, int mid, int end) {
		int[] left = Arrays.copyOfRange(array, start, mid + 1);
		int[] right = Arrays.copyOfRange(array, mid + 1, end + 1);
		//Arrays.copyOfRange左闭右开
		int i = 0, j = 0, count = start;
		while(i != left.length && j != right.length) {
			if(left[i] < right[j]) {
				array[count] = left[i];
				count ++;
				i ++;
			}
			else {
				array[count] = right[j];
				count ++;
				j ++;
			}
		}
		//更新count和i或者j
		while(i < left.length) {
			array[count] = left[i];
			i ++;
			count ++;
		}
		while(j < right.length) {
			array[count] = right[j];
			j ++;
			count ++;
		}
	}
	
	public static void tim_sort(int[] array, int RUN)  
    { 
        for (int i = 0; i < array.length; i += RUN)  
        { 
        	insertion_sort(array, i, Math.min((i + RUN), (array.length - 1))); 
        } 
        // System.out.println(Arrays.toString(array));
        // [2, 34, 123, 678, 234, 345, 789, 890, 23, 49, 56, 843, 234]
        for (int size = RUN; size < array.length; size = 2 * size)  
        { 
            for (int left = 0; left < array.length; left += 2 * size)  
            { 
                int mid = left + size - 1; 
                int right = Math.min((left + 2 * size - 1), (array.length - 1)); 
                merge(array, left, mid, right); 
            } 
        } 
    } 
	
	public static void bucket_sort(int[] array) {
		int bucketSize = 200;
		int bucketCount = 5;
		int[][] buckets = new int[bucketCount][0];
		for(int i = 0; i < array.length; i ++) {
			int x = array[i]/bucketSize;
			buckets[x] = arrAppend(buckets[x], array[i]);
		}
		for(int i = 0; i < bucketCount; i ++) {
			//sort the elements inside each bucket
			insertion_sort(buckets[i], 0, buckets[i].length);
		}
		int count = 0;
		for(int i = 0; i < bucketCount; i ++) {
			for(int j = 0; j < buckets[i].length; j ++) {
				array[count] = buckets[i][j];
				count ++;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		 int[] array = new int[] {123, 2, 34, 678, 345, 890, 234, 789, 23, 49, 843, 56, 234};
		 //merge_sort(array, 0, array.length - 1);
		 //tim_sort(array, 4);
		 bucket_sort(array);
		 System.out.println(Arrays.toString(array));
		 //[2, 23, 34, 49, 56, 123, 234, 234, 345, 678, 789, 843, 890]
	}
	
	private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
	
	private static void insertion_sort(int[] array, int l, int r) {
		for(int i = l + 1; i < r; i ++) {
			int index = array[i]; 
            int j = i - 1; 
            while (j >= l&& array[j] > index) { 
            	array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = index; 
		}    
	}
	
	

}
