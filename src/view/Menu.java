package view;



import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import model.Background;
import model.Button;
import model.Logo;
import res.ImageResource;

public class Menu {

	private Logo logo1;
	private ImageResource logo;
	private ImageResource background;
	//private Button playButton = new Button();
	//private Button exitButton = new Button();
	private Background backgroundMenu = new Background();
	private  GL2 gl ;
	private static float red = 1;
	private static float green = 0;
	private static float blue = 1;
	private Window window;
	private float x1 = -(window.getHEIGHT()/2);
	private float x2 =  (window.getHEIGHT()/2);
	private float height1 = window.getHEIGHT();
	private float height2 = window.getHEIGHT() + window.getHEIGHT();
	private float playButtonXcoor ;
	private float playButtonYcoor ;
	private float playButtonHeight ;
	private float playButtonWidth ;
	
	private float exitButtonXcoor ;
	private float exitButtonYcoor ;
	private float exitButtonHeight ;
	private float exitButtonWidth ;
	

	public Menu() {
	//logo1 = new Logo(logo, drawable, -150, 100, 300, 200);	
	playButtonXcoor = -75;
	 playButtonYcoor = -75;
	 playButtonHeight = 150;
	 playButtonWidth = 100;
	 exitButtonXcoor = -75;
	 exitButtonYcoor = -200;
	 exitButtonHeight = 150;
	 exitButtonWidth = 100;
		
	}
	
	
	public void loadTexture(GLAutoDrawable drawable) {
		logo = new ImageResource("/FlappyFalconLogo.jpg");
		background = new ImageResource("/background1.png");
		if(logo == null) {
			System.out.println("Loading Menu Textures Failed!");
		} else {
			System.out.println("Menu Textures Loaded!");
			System.out.println(logo.getTexture());
		}
		
		logo1 = new Logo(logo, drawable, -150, 100, 300, 200);	

	}
	
	public void render( GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		
		backgroundMenu.drawImage(background, drawable, x1 , -(window.getWIDTH()/2) , height1 , window.getWIDTH());
	//	logo1.drawImg(logo, drawable, -150, 100, 300, 200);
		
		logo1.logoMovement(drawable);
		
		logo1 = new Logo(logo, drawable, -150, 100, 300, 200);	
		
		//playButton.Button(drawable, playButtonXcoor, playButtonYcoor, playButtonHeight, playButtonWidth);
		//exitButton.Button(drawable, exitButtonXcoor, exitButtonYcoor, exitButtonHeight, exitButtonWidth);
		//gl.glColor3f(red, green, blue);
		
	}
	public static void setColor(float r, float g, float b) {
		 red = Math.max(0, Math.min(1, r));
		 green = Math.max(0, Math.min(1, g));
		 blue = Math.max(0, Math.min(1, b));
	}

	public float getPlayButtonXcoor() {
		return playButtonXcoor;
	}

	public float getPlayButtonYcoor() {
		return playButtonYcoor;
	}

	public float getPlayButtonHeight() {
		return playButtonHeight;
	}

	public float getPlayButtonWidth() {
		return playButtonWidth;
	}


	public float getExitButtonXcoor() {
		return exitButtonXcoor;
	}


	public float getExitButtonYcoor() {
		return exitButtonYcoor;
	}


	public float getExitButtonHeight() {
		return exitButtonHeight;
	}


	public float getExitButtonWidth() {
		return exitButtonWidth;
	}
	
	
	
}
