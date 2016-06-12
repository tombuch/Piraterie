package modelTest;
import model.Bullet;
import model.Coord;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests de l'initialisation et de la modification de la vitesse et du rayon
 * @author metal
 */

public class BulletTest {
	
	@Test
	public void vitesseTest(){
		Bullet bullet = new Bullet(190, 132);
		bullet.setVitesse(new Coord(20,30));
		assertEquals(bullet.getVitesse(), new Coord(20,30));
	}
	
	@Test
	public void testRayon() {
		double rayon = new Coord(0, 0).distance(new Coord(20, 18));
		Bullet bullet = new Bullet(100,200);
		assertEquals(bullet.getRayon(), rayon, 0);
	}
}
