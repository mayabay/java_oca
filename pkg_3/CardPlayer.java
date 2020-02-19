package pkg_3;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CardPlayer {

	private String name;
	
	private List<Card> hand;

	public CardPlayer(String name) {
		super();
		this.name = name;
	}
	
	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public void addCard( Card card ) {
		this.hand.add(card);
	}
	
	public void removeCard( Card card ){
		this.hand.remove(card);
	}
	
	public String toString() {
		return name;
	}
	
}
