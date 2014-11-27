package poker_game;

import java.util.ArrayList;

public class Hand <T extends Card> {
	protected ArrayList<T> cards = new ArrayList<T>();
	/*
	 * simply added up all cards in the hand
	 */
	public int valueSum(){
		int score = 0;
		for(T card:cards){
			score += card.value();
		}
		return score;
	}
	
	public void addCard(T card) {
		cards.add(card);
	}
	
	public void print(){
		for(T card:cards){
			System.out.print(card.suit);
			System.out.print(card.value());
			System.out.print(' ');
		}
		System.out.println();
	}
}
