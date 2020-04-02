package pkg_5;
class B_1250 {}
class B1_1250 extends B_1250 {}
class B2_1250 extends B_1250 {}
public class Cast8_2_1250 {

	public static void main(String[] args){
		B_1250 	b 	= new B_1250();
		B1_1250	b1 	= new B1_1250();
		B2_1250	b2 	= new B2_1250();

		//b = b1;
		//b1 = (B1_1250) b;
		//b1 = (B1_1250) b2;
		b1 = (B_1250) b1;
	}
}
