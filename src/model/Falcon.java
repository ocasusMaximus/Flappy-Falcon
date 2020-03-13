package model;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;

import res.ImageResource;
import view.Renderer;
import view.Window;

public class Falcon {

	private  static float rotation = 0.5f;
	private  static float positionY = 0;
	private static float delta ;
	private static float delta2 ;
	private static boolean isClick = true;
	private static int stepUp = 0;

	
	//vytvorit promenou kde budu drzet aktualni stav te rotace
	// if(a >315(-45spíš)) { a + rotation} a vyresit jenom smer nahoru - ten bude stejny a u smeru dolu se to na zadani klavesy hnedka zmeni 
	
	public  void falconMovement(ImageResource image,GLAutoDrawable drawable) {
		GL2 gl =drawable.getGL().getGL2();
			
			gl.glMatrixMode(GL2.GL_MODELVIEW);
			gl.glLoadIdentity();
			
			gl.glTranslatef(0, positionY, 0);
		
		
			if(!isClick) {
				if(delta < 0) {
				delta = 0;
			}
			 delta += 0.4f;
			 
			
			 stepUp++;
			 
		
			 
			 if(stepUp >=20) {
				 isClick=!isClick;
				 stepUp = 0;
				 
			 }
			}else {
	
		 
		delta += -0.2f;
			}
		positionY += delta;
	}
	
	public   void drawImg(ImageResource image, GLAutoDrawable drawable,float x, float y, float width, float height) {
		GL2 gl =drawable.getGL().getGL2();
		
		Texture tex = image.getTexture();
		if(tex != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
		
		
		
		gl.glEnable (GL2.GL_BLEND);
		gl.glBlendFunc (GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA); 
		gl.glMatrixMode(GL2.GL_TEXTURE);
		gl.glLoadIdentity();
		
		/*double s = Math.sin(Math.toRadians(45));
		 double c = Math.cos(Math.toRadians(45));
		 float xnew = (float)(positionX * c - positionY * s);
		 float ynew =(float)(positionX * s + positionY * c);
		*/
		
		/*gl.glTranslatef((x-width/2 + x + width/2)/2,0, 0);
		gl.glRotatef(rotation,0.0f, 0.0f, -0.03f);
		gl.glTranslatef(-((x-width/2 + x + width/2)/2),0, 0);
		rotation = rotation + 0.2f;*/
		//gl.glLoadIdentity();
		//gl.glTranslatef(0, positionY, 0);
		
		
		/*if(!isClick) {
			if(delta < 0) {
				delta = 0;
			}
			 delta += 0.5f;
			 
			
			 stepUp++;
			 
		
			 
			 if(stepUp >=20) {
				 isClick=!isClick;
				 stepUp = 0;
				 
			 }
			}else {
	
		 
		delta += -0.2f;
			}
		positionY += delta;
		*/
	//	System.out.println("Delta :"  + delta);
	//	System.out.println("Step Up :"  + stepUp);

		
		/*gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0, 1);
		gl.glVertex2f(x , y);
		gl.glTexCoord2f(1, 1);
		gl.glVertex2f(x + width, y);
		gl.glTexCoord2f(1, 0);
		gl.glVertex2f(x + width, y + height);
		gl.glTexCoord2f(0, 0);
		gl.glVertex2f(x , y + height);
	gl.glEnd();*/
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(0, 1);
			gl.glVertex2f(x - width/2, y - height/2);
			gl.glTexCoord2f(1, 1);
			gl.glVertex2f(x + width/2, y - height/2);
			gl.glTexCoord2f(1, 0);
			gl.glVertex2f(x + width/2, y + height/2);
			gl.glTexCoord2f(0, 0);
			gl.glVertex2f(x - width/2, y + height/2);
		gl.glEnd();
		
		
		
		

	}
	public static float getPositionY() {
		return positionY;
	}
	public static void setPositionY(float positionY) {
		Falcon.positionY = positionY;
	}
	public static boolean isClick() {
		return isClick;
	}
	public static void setClick(boolean isClick) {
		Falcon.isClick = isClick;
	}

	public static float getDelta() {
		return delta;
	}

	public static void setDelta(float delta) {
		Falcon.delta = delta;
	}

	public void clear() {
		positionY = 0;	
		delta = 0;
	}
	
	
	
	
}
