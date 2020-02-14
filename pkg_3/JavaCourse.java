package pkg_3;

import java.util.Arrays;

public class JavaCourse {

	public static void main(String[] args) {
		
		Object obj = new Object();
		Object[] objList = new Object[2];
		
		
		User[] users, moreUsers[]; 
		User[] evenMoreUsers[];
		
		users = new User[10];
		
		//System.out.println( Arrays.toString(users) ); 
		
		String[] names;
		names = new String[] {"Andreas", "Bert", "Chris", "David","Fritz", "Gerd","Herbert", "Ilse", "Jens", "Karl" };
		
		String[] locations = {
				"Tahiti",
				"Vanuatu",
				"Hawai",
				"Van Diemens Land",
				"New Zealand",
				"Papua",
				"Borneo",
				"Sumatra",
				"Bali",
				"Lombok"
				
		};
		
		String[] topics = {
				"numeric promotion",
				"labels",
				"encapsulation",
				"exceptions",
				"inheritance",
				"polymorphism",
				"collections",
				"javadoc",
				"unicode",
				"bitwise operators",
				"umarelsa"
		}; 
		
		for ( int i = 0; i < users.length; i++ ) {
			users[i] = new User( names[i], locations[i] );
			users[i].setTopic(topics[i]);
			
			users[i].learn();
		}

		//System.out.println( Arrays.toString(users) );
		
	}
}
