package pkg_3;

import java.util.ArrayList;

public class WrapperPrinzip {
	
	/**
	 * ------------------------	Begrifflichkeiten --------------------------------------------------------------
	 * 
	 * wrap (boxing)		--> "einpacken" eines primitiven Datentypes in ein Objekt
	 * autoboxing 			--> automatisiert das "einpacken" ohne explizit den Konstruktor textuell aufzurufen
	 * unwrap (unboxing)	--> "auspacken" eines Objektes, das einem primitiven Datentyp entspricht 
	 * 
	 * ---------------------------------------------------------------------------------------------------------
	 * 				Alle primitiven Datentypen, haben eine Wrapper Klasse, die 2 Kontruktoren haben.
	 * 											!!!! BIS AUF CHARACTER!!!!! 
	 * Sie können sowohl den Datentyp als auch eine Zeichenkette direkt in einen primitiven Datentyp als auch einen 
	 * String in ein Wrapper Objekt umwandeln
	 * */

	public static void main(String[] args) {
//		wrapUnwrapItDetailed();
		howToCompareWrapper();
		
		
	}
	public static void wrapUnwrapItDetailed() {
		//---------------------------------------------------------------------------------------------------------------------------------------------------
		// Allgemein benutzt..
		//---------------------------------------------------------------------------------------------------------------------------------------------------
		int wert = 0; byte klein = 10;
		
		ArrayList <Integer> zahlen = new ArrayList();		// erstellen einer ArrayListe mit Integer Objekten
		
		zahlen.add(456);									// Hinzufügen eines Wertes ohne Konstruktor der Integer Klasse ..> uses autoboxing siehe unten
		zahlen.add(new Integer(623));						// Hinzufügen eines Wertes vom Datentyp int MIT Konstruktoraufruf ..> wrap
		zahlen.add(new Integer("89"));						// Hinzufügen einer Zeichenkette mit zahlen MIT Konstruktoraufruf ..> wrap
		zahlen.add(new Integer('t'));
		zahlen.add(new Integer(wert));
		zahlen.add((int)klein);
		zahlen.add(0xF);
		zahlen.add((int)2.5);
		
		System.out.println("Ausgabe zahlen Liste");
		System.out.println(zahlen);							// Ausgabe liste
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// Was wirklich passiert..
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		
		Integer zahlObjInt1 = new Integer(456);				// Erstellen eines Integer Objektes mit dem Wert 456
		
		int zahlPrimitiv = zahlObjInt1;						// unwrap Objekt in primitiven Datentyp
		
		zahlPrimitiv++;										// nutzen des primitiven Datentyp
		
		zahlObjInt1 = new Integer(zahlPrimitiv);			// wrap primitiven Datentyp in Integer Objekt
		
		System.out.println("Ausgabe Zahl Objekt 1");
		System.out.println(zahlObjInt1);					// Ausgabe Objekt
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// noch ein Beispiel mit Zahl als Zeichenkette..
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		Integer zahlObjInt2 = new Integer ("22");			// Erstellen eines Integer Objektes mit dem Wert "22"
		
		zahlObjInt2 += zahlObjInt2 + 10;						// Nutzen des Zahlen Objektes 
															//	1. unwrap in primitive  zahlObjInt auf der rechten Seite (zahlObjInt2 + 10) 
															//  2. nutzen (22 + 10) berechnen 
															//  3. rewrap in Objekt ergebnis der Berechnung (32) --> zahlObjInt = new Integer(32)
		
		System.out.println("Ausgabe Zahl Objekt 2");
		System.out.println(zahlObjInt2);					// Ausgabe
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
	}
	
	public static void howToCompareWrapper() {
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// Was passiert bei zuweisen eines Integer Objektes zu einem anderen ..
		//------------------------------------------------------------------------------------------------------------------------------------------------------
			Integer zahl1 = new Integer (15);				// Erstellen eines Integer Objektes zahl1 mit Wert 15
			Integer zahl2 = zahl1 ;							// Zuweisen der zahl1 Referenz an Integer Objekt zahl2 
			
			System.out.println(zahl1 + " " + zahl2);		// Ausgabe BEIDER Objekte
			System.out.println(zahl1 == zahl2);				// Vergleich der Objekte
			
			zahl2 = 15 % 2 ;								// Ändern des Wertes im Objekt zahl2
				
			
			System.out.println(zahl1 + " " + zahl2);		// Ausgabe BEIDER Objekte
			
			System.out.println((zahl1 == zahl2) );			// Vergleich der Objekte 
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
			// ????????????????????????????????????????????????????????????????????????????????????????
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// Was passiert oben im Detail ..
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		
			Integer zahlEins = new Integer(15);				// Wrapt den Wert 15 in ein Integer Objekt zahlEins und Erstellt es 
															// gleichzeitig
			
			Integer zahlZwei = zahlEins;					// Erstellt ein neues Integer Objekt zahlZwei  new Integer()
															// unwrapped zahlEins.Value() --> 15
															// rewrapped  new Integer(zahlEins.Value)
			
			System.out.println(zahlEins + " " + zahlZwei);	// Ausgabe der Werte
			System.out.println(zahlEins == zahlZwei); 		// unwrapped die Objekte zahlEins und zahlZwei in primitive Datentypen
															// vergleicht die Werte der primitiven Datentypen und bei Übereinstimmung 
															// wird true zurückgegeben
			
			zahlZwei = 15 % 2 ;								// 	1. Berechnen der arithmetischen Funktion 
															//  2. rewrap in Objekt ergebnis der Berechnung (1) --> 
															//   zahlZwei = new Integer(1)

			System.out.println(zahlEins + " " + zahlZwei);	// Ausgabe der Werte
			
			System.out.println((zahlEins == zahlZwei) );	// unwrapped die Objekte zahlEins und zahlZwei in primitive Datentypen
															// vergleicht die Werte der primitiven Datentypen und bei ungleich wird 
															// false zurückgegeben
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
			
	
	}

}
