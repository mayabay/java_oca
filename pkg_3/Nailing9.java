package pkg_3;
public class Nailing9{



    public static void main(String[] args){
        //do9_5( args );
        do9_7();
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
        String s1 = "Rachel", s11;
        String s2 = "Ross";

        s11 = s1;
        s11 = "Rachel".trim();

        System.out.println( s1 == s11 );

        String s12 = s1.concat(s2).concat( s1.substring(0,s1.length() ) );
        p(s12);

        StringBuilder sb = new StringBuilder("1");
        sb.append("2");
        sb.append("3");
        sb.append("4");
        sb.replace(4,4,"Leeloo");
        System.out.println( sb );


    }

    static String maskAccount( String accNum ){
        String lead = "***************";
        //return lead + accNum.substring(15,20);
        return new StringBuilder(lead).append(accNum, 15, 20).toString();
    }

    static void do9_5(String[] args){
        //System.out.println( maskAccount( "34296018534982067541" ) );
        System.out.println( maskAccount( args[0] ) );

    }

    static void do9_7(){
        StringBuilder sb = new StringBuilder();
        String exam = "1Z0";
        int code = 808;
        
        //System.out.println( sb.append("Ill pass " + exam + "-" + code) );
        System.out.println(  );
        System.out.println( sb.append("Ill pass ").append( exam ).append("-").append(code) );

    }



}
