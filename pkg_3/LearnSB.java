package pkg_3;
public class LearnSB{



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
