package model;

import java.util.LinkedList;

public class Boat extends Components{

	private Coord size;
	double diago;
	private boolean marq = false;
	
	public Boat(double x, double y) {
		super(x, y);
		this.file = ClassLoader.getSystemResourceAsStream("boat.png");
		this.initforcollision();
		}

	private void initforcollision(){
		this.size = new Coord(90, 90);
		this.diago = new Coord(0,0).distance((new Coord(this.size.getX()/2, this.size.getY()/2)));
	}
	
	public boolean getmarq() {
		return marq;
	}	
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
