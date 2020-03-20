package pkg_4;
public class LocalVar {

	String s1 = "green";

	public static void main(String[] args){
		LocalVar lv = new LocalVar();
		lv.doStuff( 4 );
	}


	void doStuff( int n ){
		String local;
		if ( n > 3 )
			local = "bigger";
		else 
			local = "small";	
		
		// if both paths are present its ok to init local var in both paths
			
		System.out.println( local + " " + s1 );

	}
}
