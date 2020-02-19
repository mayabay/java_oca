/* 0 1 2 3 4 5 6 7 8  11   12    13   14
 * 2 3 4 5 6 7 8 9 10 jack queen king ace
 * 
 * */
package pkg_3;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

	private List<Card> cards;			// all cards
	
	private List<Card> clubs;			// (1)
	private List<Card> diamonds;
	private List<Card> hearts;
	private List<Card> spades;
	
	private List<Card> clubs2;			// (2)
	private List<Card> diamonds2;
	private List<Card> hearts2;
	private List<Card> spades2;	
	
	private CardPlayer player1;
	private CardPlayer player2;
	
	private List<Card> cardsHidden;		// hidden cards
	private List<Card> cardsPlayed;		// played cards
	
	private final int cardsInitialCount;
	
	// ----------------------------------------
	
	public CardGame( String namePlayer1, String namePlayer2 ) {
		
		cards = new ArrayList(55);
		
		// (1)
		clubs 		= new ArrayList(13);	// 13, 26
		diamonds 	= new ArrayList(13);
		hearts 		= new ArrayList(13);
		spades 		= new ArrayList(13);
		
		// (2)
		clubs2 		= new ArrayList(13);	// 13, 26
		diamonds2 	= new ArrayList(13);
		hearts2		= new ArrayList(13);
		spades2		= new ArrayList(13);		
		
		// add 52 cards
		initCards( this );	
		// add 52 cards
		//initCards( this );
		// add 3 joker each
		for ( int i = 0; i < 3; i++ ) {
			this.cards.add( new Card( "joker", 15 ) );
		}
		
		cardsInitialCount = this.cards.size();
		
		this.player1 = new CardPlayer( namePlayer1 );
		this.player2 = new CardPlayer( namePlayer2 );
		
		this.cardsHidden = new ArrayList<>();
		this.cardsPlayed = new ArrayList<>();
	}
	
	static void initCards( CardGame cardGame ){ 
		
		cardGame.initCardsByCategory( cardGame.clubs, "clubs" );
		cardGame.initCardsByCategory( cardGame.diamonds, "diamonds" );
		cardGame.initCardsByCategory( cardGame.hearts, "hearts" );
		cardGame.initCardsByCategory( cardGame.spades, "spades" );
		
		// add cards to game
		for( Card c : cardGame.clubs ) {
			cardGame.cards.add(c);
		}		
		for( Card c : cardGame.diamonds ) {
			cardGame.cards.add(c);
		}	
		for( Card c : cardGame.hearts ) {
			cardGame.cards.add(c);
		}	
		for( Card c : cardGame.spades ) {
			cardGame.cards.add(c);
		}		
	}
	
	private void initCardsByCategory( List<Card> cards, String category ) {
		
		// make the cards for this category
		
		for ( int i = 2; i <= 14; i++ ) {
			Card card = new Card( category, i ); 
					
			cards.add( card );	
		}

		
	}
	
	// --------------------
	
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
		
		System.out.println("preparing game ...");
		
		// (1) build game with players and cards
		CardGame cardGame = new CardGame( "Stan Laurel","Oliver Hardy" );
		//System.out.println( cardGame.showCardsInGame() );
		
		// (2) shuffle
		cardGame.shuffleCards();
		//System.out.println( cardGame.showCardsInGame() );
		//cardGame.printCards();
		
		// (3) give cards
		cardGame.giveCards();

		// (4) show cards
		System.out.println( " ######################################## on table :" );
		System.out.println( cardGame.cards );
		
		// players cards
		System.out.println(" ######################################## cards player 1 :");
		Collections.sort(cardGame.player1.getHand());
		for( Card card : cardGame.player1.getHand() ) {
			System.out.println( card );
		}
		
		System.out.println(" ######################################## cards player 2 :");
		Collections.sort(cardGame.player2.getHand());
		for( Card card : cardGame.player2.getHand() ) {
			System.out.println( card );
		}		
		
		// remaining cards become hidden
		for ( int i = 0; i < cardGame.cards.size() - 2; i++ ) {
			Card card = cardGame.cards.get(i);
			cardGame.cardsHidden.add(card);
			cardGame.cards.remove(i);
		}
		
		// (5) open one hidden card
		int idxFirst = 0;
		Card cardFirst = cardGame.cards.get( idxFirst);
		cardGame.cardsPlayed.add(cardFirst);
		cardGame.cards.remove( idxFirst );
		System.out.println(" ######################################## open card :");
		System.out.println( cardGame.cardsPlayed.get(idxFirst) );
		
		// 
		System.out.println( "(cards = "+ cardGame.cards.size() +") total cards = " + cardGame.countTotalCards() + " / " + cardGame.cardsInitialCount );
	}
	
	private int countTotalCards() {
		int count = 0;
		count += this.player1.getHand().size();
		count += this.player2.getHand().size();
		count += this.cardsHidden.size();
		count += this.cardsPlayed.size();
		count += this.cards.size();
		return count;
	}
	
	private void giveCardsToPLayer( List<Card> hand, int idxFrom, int count ) {
		for ( int i = idxFrom; i < (idxFrom + count); i++ ) {
			Card card = this.cards.get( i );
			hand.add( card );
			this.cards.remove( i );
		}			
	}
	
	void giveCards() {

		System.out.println("giving cards ...");
		
		// (3) give cards 
		List<Card> cardsP1 = new ArrayList(10);
		List<Card> cardsP2 = new ArrayList(10);

		int idxToCards = 0;
		
		// 3 3 1
		giveCardsToPLayer( cardsP1, idxToCards, 3 );		// p1 -> 3
		giveCardsToPLayer( cardsP2, (idxToCards += 3), 3 );	// p2 -> 3
		giveCardsToPLayer( cardsP1, (idxToCards += 3), 3 );	// p1 -> 3
		giveCardsToPLayer( cardsP2, (idxToCards += 3), 3 );	// p2 -> 3
		giveCardsToPLayer( cardsP1, (idxToCards += 3), 3 );	// p1 -> 3
		giveCardsToPLayer( cardsP2, (idxToCards += 3), 3 );	// p2 -> 3
		
		giveCardsToPLayer( cardsP1, (idxToCards += 1), 1 );	// p1 -> 1
		giveCardsToPLayer( cardsP2, (idxToCards += 1), 1 );	// p2 -> 1
		
		System.out.println( "\t player 1 has " + cardsP1.size() );
		System.out.println( "\t player 2 has " + cardsP2.size() );
		System.out.println( "\t on table are hidden cards =  " + this.cards.size());
		
		this.player1.setHand(cardsP1);
		this.player2.setHand(cardsP2);
	}
	
}
