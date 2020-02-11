//package oca_api_string;
package pkg_3;

import java.util.Scanner;

public class PasswortRobert {
	public static void main(String[] args) {
		
		String passwort;
		boolean pass_korekt = true;
		String zeichenkette;
		Scanner scanner = new Scanner(System.in);
		
		do {
			
			System.out.println("Geben Sie Ihren Passwort ein: ");
		
			passwort = scanner.nextLine();
		

            int hasDoubleChar = 0;

			if (passwort.length() >= 8) {
				for (int i = 0; i < passwort.length(); i++) {
					for (int j = 0; j < passwort.length(); j++) {
                        if ( i == j ) continue;
						if (passwort.charAt(j) == passwort.charAt(i)) {
                            hasDoubleChar++;
							System.out.println("Ihren Passwort kann nicht gleiche Zeichen haben.");
							break;
						}
							
					}
				}
				
                if (hasDoubleChar > 0) { 
                    System.out.println( "double char!" );
                    pass_korekt = false;
                }

				int num_sum = 0;
				for (int i = 0; i < passwort.length(); i++) {
					if (passwort.charAt(i) <= '9' && passwort.charAt(i) >= '0') {
						num_sum++;
					}
				}
				if (num_sum > 0) {
					
				}
				else {
					System.out.println("Ihren Passwort soll mindestens ein numerisches Zeichen haben.");
				}
				
				int zeich_sum = 0;
				for (int i = 0; i < passwort.length(); i++) {
					if (passwort.charAt(i) <= 'Z' && passwort.charAt(i) >= 'A') {
						zeich_sum++;
					}
				}
				if (zeich_sum > 0) {
					
				}
				else {
					System.out.println("Ihren Passwort soll mindestens eine grosse Buchstabe haben.");
				}
				
				int zeichKlein_sum = 0;
				for (int i = 0; i < passwort.length(); i++) {
					if (passwort.charAt(i) <= 'z' && passwort.charAt(i) >= 'a') {
						zeichKlein_sum++;
					}
				}
				if (zeichKlein_sum > 0) {
					
				}
				else {
					System.out.println("Ihren Passwort soll mindestens eine kleine Buchstabe haben.");
				}
				
				int zeichSondern_sum = 0;
				for (int i = 0; i < passwort.length(); i++) {
					if (passwort.charAt(i) == '!' || passwort.charAt(i) == '"' || passwort.charAt(i) == '$' || passwort.charAt(i) == '&') {
						zeichSondern_sum++;
					}
				}
				if (zeichSondern_sum > 0) {
					pass_korekt = false;
				}
				else {
					System.out.println("Ihren Passwort soll mindestens eine sondern Zeichen haben.");
				}
			}
			else
			{
				System.out.println("Dein Passwort sollte 8 Zeichen haben.");
			}
		}while(pass_korekt);
		
		System.out.println("Ihren passwort: " + passwort);
		
		System.out.println("Geben Sie 3 Zeichen, wie zB. R@S: ");
		zeichenkette = scanner.nextLine();
		
		System.out.println("Ihren neuen Passwort ist: " + passwort + zeichenkette);
	}
}
