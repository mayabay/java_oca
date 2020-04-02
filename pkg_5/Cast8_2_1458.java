package pkg_5;
import java.util.*;
interface CanFly58 {}
interface Driveable58 {}
abstract class Vehicle58{}
class Car58 extends Vehicle58 implements Driveable58 {}
class SUV58 extends Car58  {}

public class Cast8_2_1458 {

	public static void main(String[] args){

		ArrayList<Vehicle58> all = new ArrayList<>();
		//SUV58 s = all.get(0);				// DNC 	incompat
		//SUV58 s = (SUV58)all.get(0);		// DC	IOOBE	

		ArrayList<Driveable58> all2 = new ArrayList<>();
		//Car58 c = all2.get(0);			// DNC 	incompat	dowbhill <- interface
		//Car58 c = (Car58)all2.get(0);		// DC 	IOOBE
		//SUV58 su = (SUV58)all2.get(0);


		ArrayList<SUV58> all3 = new ArrayList<>();
		//Driveable58 d = all3.get(0);					// DC 	uphill -> interface
		//CanFly58 cf = all3.get(0);					// DNC 	incompat
		//CanFly58 cf = (CanFly58)all3.get(0);			// DC 	IOOBE

		ArrayList<SUV58> all4 = new ArrayList<>();
		//Car58 c2 = all4.get(0);						// DC uphill	

		ArrayList<Vehicle58> all5 = new ArrayList<>();
		//Driveable58 dr = all5.get(0);					// DNC	incompat
		//Driveable58 dr = (Driveable58)all5.get(0);	// DC IOOBE
		//CanFly58 cf2 = (CanFly58)all5.get(0);			// DC IOOBE

	}
}
