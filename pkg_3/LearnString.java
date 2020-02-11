package pkg_3;
public class LearnString{


    public static void main(String[] args){
   
        do2();

    }


	static void p(CharSequence c){
		for ( int i = 0; i < c.length(); i++ ){
			System.out.print( "[ " + i  + ( i>9 ? " ] ": " ] ")  );
		}
		System.out.println(  );

		for ( int i = 0; i < c.length(); i++ ){
			System.out.print( "[ "+ c.charAt(i) +"" + ( i>9 ? "  ] ": " ] " ) );
		}
		System.out.println(  );
	}	

    static void do1(){
        String str1 = "fluffy";
        String str2 = new String(str1);
        
        System.out.println( str1 == "fluffy" );     // true 1 obj in string constatnt pool
        System.out.println( str1 == str2 );         // false 2 obj, new never goes to pool:q


        String learning = "I am learning";
        learning += " Java OCA.";


        System.out.println( learning );

        p(learning);





    }

    static void d(String s){
        System.out.println( s );

    }

    static String addStr(String str){
        return str + str;
    }

    static void do2(){
    
        String s1 = "Rachel";
        String s2 = "Ross", s3 = "Monica", s4 = "Chandler", s5 = "Joey", s6 = "Phoebe";

        System.out.println( s1.endsWith("hel"));        // true
        System.out.println( s3.startsWith("Mon") );     // true

        System.out.println( s1.charAt(1) );             // a

        //System.out.println( s1.charAt(1) );             // SIOOBE
        
        System.out.println( s1.indexOf("hel") );        // 3

        String friends = s1 + s2;
        p(friends);

        System.out.println( friends.substring(6,friends.length()) );
    
        System.out.println( friends.substring(6,10) );  // 10 OK,  11->SIOOE

        String nu1l = null;
        // p(nu1l);     // NPE at LOC 13

        System.out.println( nu1l + 1 );

        System.out.println( null == null );

        String ss;      // local var declaration 
        // d(ss);          // DNC 80: error: variable ss might not have been initialized
        //System.out.println( ss + "s" );       // DNC 75: error: variable ss might not have been initialized
        
        System.out.println( addStr(s1) );
        System.out.println( s1.contains(s1) );

        int i1 = 3 & 4;

    } 
}
