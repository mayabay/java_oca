package pkg_2;
class Hide1 {
	static int n = 42;
	static boolean isHungry(){return false;}
}
class Hide2 extends Hide1 {
	static int n = 43;
	static boolean isHungry(){return true;}
	void print(){
		System.out.println("n = " + n + ", is hungry = " + isHungry()  );
	}

	void selfCaller(){
		aboutMe(this);
	}

	void aboutMe(Hide2 h2){
		System.out.println("n = " + n + ", is hungry = " + isHungry()  );
	}


}
public class HideTest1{

	public static void main(String[] args){
		Hide2 h2 = new Hide2();
		//h2.print();
		h2.selfCaller();
		

	}
}
