/*
 * 		0	1	2	3	4	5	6
 * 		a	n	i	m	a	l	s
 *
 * */
package pkg_5;
public class LearnCoreApi {

	public static void main(String[] args){
		do1();	// String
		//do2();		// SB
	}


	static void do1(){

		String str1 = "animals";
		String str11 = "animals";
		String str12 = "ANIMALS";
		
		String str2 = new String ("animals");
		String str3 = new String ("animals");

		System.out.println( str1 == str2 );		// false

		String str4 = new String(" animals ");
		String str5 = new String(" animals ");

		//String witch = 'b';	// DNC char cannot be converted to String
		//String tail = "lack";
		//witch = witch.concat(tail);
		//System.out.println( witch );


		System.out.println( str1 == str11.trim() );		// true
	
		System.out.println( str1.concat(" and plants") );
		
		System.out.println( str11.equalsIgnoreCase(str12) );	// true

		System.out.println( str1.substring( 3,4 ) );	// m

		System.out.println( str1.substring( 3,3 ) );	// nothing

		//System.out.println( str1.substring( 3,2 ) );	// RTE SIOOBE 
												//java.lang.StringIndexOutOfBoundsException: String index out of range: -1

		//System.out.println( str1.substring( 3,300 ) );	// RTE SIOOBE
												// java.lang.StringIndexOutOfBoundsException: String index out of range: 300

		System.out.println( str1.substring(3) );	// mals

		System.out.println( str1.substring(3, str1.length()) );	// mals

		System.out.println( str1.lastIndexOf('a') );	// 4

		System.out.println( str1.indexOf('a') );		// 0

		System.out.println( str1.charAt(5) );			// l

		System.out.println( str1.endsWith("als") );		// true

		System.out.println( str1.replace('a','o') );	// onimols

		System.out.println( str1.replace("mals", "mateur") );	// animateur

	}

	/*
	 *	0	1	2	3	4	5	6
	 *	a	n	i	m	a	l	s
	 *
	 * */

	static void do2(){
		
		StringBuilder sb1 = new StringBuilder("animals");

		StringBuilder sb2 = new StringBuilder("animals");
		
		System.out.println( sb1.equals(sb2) );

		//sb2.replace( 8,9,"mateur" );	// RTE StringIndexOutOfBoundsException: start > length()

		//sb2.replace( 7,900,"mateur" );	// OK animalsmateur	
		
		//sb2.replace( 2,5,"oma" );			// anomals

		System.out.println( sb2.charAt(2) );	// i
		
		//sb2.reverse();							// slamina
		sb2.append("sissi");
		sb2.delete(3,7);							// anisissi
		System.out.println( sb2.length() );			// 8

		sb2 = new StringBuilder( "animals" );
		
		//sb2.append(4,"ina");		// DNC m() does not exist
		//sb2.insert( 4, "ina" );		// animinaals
		//sb2.insert( 3, "ina" );		// aniinamals
		
		sb2.append("toeat",2,5);		// animalseat

		System.out.println( sb2 );

	



	}


}
