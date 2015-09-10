package data;

import static helpers.Artist.drawQuad;

import org.lwjgl.input.Keyboard;

public class Player {
	private static final float PLAYER_Y_LEVEL = 50;
	private float xPos;
	private float speed;
	private float r, g, b; // RGB values of player

	/* private Texture texture; */

	public Player(/* Texture texture */float r, float g, float b, float xPos,
			int speed) {
		/* this.texture = texture; */
		this.r = r;
		this.g = g;
		this.b = b;
		this.xPos = xPos;
		this.speed = speed;
	}

	public void update() {
		
	}

	public void render() {
		/* drawTexture(texture, xPos, PLAYER_Y_LEVEL, 64, 64); */
		drawQuad(xPos, PLAYER_Y_LEVEL, 16, 16, r, g, b);
	}

	public void getInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			xPos -= speed;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			xPos += speed;
		}
	}

	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/*
	 * public Texture getTexture() { return texture; }
	 * 
	 * public void setTexture(Texture texture) { this.texture = texture; }
	 */

	public static float getPlayerYLevel() {
		return PLAYER_Y_LEVEL;
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
}
