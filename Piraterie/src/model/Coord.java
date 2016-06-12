package model;

public class Coord {

	
	/**
	 * Coordonnée x du podouble
	 */
	protected double x;
	/**
	 * Coordonnée y du podouble
	 */
	protected double y;
	
	/**
	 * Constructeur du podouble avec les coordonnées x et y 
	 * @param x Coordonnée x du podouble
	 * @param y Coordonnée y du podouble
	 */
	public Coord(double x, double y) {
		this.x = x;
		this.y = y;
	}

/**
 * 	
 * @param c : coordonnées du deuxième podouble
 * Calcule  la distance entre l'instance et c
 * @return la distance en entier entre l'instance et c
 */
	public double distance(Coord c){
		return (double)Math.sqrt(Math.pow(Math.abs(this.x-c.getX()), 2) + Math.pow(Math.abs(this.y-c.getY()), 2));
	}
	/**
	 * Retourne la coordonnée x du podouble
	 * @return la coordonnée x en entier du podouble
	 */
	public double getX() {
		return x;
	}
	/**
	 * Met à jour la coordonnée x du podouble
	 * @param x la nouvelle coordonnée x du podouble
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Retourne la coordonnée y du podouble
	 * @return la coordonnée y en entier du podouble
	 */
	public double getY() {
		return y;
	}
	/**
	 * Met à jour la coordonnée y du podouble
	 * @param y la nouvelle coordonnée y du podouble
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Coord [x=" + x + ", y=" + y + "]";
	}
	
	@Override
	/**
	 * Classe retournant true si les deux coordonnées sont égales, sinon elle retourne false.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
