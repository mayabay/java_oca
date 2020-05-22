package hanu_4;
class ArrayTest2 {
	
	public static void main(String[] args){
		
		int idx = 2; 

		int[] iArr = new int[] {1,2,3};

		System.out.println( iArr[-(-idx)] ) ;

		System.out.println( "length = " + iArr.length );

		int[] iArr2 = (int[])iArr.clone();

		iArr[0] = 42;

		System.out.println( iArr2[0] );

		String[] strArr = new String[] {"Peter", "Steve" };

		String[] strArr2 = (String[])strArr.clone();

		System.out.println( strArr2[1] );


		Person2[] persons = new Person2[] { new Person2("Peter"), new Person2("Steve") };
		
		Person2[] persons2 = (Person2[])persons.clone();

		persons[0].name = "Tony";
		
		persons2[1] = new Child2();

		System.out.println("value of ref in cloned array = " +  persons2[1] );


	}


}
class Person2 {
	String name;
	int age;
	Person2(String name){
		this.name = name;
	}

	Person2(){}

	public String toString(){
		return name;
	}
}
class Child2 extends Person2 {	// DNC 53: error: constructor Person2 in class Person2 cannot be applied to given types;
	Child2(){
		super("Bruce");
	}
}
