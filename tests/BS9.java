package tests;
import java.util.*;
import java.time.*;
public class BS9 {

	public static void main(String[] args){
		do32();
	}

	static void do25(){
		List balloons = new ArrayList<>();		// OK ???

		List<?> balloons2 = new ArrayList();	// OK

		//List<> balloons2 = new ArrayList();	// DNC illegal start of type

	}


	static void do32(){
		LocalDate xmas = LocalDate.of( 2016, 12, 25 );
		System.out.println( xmas.plusDays(-1) );	// OK
 

	}


}
