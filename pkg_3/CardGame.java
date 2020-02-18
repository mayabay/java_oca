package pkg_3;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

	private List<Card> cards;
	
	private List<Card> clubs;
	private List<Card> diamonds;
	private List<Card> hearts;
	private List<Card> spades;
	
	public CardGame() {
		
		cards = new ArrayList(48);
		
		clubs 		= new ArrayList(12);
		diamonds 	= new ArrayList(12);
		hearts 		= new ArrayList(12);
		spades 		= new ArrayList(12);
		
		initCardsByCategory( clubs, "clubs" );
		initCardsByCategory( clubs, "diamonds" );
		initCardsByCategory( clubs, "hearts" );
		initCardsByCategory( clubs, "spades" );
		
		// add cards to game
		for( Card c : clubs ) {
			this.cards.add(c);
		}		
		for( Card c : diamonds ) {
			this.cards.add(c);
		}	
		for( Card c : hearts ) {
			this.cards.add(c);
		}	
		for( Card c : spades ) {
			this.cards.add(c);
		}			
		
	}
	
	private void initCardsByCategory( List<Card> cards, String category ) {
		
		// make the cards for this category
		
		for ( int i = 2; i <= 13; i++ ) {
			Card card = new Card( category, i ); 
					
			cards.add( card );	
		}

		
	}
	
	public String showCardsInGame() {
		
		StringBuilder sb = new StringBuilder();
		for( Card c : cards ) {
			sb.append(c);
		}
		return sb.toString();
	}

	public void printCards() {
		
		for( int i = 0; i < cards.size(); i++ ) {
			Card card = cards.get(i);
			
			System.out.println("[ "+ (i+1) +" ] " +  card);
						
		}
		
	}
	
	public void shuffleCards() {
		Collections.shuffle(cards);
	}
	
	
	
	public static void main (String[] args) {
		
		CardGame cardGame = new CardGame();
		//System.out.println( cardGame.showCardsInGame() );
		
		cardGame.shuffleCards();
		//System.out.println( cardGame.showCardsInGame() );
		cardGame.printCards();
	}
	
}
