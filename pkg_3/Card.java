package pkg_3;

public class Card implements Comparable {
	// 4 categories of suit + joker
	private final 	String 	suit;
	
	// rank: 2,3,4,5,6,7,8,9,10, 11 = jack, 12 = queen, 13 = king, 14 = ace
	private final	int 	rank;		// 2,3,4,5,6,7,8,9,10,11,12,13,14	
	private 		int 	rankTotal;	// diamonds +10 hearts +20 spades +30 clubs +40
	private final	String 	face;		// jack, queen, king, ace
	
	private final	char	suitChar;
	
	// --------------------------------------------------------

	public Card(String suit, int rank) {
		super();
		this.suit = suit;
		this.rank = rank;
		this.rankTotal = 0;
		switch (rank) {
			case 11: face = "jack"; break;
			case 12: face = "queen"; break;
			case 13: face = "king"; break;
			case 14: face = "ace"; break;
			default: face = null; break;
		}
		
		switch(suit) {
			case "spades" : 	rankTotal = rank + 30;  suitChar = '\u2660'; break;
			case "clubs" : 		rankTotal = rank + 40; 	suitChar = '\u2663'; break;
			case "diamonds" : 	rankTotal = rank + 10; 	suitChar = '\u2666'; break;
			case "hearts" : 	rankTotal = rank + 20;	suitChar = '\u2665'; break;
			case "joker" : 		rankTotal = rank + 50;	suitChar = '\u0000'; break;
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

	public int getRankTotal() {
		return rankTotal;
	}

	@Override
	public String toString() {
		
		String rankValue = "" + rank;
		if (rank == 11) { rankValue = "jack"; }
		else if ( rank == 12 ) { rankValue = "queen"; }
		else if ( rank == 13 ) { rankValue = "king"; }
		else if ( rank == 14 ) { rankValue = "ace"; }
		else if ( rank == 15 ) { rankValue = "joker"; }
		
		return "Card [suit=" + suit + ", rank=" + rankValue + "]\n";
	}
	
	
	@Override
	public boolean equals(Object o) {
		if ( o == null) { return false; }
		if ( ! ( o instanceof Card )  ) { return false; }
		Card c = (Card)o;
		if ( this.suit == c.getSuit() && this.rank == c.getRank()  ) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return ( this.suit.hashCode() + (7 * rank) );
	}
	
	@Override
	public int compareTo(Object o) {
		if ( o == null || (! (o instanceof Card)) ) 
			return -1;
		
		if ( this.equals(o) )
			return 0;
		
		Card card = (Card)o;
		
		if ( this.rankTotal < card.getRankTotal() ) { 
			return -1;			// i am less
		}
		else { 
			return 1; 			// i am greater
		}
		
	}
	
}
