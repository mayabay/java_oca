package enthu;
import java.util.*;
class Q1465 {

	public static void main(String[] args){
		do2();
	}

	static void do2(){
		while(true);
		//System.out.println( "A" );		// DNC unreachable

	}

	static void do1(){

        List s1 = new ArrayList( );
        try{
            while(true){
                s1.add("sdfa");
            }
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        System.out.println(s1.size());		// OK because while is inside tc
	}

}


