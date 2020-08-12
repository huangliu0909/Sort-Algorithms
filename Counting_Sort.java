import java.util.Arrays;
public class Counting_Sort {
	public static void main(String[] args) {
		 int[] array = new int[] {1, 0, 1, 2, 3, 6, 3, 2, 9, 8, 7, 1, 5, 2, 3};
		 int max = Integer.MIN_VALUE;
		 int min = Integer.MAX_VALUE;
		 for(int a : array)  if(a > max) max = a; //find max value
		 for(int a : array)  if(a < min) min = a; //find min value
		 int size = max - min + 1; //the num of distinct values
		 int[] count = new int[size]; 
		 for(int i = 0; i < size; i ++) count[i] = 0; //initialize
		 for(int a : array) count[a - min] ++; //counting
		 for(int i = 1; i < size; i ++) count[i] += count[i - 1]; //find last index 
		 int[] result = new int[array.length];
		 for(int i = array.length - 1; i >= 0; i --) {
			 int a = array[i];
			 result[count[a] - 1] = a;
			 count[a]--;
		 }
		 System.out.println(Arrays.toString(result));
		 //[0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 5, 6, 7, 8, 9]
	  }
}
