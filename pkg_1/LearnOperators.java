package pkg_1;
class LearnOperators {

    
	public static void main(String[] str){	
	
        new LearnOperators().go1();

    }	

    void go1(){
        
        int x = 3;
        int y = ++x * 5 / x-- + --x;

        System.out.println( "x = " + x  );

        System.out.println( "y = " + y  );
    }


}
