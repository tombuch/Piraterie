package controler;

import model.Coord;
import model.World;

public class Controler {
	
	World w;
	
	public Controler(World w) {
		this.w = w;
	}
	
	public void notifmodel(Coord c){
		w.fire(new Coord(c.getX()/40, c.getY()/18));
	}
}
