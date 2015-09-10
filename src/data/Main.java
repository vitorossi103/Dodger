package data;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {
	private static Game game;
	
	public static void main(String[] args) {
		initDisplay();
		initGL();
		initGame();
		
		gameLoop();
		
		cleanUp();
	}
	
	private static void gameLoop() {
		while (!Display.isCloseRequested()) {
			getInput();
			update();
			render();
		}
	}
	
	private static void getInput() {
		game.getInput();
	}
	
	private static void update() {
		game.update();
	}
	
	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		game.draw();
		
		Display.update();
		Display.sync(60);
	}
	
	private static void initGame() {
		game = new Game();
	}
	
	private static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT));
			Display.create();
			Keyboard.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	private static void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);

		glDisable(GL_DEPTH_TEST);
		
		glClearColor(0, 0, 0, 0);
	}
	
	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
	}
}
