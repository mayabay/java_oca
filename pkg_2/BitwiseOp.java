package pkg_2;
public class BitwiseOp{

    
    public static void main(String[] args){
        
        System.out.println( "-------------------------------" );
        System.out.println( " 1 -> 00000001 " );
        System.out.println( " 3 -> 00000011 " );


        doBitwiseAND();
        
        doBitwiseOR();

        doBitwiseEXCL_OR();
    }

    static void doBitwiseAND(){

        System.out.println( "-------------------------------" );
        byte b1 = 0b0000_0001;
        
        byte b2 = 0b0000_0011;

        System.out.println("AND " + ( b1 & b2 ) );
        s(b1 & b2, "AND", b1, b2);
        
    }


    static void doBitwiseOR(){

        System.out.println( "-------------------------------" );
        byte b1 = 0b0000_0001;
        
        byte b2 = 0b0000_0011;

        System.out.println("OR " + ( b1 | b2 ) );
        s(b1 | b2, "OR", b1, b2);
        
    }


    static void doBitwiseEXCL_OR(){

        System.out.println( "-------------------------------" );
        byte b1 = 0b0000_0001;
        
        byte b2 = 0b0000_0011;

        System.out.println("EXCL_OR " + ( b1 ^ b2 ) );
        s(b1 ^ b2, "EXCL_OR", b1, b2);
        
    }


    static void s(int r, String bitwiseOp, int a, int b){


        System.out.println( "operator: " + a + " " + bitwiseOp + " " + b );
        System.out.println( "resulting bit pattern "+ r );
        System.out.println( Integer.toBinaryString(r) );
    }
}
