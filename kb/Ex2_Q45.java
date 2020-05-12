package kb;
class X45 {}
class Y45 extends X45 {}
class Z45 extends X45 {}
public class Ex2_Q45 {

	public static void main(String[] args){

		X45 y45 = new Y45();
		X45 z45 = new Z45();
		Z45 z45b = (Z45)y45;
	}
}
