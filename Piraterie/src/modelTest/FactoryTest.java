package modelTest;
import model.Factory;
import model.Zepplin;
import model.Boat;
import model.Components;
import static org.junit.Assert.*;

import org.junit.Test;

public class FactoryTest {
	@Test
	public void createZepTest()
	{	
		String s = "Zepplin;700;150";
		Factory test = new Factory();
		Components zep = new Zepplin(700, 150);
		Components c = test.create(s);
		assertEquals(zep.getX(), c.getX(), 0);
	}
	@Test
	public void createBoatTest()
	{
		String s = "Boat;700;150";
		Factory test = new Factory();
		Components boat = new Boat(700,150);
		Components c = test.create(s);
		assertEquals(boat.getX(),c.getX(),0);
	}
}
