package res;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import view.Window;

public class ImageResource {
	
	private Texture texture = null;
	private BufferedImage buffer = null;
	
	
	public ImageResource(String path) {
		URL url = ImageResource.class.getResource(path);
		
		try {
			buffer= ImageIO.read(url);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		if(buffer != null) {
			buffer.flush();
		}
	}

	public Texture getTexture() {
		if(buffer == null) {
			return null;
		}
		if(texture == null) {
			texture = AWTTextureIO.newTexture(Window.getProfile(), buffer, true);
		}
		
		return texture;
	}
	
}
