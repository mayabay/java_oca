package oo;

// no imports

public class Person extends java.lang.Object {
                                    
                                        // extends wird automatisch immer eingefügt,
                                        // if no other class is specified
   private String name = "Otto"; 
   
   private static String nachName = "Schmitz";		// class field
   
   public void setAlter (int alter){    // Instanzmethode
        this.alter = alter;
    }

    private int alter = 5;              // Instanzfeld


	public static void main(String[] args){     // psvm	
	   
        Person person = new Person();    

        System.out.println( "name = " + person.name  );
		person.name = "Herbert";
		person.nachName = "Mueller";
		
		Person person2 = new Person();
		
		System.out.println("person, name = " + person.name );
		System.out.println("person2, name = " + person2.name );
		System.out.println("Person nachName = " + Person.nachName );
		person2 = null;
		System.out.println("nachName = " + nachName );
    }	

    public int getAlter(){                      // instance getter
        return alter;
    }

}
