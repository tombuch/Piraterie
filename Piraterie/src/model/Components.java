package model;

import java.io.InputStream;
import java.util.LinkedList;

public abstract class Components extends Coord{

	/**
	 * attribut permettant de stocker l'image du component
	 */
	protected InputStream file;
	/**
	 * Coordonnées du vecteur vitesse de chaque component
	 */
	protected Coord vitesse;
	
	public Components(double x, double y) {
		super(x, y);
	}
	
	public abstract void tick(LinkedList<Components> list);
	
	/**
	 * Setter de l'attribut vitesse
	 * @param vitesse correspond aux nouvelles coordonnées de l'attribut vitesse
	 */
	public void setVitesse(Coord vitesse){
		this.vitesse = vitesse;
	}
	/**
	 * getter de l'attribut vitesse
	 * @return l'attribut vitesse
	 */
	public Coord getVitesse(){
		return vitesse;
	}
	/**
	 * getter de l'attribut file
	 * @return l'attribut file
	 */
	public InputStream getImage(){
		return file;
	}
}
