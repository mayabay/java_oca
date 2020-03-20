 package uebungen; 
 class A{    
	 protected void m() throws Exception{
		System.out.println( "A" );

	 } 
 }  
 
 class B extends A{    
	 public void m(){
		System.out.println( "B" );
	 } 
 }  //in file TestClass.java 
 

public class Test1167{    
	public static void main(String[] args) throws Exception {       
		//insert code here. //1 
		A a = new B();
		a.m();
} }
