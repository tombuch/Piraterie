package model;

import java.util.LinkedList;

public class Boat extends Components{

	/**
	 * Coordonées de la taille du bateau, sert a check les colisions
	 */
	private Coord size;
	double diago;
	private boolean marq = false;
	
	public Boat(double x, double y) {
		super(x, y);
		this.file = ClassLoader.getSystemResourceAsStream("boat.png");
		this.initforcollision();
		}

	/**
	 * Méthode permettant d'initialiser les attributs servant pour établir les colisions
	 */
	private void initforcollision(){	
		this.size = new Coord(90, 90);
		this.diago = new Coord(0,0).distance((new Coord(this.size.getX()/2, this.size.getY()/2)));
	}
	
	/**
	 * getter de marq
	 * @return la valeur de marq
	 */
	public boolean getmarq() {
		return marq;
	}	
	
	/**
	 * Méthode permettant de gérer les collisions entre le bullet et le boat
	 */
	@Override
	public void tick(LinkedList<Components> list) {
		for (Components components : list) {
			if (components instanceof Bullet) {
				Bullet bullet = (Bullet) components;
				System.out.println(this.diago);
				System.out.println((bullet.getRayon()+this.diago));
				System.out.println(bullet.distance(new Coord(x+size.getX(), y+size.getY())));
				if ((bullet.getRayon()+this.diago) < (bullet.distance(new Coord(x+size.getX()/2, y+size.getY()/2))))
					return;
				else
					marq = true;
			}
		}
	}

}
