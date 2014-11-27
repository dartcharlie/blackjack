package poker_game.BlackJack;

import java.util.ArrayList;

import poker_game.Card.Suit;
import poker_game.Deck;

public class BlackJackDeck extends Deck<BlackJackCard>{
	public BlackJackDeck(int standardDeckNum){
		cards = new ArrayList<BlackJackCard>();
		for(int i=0;i<standardDeckNum;++i){
			addDeckOfCards(brandNewDeck());
		}
	}
	@Override
	protected ArrayList<BlackJackCard> brandNewDeck() {
		ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();
		for(int i=1;i<=13;++i){
			for(int j=0;j<=3;++j){
				cards.add(new BlackJackCard(i,Suit.getSuitFromValue(j)));
			}
		}
		return cards;
	}

	@Override
	protected ArrayList<BlackJackCard> brandNewDeckWithJoker() {
		// TODO Auto-generated method stub
		return null;
	}

	public void shuffleAndReset(){
		this.shuffle();
		this.dealtIndex = 0;
	}
}
