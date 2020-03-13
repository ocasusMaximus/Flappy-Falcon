package model;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;

import res.ImageResource;
import view.Window;

public class Pipe {
	private  float  space ;
	private  float positionX = 0;
	private float random = 0;
	// predavat ty parametry x, y, width , height
	/*public Pipe(GLAutoDrawable drawable,float x, float y, float width, float height) {
		GL2 gl =drawable.getGL().getGL2();
		// souradnice ovlivnim posunuti 

		gl.glNewList(1, GL2.GL_COMPILE);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	
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
	
	gl.glBegin(GL2.GL_TRIANGLE_STRIP);
	gl.glTexCoord2f(0, 0);
	gl.glVertex2f(x , y + space);
	gl.glTexCoord2f(0, 1);
	gl.glVertex2f(x, y + height + space);
	gl.glTexCoord2f(1, 0);
	gl.glVertex2f(x + width, y + space);
	gl.glTexCoord2f(1, 1);
	gl.glVertex2f(x + width, y + height + space);
	gl.glEnd();
		gl.glEndList();
	}
	*/
	public void pipeMovement(GLAutoDrawable drawable) {
		//this.positionX = positionX;
		GL2 gl =drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glTranslatef(positionX, 0, 0);
		positionX-=0.4f;
		
		/*if(positionX < -500) {
			positionX = 0;
			}*/
			
	}
	public  void drawImg(ImageResource image, GLAutoDrawable drawable,float x, float y, float width, float height, float random) {
		this.random = random;
		GL2 gl =drawable.getGL().getGL2();
		
		Texture tex = image.getTexture();
		if(tex != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
		float space2 = (Window.getHEIGHT())/2 ;//- (height * 2);
		space=500;
		
		
		
		
		
		gl.glEnable (GL2.GL_BLEND);
		gl.glBlendFunc (GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		
		gl.glMatrixMode(GL2.GL_TEXTURE);
		gl.glLoadIdentity();
		
		
		
		
		
		//gl.glCallList(1);
	
		System.out.println("Random : " + random );
	
		
		System.out.println("PositionXPipe  : " + positionX );
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
			gl.glTexCoord2f(0, 1);
			gl.glVertex2f(x , y);
			gl.glTexCoord2f(0, 0);
			gl.glVertex2f(x, y + height + random);
			gl.glTexCoord2f(1, 1);
			gl.glVertex2f(x + width, y);
			gl.glTexCoord2f(1, 0);
			gl.glVertex2f(x + width, y + height +random );
		gl.glEnd();
	
	    gl.glBegin(GL2.GL_TRIANGLE_STRIP);
			gl.glTexCoord2f(0, 0);
			gl.glVertex2f(x , y + space + random);
			gl.glTexCoord2f(0, 1);
			gl.glVertex2f(x, y + height + space + space2);
			gl.glTexCoord2f(1, 0);
			gl.glVertex2f(x + width, y + space + random );
			
			gl.glTexCoord2f(1, 1);
			gl.glVertex2f(x + width, y + height + space + space2);
		gl.glEnd();
	
		
		

	}
	// potrebuju aby to vzalo  x hodnotu predesle pipe a pricetlo k ni 400
	public float getTubeSpaceX(float x) {
		float x2 = x + 400;
		return x2;
	}
	public float getRandomSpaceY(float random) {
		float x2 = random + (float) Math.random() *200;
		return x2;
	}
	public float setTubeSpaceX() {
		float x2 = 0;
		x2 = x2 + 400;
		
		
		return x2;
	}
	public void clear() {
		positionX = 0;
		
	}
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getRandom() {
		return random;
	}
	public void setRandom(float random) {
		this.random = random;
	}
	
	
	
	

}
