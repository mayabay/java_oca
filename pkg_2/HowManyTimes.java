package pkg_2;
public class HowManyTimes {
    
    public static void main(String[] args){
   
        for (int i = 0; i <10; ){
            int n = 0;   
            
            n = i++;    // assigns 0 AND increments i 
            // i = i++;    // assigns 0 but increment is thrown away  --> endless loop
            
            System.out.println( "Hello World i = " + i );
        }


        byte b = 1;
        short s = 1;
        float f = 1.0F;
        System.out.println( 0x1 == f );



    }
}
