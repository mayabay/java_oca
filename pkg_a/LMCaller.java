package pkg_a;
import pkg_4.LearnMethods;
import java.util.Arrays;

import pkg_4.LearnMethods;

public class LMCaller extends LearnMethods {

	public static void main(String[] args) {
		LearnMethods lm = new LearnMethods();
		int[] arr1 = new int[] { 4,2,8,42,4,1 };
		
		System.out.println("arr[0] = " + arr1[0]);
		
		LMCaller lmc = new LMCaller();
		
		lmc.callMe1( arr1 );

		System.out.println("arr[0] = " + arr1[0]);
		
		System.out.println("unsorted " +  Arrays.toString(arr1) );
		
		Arrays.parallelSort(arr1);
		
		System.out.println("sorted " +  Arrays.toString(arr1) );
		
		System.out.println("arr[0] = " + arr1[0]);
		
	}
	
	private void do1() {
		
	}

}
