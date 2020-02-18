package pkg_3;

public class Card {
	// 4 categories of suit
	private final 	String 	suit;
	
	// rank: 2,3,4,5,6,7,8,9,10, 11 = jack, 12 = queen, 13 = king
	private final	int 	rank;

	private final	String 	face;
	
	private final	char	suitChar;
	
	// --------------------------------------------------------

	public Card(String suit, int rank) {
		super();
		this.suit = suit;
		this.rank = rank;
		switch (rank) {
			case 11: face = "jack"; break;
			case 12: face = "queen"; break;
			case 13: face = "king"; break;
			default: face = null; break;
		}
		
		switch(suit) {
			case "spades" : suitChar = '\u2660'; break;
			case "clubs" : suitChar = '\u2663'; break;
			case "diamonds" : suitChar = '\u2666'; break;
			case "hearts" : suitChar = '\u2665'; break;
			default: suitChar = '\u2665'; break;
		}
		
		
	}
	
	// --------------------------------------------------------
	public String getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}



	@Override
	public String toString() {
		
		String rankValue = "" + rank;
		if (rank == 11) { rankValue = "jack"; }
		else if ( rank == 12 ) { rankValue = "queen"; }
		else if ( rank == 13 ) { rankValue = "king"; }
		
		return "Card [suit=" + suit + ", rank=" + rankValue + "]\n";
	}
	
	
	
}
