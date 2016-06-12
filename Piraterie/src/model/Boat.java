package model;

import java.util.LinkedList;

public class Boat extends Components{

	/**
	 * Coordon�es de la taille du bateau, sert a check les colisions
	 */
	private Coord size;
	double diago;
	
	public Boat(double x, double y) {
		super(x, y);
		this.file = ClassLoader.getSystemResourceAsStream("boat.png");
		this.initforcollision();
		}

	/**
	 * M�thode permettant d'initialiser les attributs servant pour �tablir les colisions
	 */
	private void initforcollision(){	
		this.size = new Coord(90, 90);
		this.diago = new Coord(0,0).distance((new Coord(this.size.getX()/2, this.size.getY()/2)));
	}
		
	/**
	 * M�thode permettant de g�rer les collisions entre le bullet et le boat
	 */
	@Override
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
