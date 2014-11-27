package poker_game.BlackJack;

public class BlackJackPlayer {
	public BlackJackPlayer(int money){
		_money = money;
		hand = new BlackJackHand();
	}
	public BlackJackPlayer(){
		_money = 100;
		hand = new BlackJackHand();
	}
	protected int _money;
	public BlackJackHand hand;
	public void clearHand(){
		hand = new BlackJackHand();
	}

}
