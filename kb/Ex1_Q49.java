package kb;
import java.util.function.*;
interface Breakable{
	public void breakSmoothly();
}
class Car {
	public void accelerate(){}
}
class FancyCar extends Car {
	public void breakSmoothly(){}
}
class SuperFancyCar extends FancyCar implements Breakable{
	public void breakSmoothly(){}
	public void turn(){}
}
public class Ex1_Q49{
	
	public static void main(String[] args){
		print(new FancyCar());
	}

	private static void print(Car car){
		//((Breakable)car).breakSmoothly();				// OK CCE
		(( Predicate<Object> )car).test(new Object());			// OK CCE
	}

}
