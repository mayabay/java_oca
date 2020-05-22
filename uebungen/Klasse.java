public class Klasse {
	// Felder halten Zustand eines Feldes oder Objektes
	
	// Klassenvariable
	public static String name;
	
	public int teilnehmerAnzahl; 
	
	public static void main(String[] args){
		
		int tn = 15;	// local var initialiazation
		int tn2;
		tn2 = 12;
		
		System.out.println(  name );
		
		//System.out.println(  teilnehmerAnzahl );  // DNC 11: error: non-static variable teilnehmerAnzahl cannot be  referenced from a static context
		
		System.out.println(  new Klasse().teilnehmerAnzahl );
		
		
		//for(;;)
			
		
	}

}