package model;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import res.ImageResource;

public class Button {

	
	public Button(GLAutoDrawable drawable,float x, float y, float width, float height) {
	GL2 gl =drawable.getGL().getGL2();
	
	gl.glBegin(GL2.GL_QUADS);
	gl.glVertex2f(x ,y );
	gl.glVertex2f(x+width ,y);
	gl.glVertex2f(x+width ,y+height );
	gl.glVertex2f(x ,y+height );
	gl.glEnd();
	}
}
