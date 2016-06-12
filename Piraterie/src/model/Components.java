package model;

import java.io.InputStream;
import java.util.LinkedList;

public abstract class Components extends Coord{

	protected InputStream file;
	protected Coord vitesse;
	
	public Components(double x, double y) {
		super(x, y);
	}
	
	public abstract void tick(LinkedList<Components> list);
	
	public void setVitesse(Coord vitesse){
		this.vitesse = vitesse;
	}
	public Coord getVitesse(){
		return vitesse;
	}
	
	public InputStream getImage(){
		return file;
	}
}
