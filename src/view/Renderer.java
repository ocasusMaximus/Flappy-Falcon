package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.SwingUtilities;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import model.Background;
import model.Falcon;
import model.Graphics;
import model.Logo;
import model.Pipe;
import res.ImageResource;

public class Renderer implements GLEventListener, MouseListener,
MouseMotionListener, KeyListener {
	
	private  GL2 gl ;
	private float mx,my;
	
	

	

	//predat do initu 
	private Menu menu;
	private Game game;
	private Window window;
	private enum STATE {
		MENU,
		GAME
	};
	
	private STATE state = STATE.MENU;

	public GL2 getGl() {
		return gl;
	}

	public void setGl(GL2 gl) {
		this.gl = gl;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()== KeyEvent.VK_SPACE) {
			Falcon.setClick(false);
			/*if(Falcon.isClick() == true) {
				Falcon.setClick(false);
			} else if(Falcon.isClick() == false){
				Falcon.setClick(true);
			}*/
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mx = arg0.getX();
		my = arg0.getY();
		//System.out.println("MX: " +mx);
		//System.out.println("MY: " + my);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		mx = arg0.getX();
		my = arg0.getY();
		
		
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			
				 //if(mx > 340 && mx < 515 && my > 322 && my < 400)
			if( mx > (menu.getPlayButtonXcoor() + (window.getWIDTH()/2)) && mx < (menu.getPlayButtonWidth() + (window.getWIDTH()/2)) )
				if(my >(menu.getPlayButtonYcoor() + (window.getHEIGHT()/2)) && my < (menu.getPlayButtonHeight() + (window.getHEIGHT()/2)))
				state = STATE.GAME;
			}
		if( mx > (menu.getExitButtonXcoor() + (window.getWIDTH()/2)) && mx < (menu.getExitButtonWidth() + (window.getWIDTH()/2)) )
			if(my >(menu.getExitButtonYcoor() + (window.getHEIGHT()/2)) && my < (menu.getExitButtonHeight() + (window.getHEIGHT()/2)))
			System.exit(0);
		
		
			
		
		if (SwingUtilities.isRightMouseButton(arg0)) {
			state = STATE.MENU;
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override // vola se pri prvnim spusteni
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		System.out.println("Init GL is " + gl.getClass().getName());
		System.out.println("GL_VENDOR " + gl.glGetString(GL2.GL_VENDOR)); // vyrobce
		System.out.println("GL_RENDERER " + gl.glGetString(GL2.GL_RENDERER)); // graficka karta
		System.out.println("GL_VERSION " + gl.glGetString(GL2.GL_VERSION)); // verze OpenGL
		System.out.println("GL_EXTENSIONS " + gl.glGetString(GL2.GL_EXTENSIONS)); // implementovana rozsireni
		menu = new Menu();
		game = new Game();
		menu.loadTexture( drawable);
		game.loadTexture();
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override // vola se porad
	public void display(GLAutoDrawable drawable) {
		 gl = drawable.getGL().getGL2();
		/* long mils = System.currentTimeMillis();
			if ((mils - oldFPSmils)>300){
				fps = 1000 / (double)(mils - oldmils + 1);
				oldFPSmils=mils;
			}
			//System.out.println(fps);
			float speed = 60; // pocet stupnu rotace za vterinu
			float step = speed * (mils - oldmils) / 1000.0f; // krok za jedno
																// prekresleni
																// (frame)
			oldmils = mils;*/
		gl.glClearColor(0f, 0f, 0f, 1f);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
	//	float unitsTall = Window.getHEIGHT() / (Window.getWIDTH() / Window.getUnitsWide());
		gl.glOrtho(-window.getHEIGHT()/2, window.getHEIGHT()/2 , -window.getWIDTH()/2 , window.getWIDTH()/2, -1, 1);

		//gl.glOrtho(-Window.getUnitsWide() / 2, Window.getUnitsWide() / 2, -unitsTall /2, unitsTall / 2, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		// nastaveni modelovaci transformace
		//gl.glMatrixMode(GL2.GL_MODELVIEW);
	//	gl.glLoadIdentity(); // inicilizace na jednotkovou matici
		// nastaveni projekce
		//gl.glMatrixMode(GL2.GL_PROJECTION);
	//	gl.glLoadIdentity(); // inicializace na jednotkovou matici
	//	Graphics.setColor(0, 1, 1);
	//	Graphics.setRotation(0);
	//	Graphics.drawRect(drawable,-420.0f, -350.0f, 840.0f, 700.0f);
		
	
		if(state == STATE.GAME) {
			game.render(drawable);
		} else if (state == STATE.MENU) {
			game.clear();
			menu.render(drawable);
			
		}
		/*Graphics.setColor(0, 0, 1);
		Graphics.setRotation(2);
		Graphics.drawRect(drawable,-420.0f, -50.0f, 60.0f, 50.0f);*/
		//Graphics.drawRect(drawable,-420.0f, -350.0f, 840.0f, 700.0f);
		/*gl.glColor3f(1.0f, 1.0f, 1.0f);
		gl.glBegin(GL2.GL_TRIANGLES); // vykreslime trojuhelnik
		 // barva prvniho vrcholu CERVENA
		gl.glVertex2f(-430.0f, -50.0f); // souradnice v 2D (levy dolni roh)
		// barva prvniho vrcholu ZELENA
		gl.glVertex2f(-380.0f, 0.0f); // souradnice v 2D (stred prave strany)
		 // barva prvniho vrcholu MODRA
		gl.glVertex2f(-430.0f, 50.0f); // souradnice v 2D (stred horni strany)
		gl.glEnd(); // ukoncime kresleni trojuhelniku
		gl.glTranslatef(2, 0, 0);
		*/
		//int paramTex = GL2.GL_REPEAT;
		//gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, paramTex);
	}

	@Override // vola se pri zmene okna
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
	//	float unitsTall = Window.getHEIGHT() / (Window.getWIDTH() / Window.getUnitsWide());
		
		gl.glOrtho(-430, 430 , -360 , 360, -1, 1);

		//gl.glOrtho(-Window.getUnitsWide() / 2, Window.getUnitsWide() / 2, -unitsTall /2, unitsTall / 2, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		
	}

}
