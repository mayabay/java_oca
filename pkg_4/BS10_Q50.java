package pkg_4;
import java.util.*;
public class BS10_Q50 {

	static int[][] game;

	public static void main(String[] args){
		Arrays.sort(args);
		int result = Arrays.binarySearch( args, args[0] );
		System.out.println( result );

	}
}
