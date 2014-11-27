package poker_game.BlackJack;

import java.util.ArrayList;

import poker_game.Hand;

public class BlackJackHand extends Hand<BlackJackCard>{
	public int valueSum(){
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for(int score:scores){
			if(score > 21 && score < minOver){
				minOver = score;
			}
			if(score <=21 && score > maxUnder){
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE? minOver:maxUnder;
	}
	public boolean busted() {return valueSum() > 21;}
	public boolean is21() {return valueSum() == 21;}
	public boolean isBlackJack(){
		if(cards.size() == 2 && valueSum() == 21){
			return true;
		}
		return false;
	}
	private ArrayList<Integer> possibleScores() {
		int numOfAces = 0;
		int minSum = 0;
		for(BlackJackCard card:cards){
			if(card.isAce()){
				numOfAces++;
			}
			minSum += card.value();
		}
		ArrayList<Integer> scores = new ArrayList<Integer>(numOfAces+1);
		/*
		 * each Ace could be used as 1 or 11
		 */
		for(int i=0;i<=numOfAces;++i){
			scores.add(minSum + i*10);
		}
		return scores;
	}
}
