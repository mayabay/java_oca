package uebungen;
class SBTest1{

	public static void main(String[] args){
		do1();
	}
	static void do1(){
		StringBuilder sb = new StringBuilder();
		sb.append("1");
		sb.append("2");
		sb.append("3");
		sb.append("4");
		sb.replace(4,4,"leloo");
		System.out.println( sb );	// 1234leloo

	}
}
