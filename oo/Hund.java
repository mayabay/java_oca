package oo;

// no imports

public class Hund extends java.lang.Object {
                                    
   private 	String 	name; 
   private 	int 	alter;
   private 	String 	Class;
 
	// setter
	public void setAlter (int alter){  
        this.alter = alter;
    }
 
	// getter
    public int getAlter(){
        return alter;
    }   
   
	public static void main(String[] args){     // psvm	
		
		//int alter = luna.getAlter();		// DNC 23: error: cannot find symbol
		
		Hund luna = new Hund();
		
		//int alter = getAlter();		// DNC 23: error: non-static method getAlter() cannot be referenced from a static context
		
		int alter = luna.getAlter() + 17;	// instance method called on object
		
		System.out.println( "Luna ist = " + alter + " Jahre alt oder " + luna.getAlter() );

    }	

}
