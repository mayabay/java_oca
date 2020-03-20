package pkg_5;
class AA1 {
	static String ID = "1234";
}
class BB1 extends AA1 {

	static String MyID = "foo";

	static {
		System.out.println( "static in BB1" );
	}
}
public class ClassNotInit {
	
	public static void main(String[] args){
		//System.out.println( BB1.MyID );	// class will be initialized if this field is accessed

		System.out.println( BB1.ID );
	}
}
