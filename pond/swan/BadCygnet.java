package pond.swan;
import pond.duck.MotherDuck;
public class BadCygnet {
	public void makeNoise() {
		MotherDuck duck = new MotherDuck();
		//duck.quack();		// DNC 6: error: quack() is not public in MotherDuck; cannot be accessed from outside package
		//System.out.println( duck.noise ); // DNC
                            // 7: error: noise is not public in MotherDuck; cannot be accessed from outside package
	}
}
