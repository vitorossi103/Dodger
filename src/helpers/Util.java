package helpers;

import java.awt.Rectangle;
import java.util.Random;

import data.Enemy;
import data.Player;

public class Util {

	public static boolean isColliding(Player p, Enemy e) {
		Rectangle player = new Rectangle((int) p.getxPos(),
				(int) Player.getPlayerYLevel(), 16, 16);
		Rectangle enemy = new Rectangle((int) e.getX(), (int) e.getyLevel(),
				16, 16);

		return player.intersects(enemy);
	}
	
	public static int randInt(int min, int max) {
		Random rand = new Random();
		
		return rand.nextInt((max - min) + 1) + min;
	}

}
