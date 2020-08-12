import java.util.Arrays;

public class Sort_1 {
	
	public static void bubble_sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) 
            for (int j = 0; j < array.length - i - 1; j++) 
                if (array[j] > array[j+1]) swap(array, j, j + 1);
                
	}

	public static void selection_sort(int[] array) {
		for(int i = 0; i < array.length; i ++) {
			int min = array[i];
			int index = i;
			for(int j = i; j < array.length; j ++) {
				if(array[j] < min) {
					min = array[j];
					index = j;
				}
			}
			if(i != index) swap(array, i, index);
		}
	}
	
	public static void insertion_sort(int[] array) {
		for(int i = 1; i < array.length; i ++) {
			int index = array[i]; 
            int j = i - 1; 
            while (j >= 0 && array[j] > index) { 
            	array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = index; 
		}    
	}
	
	public static void cocktail_shaker_sort(int[] array) {
		boolean swapped = true; 
		int i = 0;
		while(swapped == true) {
			swapped = false;
			for (int j = i; j < array.length - i - 1; j++) 
                if (array[j] > array[j+1]) {
                	 swap(array, j, j + 1);
                	 swapped = true;
                }
			if(swapped == false) return;
			swapped = false;
			for(int j = array.length - i - 2; j >= i; j --) {
				if (array[j] > array[j+1]) {
               	 swap(array, j, j + 1);
               	 swapped = true;
               }
			}
			i ++;
		}
	}
	
	public static void shell_sort(int[] array) {
		int gap = array.length/2;
		while(gap != 0) {
			for(int i = 0; i < gap; i ++) {
				for(int j = i + gap; j < array.length; j += gap) {
					int index = array[j]; 
		            int k = j - gap; 
		            while (k >= i && array[k] > index) { 
		            	array[k + gap] = array[k]; 
		                k = k - gap; 
		            } 
		            array[k + gap] = index; 
				}
			}
			gap /= 2;
		}
	}
	
	public static void main(String[] args) {
		 int[] array = new int[] {123, 2, 34, 678, 345, 890, 234, 789, 23, 49, 843, 56, 234};
		 //bubble_sort(array);
		 //selection_sort(array);
		 //insertion_sort(array);
		 //cocktail_shaker_sort(array);
		 shell_sort(array);
		 System.out.println(Arrays.toString(array));
		 //[2, 23, 34, 49, 56, 123, 234, 234, 345, 678, 789, 843, 890]
	}
	
	public static void swap(int[] array, int i, int j) {
		int flag = array[i];
		array[i] = array[j];
		array[j] = flag;
	}
}


