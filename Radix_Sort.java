import java.util.Arrays;

public class Radix_Sort {
	public static void main(String[] args) {
		 int[] array = new int[] {123, 2, 34, 678, 345, 890, 234, 789, 23, 49, 843, 56, 234};
		 int max = Integer.MIN_VALUE;
		 for(int a : array)  if(a > max) max = a; //find max value
		 for(int pos = 1; max/pos != 0; pos*=10) {
			 count_sort(array, pos);		 
		}
		 System.out.println(Arrays.toString(array));
		 //[2, 23, 34, 49, 56, 123, 234, 234, 345, 678, 789, 843, 890]
	}
	
	public static void count_sort(int[] array, int pos) {
		 int[] count = new int[10]; 
		 for(int i = 0; i < 10; i ++) count[i] = 0; //initialize
		 for(int a : array) count[(a/pos)%10] ++; //counting
		 for(int i = 1; i < 10; i ++) count[i] += count[i - 1]; //find last index 
		 int[] result = new int[array.length];
		 for(int i = array.length - 1; i >= 0; i --) {
			 int a = array[i];
			 result[count[(a/pos)%10] - 1] = a;
			 count[(a/pos)%10]--;
		 }
		 for (int i = 0; i < array.length; i++) array[i] = result[i]; 
		 
	}
}
