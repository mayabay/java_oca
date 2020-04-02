package pkg_5;
public class TestCasting1 {

	public static void main(String[] args){
		TestCasting1 tc1 = new TestCasting1();
		//tc1.doStuff();
		tc1.round();
	}

	void doStuff(){
		A a = new A();
		B b = new B();

		a =  (B)(I1)b;	// 

	}

	void round(){
		double d = 1.5D;
		int i = (int)d;
		System.out.println( i );

	}
}
