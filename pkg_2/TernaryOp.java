package pkg_2;
public class TernaryOp {

    public static void main(String[] args){
   
        String info = "";
        int zahl = 4;
        double wert = 2.5;

        info = zahl>=6 ? "biger" : "smaller";
        System.out.println( info );
        
        System.out.println(  zahl>=6 ? "biger" : "smaller");
        int i = 0;
        System.out.println(  zahl>=6 ? "biger" : (i = 4));
        System.out.println( "i = " + i );


        zahl = 6;
        zahl = zahl++  + 10 > 15 ? zahl == 20 ? 10 : 5: 0;
            //                    ---------------------  
            //                              true
            //                                          false
            //
            //                                   t : f
        System.out.println( "zahl = " + zahl );


    }
}
