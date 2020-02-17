package pkg_3;

import java.util.Arrays;
import static java.util.Arrays.sort;

public class ArraySorting {

	private static String[] words = { "Bob", "Alfred", "1ris", "Aal", "Bibi", "Biene", "$ollar" };
	private static String[] digits = { "01", "110", "0011", "101", "1", "100", "1000" };

	private static String[] list1 = { "Ross","001","Monica", "Rachel", "00",  "1ris", "§aragraph" };
	
	public static void main(String[] args) {
		//doSort1();
		doSort2();

	}

	static void doSort2() {
		System.out.println("unsorted\n-------------------");
		System.out.println(Arrays.toString( list1 ));
		
		System.out.println("Phoebe ? => " + Arrays.binarySearch(list1, "Phoebe"));
		System.out.println("Rachel ? => " + Arrays.binarySearch(list1, "Rachel"));
		System.out.println("Joey ? => " + Arrays.binarySearch(list1, "Joey"));
		
		System.out.println();
		
		System.out.println("sorted\n-------------------");
		sort(list1);
		System.out.println(Arrays.toString( list1 ));		
		
		System.out.println("Phoebe ? => " + Arrays.binarySearch(list1, "Phoebe"));
		System.out.println("Rachel ? => " + Arrays.binarySearch(list1, "Rachel"));
		System.out.println("Joey ? => " + Arrays.binarySearch(list1, "Joey"));
		
	}
	
	static void doSort1() {
		Arrays.sort(digits);
		System.out.println( Arrays.toString(digits) );
		
		sort(words);
		System.out.println( Arrays.toString(words) );
		
		System.out.println( Arrays.binarySearch(words, "Bambi") );
		;
		
	} 
}
