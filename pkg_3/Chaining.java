package pkg_3;
public class Chaining{
    
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
    
        String abc = "";
        abc += "Abcdef".concat("ghijk").replace('A','a'); 
                // method chaining -> returned new String is object, on which new method is called 
                // String w/o assignment new String is lost
        System.out.println( abc );

        abc = "";
        abc = abc + "Abcdef";
        abc = abc.concat("ghij");
        abc = abc.replace('A','a');

        abc = abc.replace("ab", "  ");
        System.out.println( abc );
        p(abc);
        abc = abc.trim().substring(2).replace( 'e', abc.charAt(5) );
        System.out.println(  );

        p(abc);
        System.out.println( abc );

    }

    static void do2(){
        String abc = "ABCDEFG".concat("hijklmno".substring(2,6));
        p(abc);
    }




}
