package hanu_12;
import java.util.*;
class ImmutabilityTest1{

	private List<String> list;

	ImmutabilityTest1(){
		list = new ArrayList<>();
		list.add("Peter Parker");
		list.add("Steve Rogers");
		list.add("Tony Stark");
		list.add("Bruce Banner");
	} 

	public List<String> getList(){
		//return list;
		return (List<String>)new ArrayList(list);
	}

	public void setList( List<String> list ){
		this.list = list;	
	}

	public static void main(String[] args){

		ImmutabilityTest1 it = new ImmutabilityTest1();
		List<String> li =  it.getList();
		li.remove(1);

		li.set(1, null);
		
		System.out.println( it.getList() );


	}
}
