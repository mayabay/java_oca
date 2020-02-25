/*
 * Player
 * v0.1
 * represents an user playing a lottery game
 * */
package lottery;

public class Player {
	
	// user id
	private static 			int		playerId = 1;
	private static 	final	int		MAX_TICKET_COUNT; // static 1st chance 	 

    static {
        MAX_TICKET_COUNT = 8;       // static 2nd chance of init
    }

	private 		final	int 	MAX_NUM;// = 12;   // instance 1st chance
	private 		String 	name;
	private 		int 	userId;

    {
        //System.out.println("MAX_NUM =" +  MAX_NUM  );       // DNC 
                                                            // 23: error: variable MAX_NUM might not have been initialized
        MAX_NUM = 12;    // instance 2nd chance
    }


	public Player( String name ) {
		this.name = name;
		this.userId = playerId++;
        //this.MAX_NUM = 12;  // instance 3rd chance
	}
	
	
}
