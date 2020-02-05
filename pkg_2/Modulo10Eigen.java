package pkg_2;
public class Modulo10Eigen {
    
    public static void main(String[] args){
        int a = 1_023_453;
        int b = a / 10;
        System.out.println( "b = " + b );


        int remainder = a - (b * 10);
        
        System.out.println( a + " % 10 = " + remainder );

    }




}
