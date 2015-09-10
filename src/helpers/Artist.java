package helpers;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Artist {
	public static void drawQuad(float x, float y, float width, float height,
			float r, float g, float b) {
		glColor3f(r, g, b);
		glBegin(GL_QUADS);
		{
			glVertex2f(x, y);
			glVertex2f(x + width, y);
			glVertex2f(x + width, y + height);
			glVertex2f(x, y + height);
		}
		glEnd();
	}

	public static void drawTexture(Texture tex, float x, float y, float width,
			float height) {
		tex.bind();
		glTranslatef(x, y, 0);

		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
			glVertex2f(0, 0);

			glTexCoord2f(1, 0);
			glVertex2f(width, 0);

			glTexCoord2f(1, 1);
			glVertex2f(width, height);

			glTexCoord2f(0, 1);
			glVertex2f(0, height);
		}
		glEnd();
		glLoadIdentity();
	}

	public static Texture loadTexture(String path, String filetype) {
		Texture tex = null;

		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(filetype, in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tex;
	}

	public static Texture quickTLoad(String name) {
		Texture tex = null;

		tex = loadTexture("res/" + name + ".png", "PNG");

		return tex;
	}
}
