package model;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;

import res.ImageResource;

public class Background {
	private static float positionX = 0;
	
	
	public void backgroundMovement(ImageResource image,GLAutoDrawable drawable) {
		GL2 gl =drawable.getGL().getGL2();
		positionX += 0.0001 ;
		
		gl.glMatrixMode(GL2.GL_TEXTURE);
		gl.glLoadIdentity();
		gl.glTranslatef(positionX, 0, 0);
		
	}
	public  void drawImage(ImageResource image, GLAutoDrawable drawable,float x, float y, float width, float height) {
		GL2 gl =drawable.getGL().getGL2();
		
		Texture tex2 = image.getTexture();
		if(tex2 != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex2.getTextureObject());
			gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
		}
	
		
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		gl.glTexCoord2f(0, 1);
		gl.glVertex2f(x , y);
		gl.glTexCoord2f(0, 0);
		gl.glVertex2f(x, y + height);
		gl.glTexCoord2f(1, 1);
		gl.glVertex2f(x + width, y);
		gl.glTexCoord2f(1, 0);
		gl.glVertex2f(x + width, y + height);
		gl.glEnd();
		
		
		
		

	}

	public static float getPositionX() {
		return positionX;
	}

	public void clear() {
		positionX = 0;
		
	}
	
	
}
