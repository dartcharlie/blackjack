package poker_game;

import java.util.Date;

public class GameUtil {
	public static long convertDateToLong(){
		Date d = new Date();
		return d.getTime();
	}
}
