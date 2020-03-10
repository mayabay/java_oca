package pkg_5;
import java.util.*;
class Friend implements Comparable<Friend> {
	String name;
	public Friend(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
	public boolean equals( Object obj ){
		if( obj == null ) {
			return false;
		}
		if ( ! (obj instanceof Friend) ){
			return false;
		}
		Friend f = (Friend)obj;
		if (this.name.equals(f.name)){
			return true;
		}
		else{
			return false;
		}
	}
	public int hashCode(){
		return name.hashCode();
	}
	public int compareTo(Friend f){
		return name.compareTo(f.name);
	}
}
public class Friends{

	static List<Friend> friends = new ArrayList<>();

	static {
		friends.add( new Friend("joey") );
		friends.add( new Friend("chandler") );
		friends.add( new Friend("ross") );
		friends.add( new Friend("rachel") );
		friends.add( new Friend("monica") );
		friends.add( new Friend("phoebe") );
		Collections.sort( friends );
	}

	static void resetFriends(){
		friends.clear();
		friends.add( new Friend("joey") );
		friends.add( new Friend("chandler") );
		friends.add( new Friend("ross") );
		friends.add( new Friend("rachel") );
		friends.add( new Friend("monica") );
		friends.add( new Friend("phoebe") );
		Collections.sort( friends );
	}

	public static void main(String[] args){
		//do1();	// Comparable
		//do2();	// List
		do3();
	}

	static void do1(){

		System.out.println( friends );
	
		Collection coll = (Collection)friends;

		// bool add(E)
		friends.add( new Friend("john") );
		// bool remove(E)

		friends.remove( new Friend("ross") );	// ross is removed only after we have overwritten equals
		System.out.println( friends );
		// void clear()
		friends.clear();
		System.out.println( friends );
		// bool isEmpty()
		System.out.println( friends.isEmpty() );
		resetFriends();
		// bool contains(E)
		System.out.println( friends.contains( new Friend("rachel") ) );
		// int size()
		System.out.println( "There are " + friends.size() + " friends." );

	}

	static void do2(){

		System.out.println( friends );

		// void add(idx, E);
		friends.add(4, new Friend("john"));
		System.out.println( friends );
		// E set(idx,E)
		System.out.println( friends.set(1,new Friend("lisa")) );
		System.out.println( friends );

		// bool remove(idx)
	    System.out.println( friends.remove( friends.size() -1 ) );
		System.out.println( friends );
		// E get(idx)
		System.out.println( friends.get(5) );

	} 

	static void do3(){

		// 	0	1	2	3	4	5
		// 	1	2	3	4	5	6

		List<Integer> il = new ArrayList<>();
		il.add(1);
		il.add( new Integer(2) );
		il.add(3);
		il.add( Integer.parseInt("4") );
		il.add(5);
		il.add(6);

		Collections.sort( il );
		System.out.println( il );

		Integer i1 = il.get( 1 );	// 2
		Integer i2 = il.get( 2 );	// 3
		Integer i3 = i1 + i2;		// 5
		System.out.println( i3 == il.get(4) );	// 5 == 5
		System.out.println( il );



	}



}
