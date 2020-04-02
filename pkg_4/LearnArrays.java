package pkg_4;
import java.util.*;
public class LearnArrays {

	public static void main(String[] args){
		do1();
	}

	static void do1(){
		
		String[] nums = new String[] { "1","9","10" };
		Arrays.sort( nums );
		System.out.println( Arrays.toString(nums) );
		
		// ---

		String[][] matrix = new String[1][2];
		matrix [1][0] = "bla";
	}

}
