package model;

import java.util.LinkedList;

public class Bullet extends Components{

	private double rayon = new Coord(0, 0).distance(new Coord(20, 18));
	private long time = 0;
	
	
	public Bullet(double x, double y) {
		super(x, y);
		this.file = ClassLoader.getSystemResourceAsStream("boulet.png");
	}


	@Override
	public void tick(LinkedList<Components> list) {
		if (time == 0)
			this.time = System.nanoTime();
		
		double currenttime = (double)(System.nanoTime() - this.time) / 1000000000;
		this.x = this.x + vitesse.x*currenttime;
		this.y = ((-0.5) * World.G * Math.pow(currenttime, 2)+ vitesse.y*currenttime) + this.y;
		if (this.y < -1 || this. x >1500)
		{
			list.remove(this);
			World.abletofire = true;
		}
	}
	public double getRayon(){
		return this.rayon;
	}
}
