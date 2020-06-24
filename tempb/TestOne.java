package tempb;
import tempa.One;
class TestOne extends One {

	public static void main(String[] args){
		//One o1 = new One();	// DNC 6: error: constructor One in class One cannot be applied to given types;
			// required int
		
		//One o2 = new One(2);	// DNC 8: error: One(int) has protected access in One
		
		//One o3 = new One();	// DNC 11: error: One() has protected access in One

		TestOne to1 = new TestOne();

	}
}
