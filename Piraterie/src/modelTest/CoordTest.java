package modelTest;

import model.Coord;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test sur les coordonnes x et y
 * @author metal
 *
 */

public class CoordTest {
	
	@Test
	public void testX()
	{
		Coord test = new Coord(1,2);
		test.setX(3);
		assertEquals(test.getX(), 3,0);
	}
	
	@Test
	public void testY()
	{
		Coord test = new Coord(1,2);
		test.setY(5);
		assertEquals(test.getY(), 5,0);
	}
}
