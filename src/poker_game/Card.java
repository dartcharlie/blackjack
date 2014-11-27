package poker_game;

public abstract class Card {
	public enum Suit{
		Spade(0),Heart(1),Club(2),Diamond(3),Joker(4);
		private int value;
		private Suit(int v) {value = v;}
		public int getValue() {return value;} 
		public static Suit getSuitFromValue(int value){
			Suit s;
			switch(value){
				case 0:
					s = Suit.Spade;
					break;
				case 1:
					s = Suit.Heart;
					break;
				case 2:
					s = Suit.Club;
					break;
				case 3:
					s = Suit.Diamond;
					break;
				case 4:
					s = Suit.Joker;
					break;
				default:
					//print errors
					System.out.print("Suit not found.");
					return null;
			}
			return s;
		}
	}
	
	protected Suit suit;
	protected int faceValue;
	private boolean available;
	public Card(int fv, Suit s){
		suit = s;
		faceValue = fv;
	}
	
	//real value determined by particular game
	public abstract int value();
	public Suit suit() {return suit;}
	
	public boolean isAvailable() {return available;}
	public void markUnavailable() {available = false;}
	public void markAvailable() {available = true;}
}
