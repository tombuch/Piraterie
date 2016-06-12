package view;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

import controler.Controler;
import model.World;


// Cree la Vue

@SuppressWarnings("serial")
public class View extends JFrame implements Observer{

	private JPanelBackground panel;
	private Controler controler;
	
	public View(){
		super();
	}
	/**
	 * Initialise le controler, la fenetre et le JpanelBackground
	 * @param c Initialise l'attribut controler
	 * @throws Exception
	 */
	public void init(Controler c) throws Exception{
		this.controler = c;
		try {
			// initialise la fenÃªtre
			this.setTitle("AngryBird");
			this.setPreferredSize(new Dimension(1280, 720));
			this.setSize(new Dimension(1280, 720));
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(false);
			this.pack();
			
			// initialise et ajoute le JpanelBackground  
			panel = new JPanelBackground(this.controler);
			panel.setPreferredSize(this.getPreferredSize());
			panel.setSize(this.getSize());
			this.add(panel);
			

			this.setVisible(true);
		} catch (Exception e) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			if (e instanceof IOException)
				System.out.println("Fail load background");
			throw new Exception();
		}
	
	}

	// Recois les notifications du Model 
	
	@Override
	/**
	 * Reçois les notifications du Model
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof World) {
			World world = (World) o;
			this.panel.setBackground(world.getBackground());
			this.panel.setBoatPlayer(world.getBoatPlayer());
			this.panel.setList(world.getList());
		}
		this.repaint();
	}
}
