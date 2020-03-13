package view;

import java.util.ArrayList;
import java.util.List;

import com.jogamp.opengl.GLAutoDrawable;

import model.Background;
import model.Falcon;
import model.Pipe;
import res.ImageResource;

public class Game {
	
	
	private Falcon flcon = new Falcon() ;
	private Background background1 = new Background();
	
	private Pipe pipe1 = new Pipe();
	private Pipe pipe2 = new Pipe();
	private Pipe pipe3 = new Pipe();
	private List<Pipe> pipes = new ArrayList();
	private Window window;
	private ImageResource falcon;
	private ImageResource background;
	private ImageResource pipe;
	private float x1 = -(window.getHEIGHT()/2);
	private float x2 =  (window.getHEIGHT()/2);
	private float height1 = window.getHEIGHT();
	private float height2 = window.getHEIGHT() + window.getHEIGHT();
	private float random = (float) Math.random() *200;
	private float random2 = (float) Math.random() *200;
	private float xPipe = 400;
	
	// incializovat konsturktor a v nem zavolat trubku 
	
	public Game() {
		
	}
	public void loadTexture() {
		falcon = new ImageResource("/Falcon.png");
		background = new ImageResource("/background1.png");
		pipe = new ImageResource("/pipe2.png");
		if(falcon == null && background == null && pipe == null) {
			System.out.println("Loading Game Textures Failed!");
		} else {
			System.out.println("Game Textures Loaded!");
			System.out.println(falcon.getTexture());
			System.out.println(background.getTexture());
			System.out.println(pipe.getTexture());
		}
	
	
	for(int i = 0; i < 10; i++) {
		pipes.add(i, pipe1);
		
		}
	}
	public void render(GLAutoDrawable drawable) {
		
		//System.out.println("Pipe :" + pipes.size() + "Pozice 5 : " +pipes.get(5));
		background1.backgroundMovement(background, drawable);
		background1.drawImage(background, drawable, x1 , -(window.getWIDTH()/2) , height1 , window.getWIDTH());
		
		if(pipe1.getPositionX() < -400) {
		pipe1.setPositionX(0);
	}
		//pipe1 = new Pipe(drawable, 100,-(window.getWIDTH()/2) , 50, 200);
		pipe1.pipeMovement(drawable);
		pipe1.drawImg(pipe, drawable, 0,-(window.getWIDTH()/2) , 50, 200, 100);
		
		
		if(pipe2.getPositionX() < -400 + 200) {
			pipe2.setPositionX(0);
		}
		
		pipe2.pipeMovement(drawable);
		pipe2.drawImg(pipe, drawable, xPipe,-(window.getWIDTH()/2) , 50, 200,-50);
		
		/*
		pipe1.pipeMovement(pipe, drawable);
		pipe1.drawImg(pipe, drawable, 800,-(window.getWIDTH()/2) , 50, 200, 50);
		
		pipe1.pipeMovement(pipe, drawable);
		pipe1.drawImg(pipe, drawable, 1200,-(window.getWIDTH()/2) , 50, 200, 300);
		
		pipe1.pipeMovement(pipe, drawable);
		pipe1.drawImg(pipe, drawable, 1600,-(window.getWIDTH()/2) , 50, 200, 200);
		
		*/
	//	pipe3.pipeMovement(pipe, drawable);
	//	pipe3.drawImg(pipe, drawable, pipe2.getTubeSpaceX(400),-(window.getWIDTH()/2) , 50, 200, pipe2.getRandomSpaceY(10));
		//pipe1.pipeMovement(pipe, drawable);
		//pipe1.drawImg(pipe, drawable, xPipe,-(window.getWIDTH()/2) , 50, 200, random2);
		//flcon.falconMovement(falcon,drawable);
		//flcon.drawImg(falcon, drawable, -280, 0, 100 , 65);
		
		
	}
	
	// vymaze veskere objekty = nova scena
	public void clear() {
		pipe1.clear();
		background1.clear();
		flcon.clear();
		random = (float) Math.random() *200;
		random2 = (float) Math.random() *200;
		
	}
	
	
}
