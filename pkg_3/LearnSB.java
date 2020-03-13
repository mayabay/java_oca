package pkg_3;
public class LearnSB{



    public static void main(String[] args){
        do4(); 
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

	static int[] getArr(){
		//return null;
		return new int[] { 1,2,3,4 };
	}

	static void do4(){
		String str = null;
		String newStr = str + 'g';
		//String newStr2 = null + 'g';		// DNC 30: error: bad operand types for binary operator '+'
		//p(newStr2);			

		String lo = "lo";
		String hello = "hello";
		System.out.println( hello == ("hel" + lo) ); 		// false	because right hand not in string pool
		System.out.println( hello == ("hel" + "lo") ); 		// true
		String hello2 = "hel" + lo;	// not in String pool
		System.out.println( hello == ( hello2.intern() ) );	// true 	because right hand NOW in string pool 

	}

	static void do3(){
		//  0 1 2 3 4 5
		//	a n i m a l
		StringBuffer sb = new StringBuffer("animal");
		sb = sb.replace( 2,5, "bi" );
		System.out.println( sb );	// a n b i l

		int index = 0;

		//System.out.println( getArr()[index = 2]++ );
		System.out.println( ++getArr()[index = 2] );

		System.out.println( index );

	}


    static void do1(){
        StringBuilder sb = new StringBuilder();

        sb.append("ABCD");

        String str = "efg";

        sb.append(str);

        StringBuilder obj = new StringBuilder("hijk");

        // 0 1 2 3
        // h i j k      length = 4

        obj.delete(3,3);     // deletes nothing    

        //obj.delete(3,4);    // deletes k

        obj.delete(4,4);      // deletes nothing
                    // length = 4


        //obj.delete(5,5);        // SIOOBE

        //obj.delete(4,5);    // SIOOBE

        p(obj);


        StringBuilder sb2 = new StringBuilder("Rachel");
        
        p(sb2);

        sb2.append("Ross",0,4); // appends 0 -> .length() chars to sb2
   
        p(sb2);


    } 


    static void do2(){


		StringBuilder sb = new StringBuilder("Ich brauch Feierabend");
		p(sb);
		
		// charAt
		System.out.println( sb.charAt(15) );
		
		// indexOf
		System.out.println( sb.indexOf("r") );
		
        // lastIndexOf
		System.out.println( sb.lastIndexOf("e") );
	    	
		System.out.println( sb.lastIndexOf("eier", 20) );


        

        IdontKnow i = new IdontKnow();
        String a = "";

        a +=2;
        a += false;
        a += true;
        a += sb;
        a += i;
        System.out.println( "a = " + a );


    }



}

class IdontKnow {
    public String toString(){
        return "stillso";
    }
}
