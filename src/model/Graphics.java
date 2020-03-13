package model;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;

import res.ImageResource;
import view.Renderer;

public class Graphics {
	
	//barvy
	private static float red = 1;
	private static float green = 1;
	private static float blue = 1;
	//private static float alpha = 1;
	private static float rotation = 0;
	
	public static void drawRect(GLAutoDrawable drawable,float x, float y, float width, float height) {
		GL2 gl =drawable.getGL().getGL2();
		
		
		gl.glClearColor(0f, 0f, 0f, 1f);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		//gl.glRotatef(rotation, 0, 0, 1);
		//gl.glTranslatef(1, 0, 0);

		gl.glColor3f(red, green, blue);
		gl.glBegin(GL2.GL_QUADS);
			
			gl.glVertex2f(x, y);
			
			gl.glVertex2f(x + width, y);
			
			gl.glVertex2f(x + width, y + height);
			
			gl.glVertex2f(x, y + height);
		gl.glEnd();
		
		
		

	}
	public static void drawImg(ImageResource image, GLAutoDrawable drawable,float x, float y, float width, float height) {
		GL2 gl =drawable.getGL().getGL2();
		
		Texture tex = image.getTexture();
		if(tex != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
		gl.glClearColor(0f, 0f, 0f, 1f);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		//gl.glRotatef(rotation, 0, 0, 1);
		gl.glTranslatef(1, 0, 0);

		gl.glColor3f(red, green, blue);
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0, 1);
			gl.glVertex2f(x, y);
			gl.glTexCoord2f(1, 1);
			gl.glVertex2f(x + width, y);
			gl.glTexCoord2f(1, 0);
			gl.glVertex2f(x + width, y + height);
			gl.glTexCoord2f(0, 0);
			gl.glVertex2f(x, y + height);
		gl.glEnd();
		gl.glFlush();
		//nebindujem zadnou texturu / image
		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
		
		

	}
	
	public static void setColor(float r, float g, float b) {
		 red = Math.max(0, Math.min(1, r));
		 green = Math.max(0, Math.min(1, g));
		 blue = Math.max(0, Math.min(1, b));
	}

	public static void setRotation(float rotation) {
		Graphics.rotation = rotation;
	}
	
}
