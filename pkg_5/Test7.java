package pkg_5;
class Test {
    public static   int getEqualSides(){ return 4; }

    public          int getUnEqualSides(){ return 4; }

    public static   int getSides() { return 8; }
}
public class Test7 extends Test {

    //public          int getEqualSides(){ return 2; } // DNC cannot override, overridden m() is static 

    //public static   int getUnEqualSides(){ return 2; } // DNC cannot override, overridding m() is static 

    public static   int getSides() { return 16; }

    public static void main(String[] args){
        
        System.out.println( Test7.getSides() );

        //System.out.println( ((Test)Test7).getSides() ); // DNC cannot find symbol
        Test7 t7 = new Test7();
        Test t = new Test();
        System.out.println( t.getSides() );

        System.out.println( t7.getSides() );


    }


        
}
