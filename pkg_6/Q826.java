package pkg_6;
public class Q826 {
    public static void main(String[] args) {
        try{
            doTest();
        }
		catch(RuntimeException rte){
			//System.out.println( rte );		// java.lang.ArrayIndexOutOfBoundsException: 10
			rte.printStackTrace();
					//java.lang.ArrayIndexOutOfBoundsException: 10
        			//		at pkg_6.Q826.doTest(Q826.java:19)
        			//		at pkg_6.Q826.main(Q826.java:5)

		}
        catch(MyException826 me){
            System.out.println(me);
        }
    }
    
    static void doTest() throws MyException826{
        int[] array = new int[10];
        array[10] = 1000;
        doAnotherTest();
    }
    
    static void doAnotherTest() throws MyException826{
        throw new MyException826("Exception from doAnotherTest");
    }
}
class MyException826 extends Exception {
    public MyException826(String msg){
     super(msg);
    }
}
