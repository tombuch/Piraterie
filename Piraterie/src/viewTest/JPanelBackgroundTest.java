package viewTest;


import static org.junit.Assert.*;

import java.awt.Image;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.Test;


/**
 * Tests de taille des images de tous les objets figurant dans la vue
 * @author metal
 *
 */

public class JPanelBackgroundTest {

	@Test
	public void boatPlayerImageTestWidth() throws IOException {
		InputStream file = ClassLoader.getSystemResourceAsStream("bateau.png");
		Image image = ImageIO.read(file);
		assertEquals(image.getWidth(null), 150);
	}
	
	@Test
	public void boatPlayerImageTestHeight() throws IOException {
		InputStream file = ClassLoader.getSystemResourceAsStream("bateau.png");
		Image image = ImageIO.read(file);
		assertEquals(image.getHeight(null), 134);
	}
	
	
	@Test
	public void boatBotImageTestWidth() throws IOException
	{
		InputStream file = ClassLoader.getSystemResourceAsStream("boat.png");
		Image image = ImageIO.read(file);
		assertEquals(image.getWidth(null), 90);
	}
	
	@Test
	public void boatBotImageTestHeight() throws IOException
	{
		InputStream file = ClassLoader.getSystemResourceAsStream("boat.png");
		Image image = ImageIO.read(file);
		assertEquals(image.getHeight(null), 91);
	}
	
	@Test
	public void bouletImageTestHeight() throws IOException
	{
		InputStream file = ClassLoader.getSystemResourceAsStream("boulet.png");
		Image image = ImageIO.read(file);
		assertEquals(image.getHeight(null), 18);
	}
	
	@Test
	public void bouletImageTestWidth() throws IOException
	{
		InputStream file = ClassLoader.getSystemResourceAsStream("boulet.png");
		Image image = ImageIO.read(file);
		assertEquals(image.getWidth(null), 20);
	}
	
	@Test
	public void zepplinImageTestWidth() throws IOException
	{
		InputStream file = ClassLoader.getSystemResourceAsStream("zepplin.png");
		Image image = ImageIO.read(file);
		assertEquals(image.getWidth(null), 100);
	}
	
	@Test
	public void zepplinImageTestHeight() throws IOException
	{
		InputStream file = ClassLoader.getSystemResourceAsStream("zepplin.png");
		Image image = ImageIO.read(file);
		assertEquals(image.getHeight(null), 151);
	}
}
