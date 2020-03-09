package pkg_6;
import java.util.*;
class Friend implements Comparable {
    String name;
    Friend(String name){
        this.name = name; 
    }
    public String toString(){
        return name;
    } 


    public int compareTo( Object obj ){
        
        Friend f = null;
        try {
            f = (Friend)obj;
        }
        catch ( ClassCastException cce ){
            System.out.println( "this is not a friend ;-)" );
            return 0;
        }

        return this.name.compareTo( f.name );

    }

    public int hashCode(){
        return name.hashCode();
    }

    public boolean equals(Object obj){
        if (obj == null) return false;
        if ( !(obj instanceof Friend) ) return false;
        Friend f = (Friend)obj;
        return this.name.equals( f.name );
    }

}
public class VisitZoo {

    private     static  int     lionCount       = 4;
    private     static  int     penguinCount    = 0;


    private static List<Friend> friends = new ArrayList<>();

    static {
        friends.add( new Friend("joey") );
        friends.add( new Friend("chandler") );
        friends.add( new Friend("ross") );
        friends.add( new Friend("monica") );
        friends.add( new Friend("phoebe") );
        friends.add( new Friend("rachel") );
    }

    public static void main(String[] args){
        
        int cookies = getCookies( friends.size() );         
        int cookiesPerPenguin; 
        try{
            cookiesPerPenguin = cookies/penguinCount;
        }
        catch ( ArithmeticException ae) {
            System.out.println( "no penguins can be visited today!" );
        }

        visitLions( friends );

        Friend[] friendsArr = friends.toArray( new Friend[ friends.size() ] ); 
        Friend[] rr = new Friend[] { friends.get(2), friends.get(5) };

        System.out.println( Arrays.toString(rr) );

        try{
            System.out.println( rr[2] );    // RTE java.lang.ArrayIndexOutOfBoundsException
        }
        catch(  ArrayIndexOutOfBoundsException aioobe ){
            System.out.println( "only ross and rachel" );

        }

        try{
            Integer six = new Integer("six");
        }
        catch ( NumberFormatException nfe ){
            System.out.println( "six is not a number" );
        }

   
        // rr[2] = new Friend("johnboy");  // java.lang.ArrayIndexOutOfBoundsException: 2

        Friend[] nofriends = null;

        Friend nullFriend = null;

        // Magnificient five
        
        // access field of null
        //System.out.println( nullFriend.name );                // NPE
        
        // call a m() on null
        //nullFriend.toString();                                // NPE

        // acc E on null as if it is E of an array 
        // System.out.println( nofriends[4] );                  // NPE

        // acc length of arr, which is null
        // System.out.println( nofriends.length );              // NPE 

        RuntimeException noExc = null;
        // throw noExc;                                         // NPE


        Collections.sort(friends);
        System.out.println( friends );


    }

    static void visitLions( List<Friend> friends ){

        System.out.println( friends.size() + " friends visiting lions, which are " + friends );

        try{
            System.out.println( "friend " + friends.get(6) );
        }
        catch( ArrayIndexOutOfBoundsException aioobe ){
            System.out.println( "there is no seventh friend" );
        }
        catch( IndexOutOfBoundsException ioobe ){
            System.out.println( "there is no seventh friend" );
        }
    }

    static int getCookies( int friendCount ){
        return friendCount * 3;
    }

}
