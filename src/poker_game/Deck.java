package poker_game;

import java.util.ArrayList;

import java.util.Random;
public abstract class Deck <T extends Card>{
	protected ArrayList<T> cards;
	protected int dealtIndex=0;
	
	private static Random _rnd;
    public static Random getRandom() {
        if(_rnd == null)
        	_rnd = new Random();
    	return _rnd;
    }
	
	
	public void addDeckOfCards(ArrayList<T> deckOfCards){
		cards.addAll(deckOfCards);
	}
	
	public void setDeckOfCards(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}
	/*
	 * get random instance from Game
	 * use Fisher–Yates shuffle
	 */
	public void shuffle(){
		getRandom().setSeed(GameUtil.convertDateToLong());
		int deckSize = cards.size();
		for(int i=0;i<deckSize;++i){
			int j = getRandom().nextInt(i+1);
			T swap = cards.get(j);
			cards.set(j, cards.get(i));
			cards.set(i, swap);
		}
	}
	
	
	public int remainingCards(){
		return cards.size() - dealtIndex;
	}
	public T dealCard(){
		if(remainingCards() <= 0){
			System.out.println("no card available!");
		}
		return cards.get(dealtIndex++);
	}
	
	protected abstract ArrayList<T> brandNewDeck();
	
	protected abstract ArrayList<T> brandNewDeckWithJoker();
}
