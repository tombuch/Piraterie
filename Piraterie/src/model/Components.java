package model;

import java.io.InputStream;
import java.util.LinkedList;

public abstract class Components extends Coord{

	/**
	 * attribut permettant de stocker l'image du component
	 */
	protected InputStream file;
	/**
	 * Coordonnees du vecteur vitesse de chaque component
	 */
	protected Coord vitesse;
	protected boolean marq = false;
	
	public Components(double x, double y) {
		super(x, y);
	}
	
	public abstract void tick(LinkedList<Components> list);
	
	/**
	 * getter de marque
	 * @return la valeur de marq
	 */
	public boolean getmarq() {
		return marq;
	}
	
	/**
	 * Setter de l'attribut vitesse
	 * @param vitesse correspond aux nouvelles coordonnees de l'attribut vitesse
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
