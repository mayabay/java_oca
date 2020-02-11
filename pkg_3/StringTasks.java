package pkg_3;
public class StringTasks{
    
    public static void main(String[] args){
        //learnStringMethods();
        do70();
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


    static void learnStringMethods(){
        
        String s1 = "Rachel";
        String s2 = "Ross";
    
        System.out.println( "Ross".equals("Ross") );            // true

        System.out.println( s2.equalsIgnoreCase("ross") );      // true

        System.out.println( s1.length());       // 6

        System.out.println( "Rachel".contains("hel") ); // true

        System.out.println( s1.lastIndexOf("hel") );        // 3

        System.out.println( "Rachel".replace("achel", "oss") );     // Ross

        String[] sarr = "Rachel".split("c");        
        System.out.println( sarr[1]);

        String[] sarr2 = "Ross".split("s",2);
        
        System.out.println( sarr2[0] +  " " + sarr2[1]   );  // Ro s , sarr2[2] AIOOBE

        System.out.println( "Ross".toLowerCase() );

        System.out.println( "Ross".toUpperCase() );

        System.out.println( ("    Ross     ".trim()).length()  );   // 4

        System.out.println( "Ross".charAt(0) );     // R




    }

    static void do70(){
        
        String s1 = "Java training";
        String s2 = "Java";
        String s3 = s1 + "training";
        String s4 = new String(s2);
        String s5 = " Java training  ".trim();   
        System.out.println( s5.length());       // 13

        String s6 = s1;
        String s7 = "Java";

        s1 = "null";
        s2 = null;
        s3 = null;

        System.out.println( s1 == s2 );     // false
        System.out.println( s1 == s3 );     // false
        System.out.println( s1 == s5 );     // false trim() computed
        System.out.println( s1 == s6 );     // false see LOC 71
        p(s6);        
        System.out.println( s2 == s4 );     // false s4 -> new

        System.out.println( s2 == s7 );     // false LOC 72
        System.out.println( s1 == s2 );     // false String and null two objects

        System.out.println( "s1 = " + s1 );
        System.out.println( "s2 = " + s2 );

        System.out.println( s2 == s3 );     // null == null -> true


    }


}
