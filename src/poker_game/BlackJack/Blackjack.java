package poker_game.BlackJack;

import java.util.Scanner;

public class Blackjack{
	private BlackJackDeck _myDeck;
	BlackJackPlayer housePlayer;
	BlackJackPlayer player1;
	public Blackjack(int deckNumber){
		_myDeck = new BlackJackDeck(deckNumber);
		_myDeck.shuffle();
		housePlayer = new BlackJackPlayer();
		player1 = new BlackJackPlayer();
	}
	
	public static void main(String [ ] args){
		Blackjack bj = new Blackjack(2);
		boolean currentGameEnd = false;
		while(true){
			currentGameEnd = bj.startRound();
			if(!currentGameEnd){
				currentGameEnd = bj.playerAction();
			}
			if(!currentGameEnd){
				bj.dealerAction();
			}
			bj.endRound();
			if(!bj.continueToPlay()){
				break;
			}
		}	
	}
	
	public boolean startRound(){
		BlackJackCard currCard = _myDeck.dealCard();
		player1.hand.addCard(currCard);
		currCard = _myDeck.dealCard();
		housePlayer.hand.addCard(currCard);
		currCard = _myDeck.dealCard();
		player1.hand.addCard(currCard);
		currCard = _myDeck.dealCard();
		housePlayer.hand.addCard(currCard);
		printHand(player1.hand,"player1");
		printHand(housePlayer.hand, "House");
		boolean player1BlackJack = player1.hand.isBlackJack();
		boolean housePlayerBlackJack = housePlayer.hand.isBlackJack();
		if(player1BlackJack || housePlayerBlackJack){
			if(player1BlackJack && housePlayerBlackJack){
				System.out.println("both black jack, push!");
			}else if(player1BlackJack){
				System.out.println("You got black jack!");
			}else{
				System.out.println("house got black jack!");
			}
			return true;
		}
		return false;
	}
	
	
	public boolean playerAction(){
		//player Action either break by no more card or busted
		while(true){
			System.out.println("more card? 1 to hit, 2 to stand");
			Scanner in = new Scanner(System.in);
			System.out.println("Enter a command:");
			int command = Integer.parseInt(in.nextLine());
			if(command == 1){
				BlackJackCard currCard = _myDeck.dealCard();
				player1.hand.addCard(currCard);
				printHand(player1.hand,"player1");
			}else if(command == 2){
				break;
			}else{
				System.out.println("command unknown");
			}
			if(player1.hand.busted()){
				System.out.println("sorry, you busted!");
				return true;
			}
		}
		return false;
	}
	
	public void dealerAction(){
		while(housePlayer.hand.valueSum() < 17){
			BlackJackCard currCard = _myDeck.dealCard();
			housePlayer.hand.addCard(currCard);
			printHand(housePlayer.hand,"house");
		}
		
		int housePlayerHandValue = housePlayer.hand.valueSum();
		int player1HandValue = player1.hand.valueSum();
		if(housePlayer.hand.busted() || housePlayerHandValue < player1HandValue){
			System.out.println("congrats, you win!");
		}
		else if(housePlayerHandValue > player1HandValue){
			System.out.println("house win!");
		}else{
			System.out.println("push!");
		}
		
	}
	
	public void endRound(){
		//clean up current hand and shuffle if needed
		housePlayer.clearHand();
		player1.clearHand();
		if(_myDeck.remainingCards() < 10){
			_myDeck.shuffleAndReset();
		}
	}
	
	public void printHand(BlackJackHand hand, String playerName){
		System.out.print(playerName + " hand: ");
		hand.print();
		System.out.println(playerName + " hand value: " + hand.valueSum());
	}
	
	public boolean continueToPlay(){
		System.out.println("continue to play? 1 continue, 2 quit");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a command:");
		int command = Integer.parseInt(in.nextLine());
		if(command == 2){
			return false;
		}
		return true;
	}
}