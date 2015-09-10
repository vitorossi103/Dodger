package data;

import static helpers.Artist.drawQuad;

public class Enemy {
	private float x;
	private float yLevel;
	private float r, g, b;
	private float speed;
	private boolean alive;

	public Enemy(float r, float g, float b, float x, float speed) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.x = x;
		this.speed = speed;
		this.yLevel = Game.SCREEN_HEIGHT;
		this.alive = true;
	}

	public void update() {
		/*
		 * logic goes here
		 */

		yLevel -= speed;

		// check if enemy has reached bottom of screen
		if (yLevel > Game.SCREEN_HEIGHT) {
			System.out.println("reached bottom");
			alive = false;
		}
	}

	public void render() {
		drawQuad(x, yLevel, Game.ENTITY_SIZE, Game.ENTITY_SIZE, r, g, b);
		// System.out.println("drew enemy");
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float s) {
		this.speed = s;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getyLevel() {
		return yLevel;
	}

	public void setyLevel(float yLevel) {
		this.yLevel = yLevel;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
