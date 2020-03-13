package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class Window extends Frame{
	
	
	private GLCanvas canvas;
	private static int WIDTH = 860;
	private static int HEIGHT = 720;
	private static float unitsWide = 10;
	
	private static final int FPS = 60;
	private static GLProfile profile = GLProfile.get(GLProfile.GL2);
	
	
	public Window() {
		setTitle("Floppy Falcon");
		setSize(WIDTH,HEIGHT);
		setApp();
	
		setResizable(false);
		
		
		
		setVisible(true);
		pack();
		
	}
	public void exit() {
		dispose();
		System.exit(0);
	}
	
	
	public void setApp() {
		
		
		profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		canvas = new GLCanvas(capabilities);
		Renderer ren = new Renderer();
		canvas.addGLEventListener(ren);
		canvas.addMouseListener(ren);
		canvas.addMouseMotionListener(ren);
		canvas.addKeyListener(ren);
		canvas.setSize(WIDTH,HEIGHT);
		add(canvas);
		
		addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	            exit();
	        }
	        });
		final FPSAnimator animator = new FPSAnimator(canvas, FPS, true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new Thread() {
					@Override
					public void run() {
						if (animator.isStarted())
							animator.stop();
						System.exit(0);
					}
				}.start();
			}
		});
		animator.start();
	}
	public static int getWIDTH() {
		return WIDTH;
	}
	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
	public static int getHEIGHT() {
		return HEIGHT;
	}
	public static  void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	public static float getUnitsWide() {
		return unitsWide;
	}
	public static void setUnitsWide(float unitsWide) {
		Window.unitsWide = unitsWide;
	}
	public static GLProfile getProfile() {
		return profile;
	}
	
	
	

	

}
