package pkg_3;
import java.util.List;
import java.util.ArrayList;
public class Wrappers{



    public static void main(String[] args){
        do2();
    }

    static void do2(){
    
        List l1 = new ArrayList();
        List l2 = new ArrayList();
        l2.add(2);              // DC 16: warning: [unchecked] unchecked call to add(E) as a member of the raw type List
        l2.add(null);           // DC 17: warning: [unchecked] unchecked call to add(E) as a member of the raw type List
        l2.add( new Object() ); // DC 18: warning: [unchecked] unchecked call to add(E) as a member of the raw type List
        List l3 = new ArrayList(4);         //  initial capacity 


        List<String> l4 =  new ArrayList<>();
        ArrayList<String> l5 = new ArrayList();     // DC 23: warning: [unchecked] unchecked conversion
        l5.add(new String("String"));


        ArrayList l6 = new ArrayList<String>();
        l6.add("String");



        ArrayList<? super String> l7 = new ArrayList<>();
        l7.add( "Rachel" );
        l7.add( "Joey" );
        l7.add( "Monica" );
        
        removeFromAL( l7, 1 );


        ArrayList<?> l8 = new ArrayList<>();
        //l8.add( "Rachel" );     // DNC 41: error: no suitable method found for add(String)
        //l8.add( "Joey" );       // same
        //l8.add( "Monica" );     // same

        removeFromAL( l8, 1 );


    }

    static void removeFromAL( ArrayList al, int idx ){
        al.remove( idx );
    }

    static void checkAL (ArrayList al){
        System.out.println( "ArrayList has size " + al.size() );
    }

    static void do1(){

        Boolean bol1 = false;                   // autoboxing
        Boolean bol2 = new Boolean( true );     // ctor
        Boolean bol3 = new Boolean("true");     // ctor
        boolean bol4 = Boolean.valueOf(false);  // valueOf
        
        Boolean bol5 = new Boolean( ":-)" );
        //System.out.println( bol4 );


        Byte b1 = (byte)73;
        Byte b2 = new Byte((byte)3);
        Byte b3 = new Byte( "3" );
        Byte b4 = Byte.valueOf( (byte)3 );

        Short sh1 = 4;
        Short sh2 = new Short( (short)4 );      // DNC w/o cast 
        Short sh3 = new Short("4");
        Short sh4 = Short.valueOf( (short)45 );

        Character c1 = '\u007F';
        Character c2 = 127;
        System.out.println( c1 == c2 );     // true because in byte range


        Character c11 = '\u0080';
        Character c21 = 128;
        System.out.println( c11 == c21 );   // false (not in byte range anymore)


        Integer i1 = 3;
        Integer i2 = new Integer(3);
        Integer i3 = new Integer("3");
        Integer i4 = Integer.valueOf( 42 );    

        //Long l1 = 42;             // DNC 63: error: incompatible types: int cannot be converted to Long
        Long l2 = new Long( 42 );
        Long l3 = new Long( "42" );
        Long l4 = Long.valueOf(42);



        Double d1 = .3;
        Double d2 = new Double( .3F );
        Double d3 = new Double("42");

        
        Double dd1 = new Double( 3.5F );         // Why does this work?
        //Double d2 = 3.5F;  // DNC 36: error: incompatible types: float cannot be converted to Double

    }
}
