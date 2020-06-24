package pkg_2;
class X{
int val = 10;
}

class Y extends X{
Y val = null; //1
}
class DataTypeTest1{

	public static void main(String[] args){
		//do1();
		System.out.println(  	new Y().val);

		}

	static void do1(){
		long l1 = 1;
		double d1 = 10.7;
		long l2 = l1 + (int)d1;			// no round to 11
		System.out.println( l2 );

	}
}
