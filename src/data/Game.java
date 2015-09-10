package data;

import static helpers.Util.*;

import java.util.ArrayList;

public class Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	public static final int ENTITY_SIZE = 16;

	private int enemiesAllowed;
	private int enemiesSpawned;

	private Player player;

	private ArrayList<Enemy> enemyList;

	public Game() {
		player = new Player(0.1f, 1f, 0.25f, 400, 8);

		// hard coding this for now
		enemiesAllowed = 5000;
		enemiesSpawned = 0;
		enemyList = new ArrayList<Enemy>(enemiesAllowed);

	}

	public void update() {
		if (enemiesSpawned < enemiesAllowed) {
			System.out.println("spawning another");
			enemyList.add(new Enemy((float) Math.random(), (float) Math.random(), (float) Math.random(),
					randInt(0, SCREEN_WIDTH), 2));
			enemiesSpawned++;
		}

		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				e.update();

				if (isColliding(player, e)) {
					e.setAlive(false);
					System.out.println("enemy collided with player");
					//TODO make enemies "not alive" not be drawn
				}
			} else {

			}
		}

		player.update();

	}

	public void getInput() {
		player.getInput();
	}

	public void draw() {
		player.render();

		for (Enemy e : enemyList) {
			e.render();
		}
	}

}
