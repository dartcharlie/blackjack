package poker_game.BlackJack;

import poker_game.Card;

public class BlackJackCard extends Card{
	public BlackJackCard(int fv, Suit s){super(fv,s);}
	public int value(){
		//face card
		if(faceValue>=11 && faceValue<=13) 
			return 10;
		
		return faceValue;
	}
	public boolean isAce(){
		return faceValue == 1;
	}
}
