package model;

import java.util.LinkedList;

public class Zepplin extends Components {

	private Coord size;
	double diago;
	
	public Zepplin(double x, double y) {
		super(x, y);
		this.file = ClassLoader.getSystemResourceAsStream("zepplin.png");
		this.initforcollision();
	}

	/**
	 * Methode permettant d'initialiser les valeurs de collisions
	 */
	private void initforcollision(){	
		this.size = new Coord(100, 151);
		this.diago = new Coord(0,0).distance((new Coord(this.size.getX()/2, this.size.getY()/2)));
	}
	
	

	@Override
	/**
	 * Methode qui va s'appeler a chaque tick, soit 
	 */
	public void tick(LinkedList<Components> list) {
		for (Components components : list) {
			if (components instanceof Bullet) {
				Bullet bullet = (Bullet) components;
					if ((bullet.getRayon()+this.diago) < (bullet.distance(new Coord(x+size.getX()/2, y-size.getY()/2))))
						return;
					else{
						marq = true;
						bullet.marq = true;
						World.abletofire = true;
						return;
					}
				}
		}		
	}

}
