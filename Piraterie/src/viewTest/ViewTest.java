package viewTest;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;

import controler.Controler;
import model.World;
import view.View;

/**
 * Tests sur les reglages de la fenetre
 * @author metal
 *
 */
public class ViewTest {
	@Test
	public void TitleTest() throws Exception {
		World w = new World();
		Controler c = new Controler(w);
		View v = new View();
		
		v.init(c);
		assertEquals(v.getTitle(), "Piraterie");
	}
	
	@Test
	public void sizeTest() throws Exception {
		World w = new World();
		Controler c = new Controler(w);
		View v = new View();
		
		v.init(c);
		assertEquals(v.getSize(), new Dimension(1280,720));
	}
	
	@Test
	public void visibleTest() throws Exception {
		World w = new World();
		Controler c = new Controler(w);
		View v = new View();
		
		v.init(c);
		assertTrue(v.isVisible());
	}
	
	@Test
	public void resizeableTest() throws Exception {
		World w = new World();
		Controler c = new Controler(w);
		View v = new View();
		
		v.init(c);
		assertTrue(!v.isResizable());
	}
	
	@Test
	public void prefSizeTest() throws Exception {
		World w = new World();
		Controler c = new Controler(w);
		View v = new View();
		
		v.init(c);
		assertTrue(v.isPreferredSizeSet());
	}
}
