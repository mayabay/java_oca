package pkg_3;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;

public class SortAndSearchArrays {

	static List<String> colors = new ArrayList<>();
	
	public static void main(String[] args) {

		do2();
	}
	
	static void do1() {
	
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		colors.add("lightblue");
		colors.add("orange");
		colors.add("darkyellow");
		colors.add("auqamarine");
	}
	
	static void do2() {
		
		List<Object> objects = new ArrayList<>();
		objects.add(new Object());
		objects.add( "Helga" );
		objects.add( Boolean.TRUE );
		objects.add( 42 );
		objects.add( 3.5F );
		// System.out.println( Collections.binarySearch(objects, new Object()) ); // DNC Object 
		// The method binarySearch(List<? extends Comparable<? super T>>, T) in the type Collections
		// is not applicable for the arguments (List<Object>, Object)	

		
		//List<Spieler> players = new ArrayList<>();	// DNC for binarySearch
		//List players = new ArrayList();				// ok for binary searcg
		List players = new ArrayList();
		//List<Spieler> players = new ArrayList<>();
		
		players.add( new Spieler("Michael", 10) );
		players.add( new Spieler() );
		
		players.add( new Spieler("Chris", 6) );
		players.add( new Spieler("Andi", 5) );
		players.add( new Spieler("Berta", 135) );
		players.add( new Spieler("Doris", 15) );
		
		
		System.out.println( players );
		
		Collections.sort( players );
		System.out.println("is sorted now ");
		System.out.println( players );
		
		
		System.out.println( Collections.binarySearch(players, new Spieler("Dietmar", 15)  ) );
		
		
		
	}
	
	
	
}
