package data;

import static helpers.Util.*;
import helpers.Delay;

import java.util.ArrayList;

public class Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	public static final int ENTITY_SIZE = 16;

	private int enemiesAllowed;
	private int enemiesSpawned;

	private Player player;

	private ArrayList<Enemy> enemyList;

	private Delay enemySpawnDelay;

	public Game() {
		player = new Player(0.1f, 1f, 0.25f, 400, 6);

		// hard coding this for now
		enemiesAllowed = 50000;
		enemiesSpawned = 0;
		enemyList = new ArrayList<Enemy>(enemiesAllowed);
		enemySpawnDelay = new Delay(75);
		enemySpawnDelay.end();
	}

	public void update() {
		if (enemiesSpawned < enemiesAllowed) {
			if (enemySpawnDelay.over()) {
				System.out.println("spawning another");
				enemyList.add(new Enemy((float) Math.random(), (float) Math
						.random(), (float) Math.random(), randInt(0,
						SCREEN_WIDTH), 2));
				enemiesSpawned++;
				enemySpawnDelay.start();
			}
		}

		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				e.update();

				if (isColliding(player, e)) {
					e.setAlive(false);
					// TODO make enemies "not alive" not be drawn
				}
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
