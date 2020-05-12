package kb;
interface TestIF{
	int n = 42;
	default String m1(){ return "m1"; }
	static String m2(){ return "m2"; }
	public String m3();
}
public class Ex1_Q71 implements TestIF{
	public String m3(){ return "m3"; }

	public static void main(String[] args){
		Ex1_Q71 e = new Ex1_Q71();
		System.out.println( e.m1() );
		//System.out.println( e.m2() );		// DNC 13: error: cannot find symbol
		System.out.println( n );
		System.out.println( e.n );
		System.out.println( Ex1_Q71.n );
		System.out.println( e.m3() );


	}
}
