package data;

import java.util.ArrayList;

public class Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	private int enemiesAllowed;
	private int enemiesSpawned;

	private Player player;

	private ArrayList<Enemy> enemyList;

	public Game() {
		player = new Player(0.1f, 1f, 0.25f, 400, 8);
		enemiesAllowed = 50;
		enemiesSpawned = 0;
		enemyList = new ArrayList<Enemy>(enemiesAllowed);
	}

	public void update() {
		if (enemiesSpawned < enemiesAllowed) {
			System.out.println("spawning another");
			enemyList.add(new Enemy(1f, 0f, 0f, 500, 1));
			enemiesSpawned++;
		}

		for (Enemy e : enemyList) {
			e.update();
			e.render();
		}
		
		player.update();
		player.draw();
		
	}

	public void getInput() {
		player.getInput();
	}

	public void draw() {
		player.draw();
	}

}
