package pkg_2;
public class Modulo{
    
    public static void main(String[] args){
        
        printModulo( 7,2 );
    }
    
    static void printModulo( int divident, int divisor ){
        
        System.out.println( divident + " : " + divisor + " = " + (divident % divisor) );
       
    }
    
}
