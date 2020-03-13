package model;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;

import res.ImageResource;

public class Logo {
	
	private float positionX = 200;
	public   Logo(ImageResource image, GLAutoDrawable drawable,float x, float y, float width, float height) {
		GL2 gl =drawable.getGL().getGL2();
		
		Texture tex = image.getTexture();
		if(tex != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
		gl.glEnable (GL2.GL_BLEND);
		gl.glBlendFunc (GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA); 
		gl.glMatrixMode(GL2.GL_TEXTURE);
		gl.glLoadIdentity();
		
		//gl.glColor3f(red, green, blue);
		//zmenit souradnice 
		
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
	
	public void logoMovement(GLAutoDrawable drawable) {
		GL2 gl =drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		//gl.glLoadIdentity();
		positionX-=0.2f;
		gl.glTranslatef(positionX, 0, 0);
		
		System.out.println(positionX);
	}
	
	
}
