package pkg_5;
import java.util.*;
class Wrap{
	Double d = 2.5D;
	int[] i = new int[1];
}
public class LearnRef {
	List<Double> doubles = new ArrayList<>();
	
	
	public static void main(String[] args){
		
		Wrap w1 = new Wrap();
		w1.d = 1.5D;

		LearnRef lr = new LearnRef();
		
		lr.doubles.add( w1.d );

		w1 = null;

		for ( Double d : lr.doubles ){
			System.out.println( d );
		}

	}



}
