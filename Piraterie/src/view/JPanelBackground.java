package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controler.Controler;
import model.Boat;
import model.Bullet;
import model.Components;
import model.Coord;

// Jpanel pour le background , L'ihm et les objets

@SuppressWarnings("serial")
public class JPanelBackground extends JPanel {
	
	private Image background;
	private Image boatPlayer;
	private Image boatbot;
	private Image bullet;
	private LinkedList<Components> list;
	private JSlider hauteur = new JSlider();
	private JSlider longeur = new JSlider();
	private JButton launch = new JButton();
	
	public JPanelBackground(Controler c) {
		super();	
		this.setLayout(null);
		
		//initialisation du bouton pour tirer
		launch.setLocation(150, 640);
		launch.setText("Tirer");
		launch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.notifmodel(new Coord(longeur.getValue(), hauteur.getValue()));
			}
		});
		launch.setSize(64,24);
		launch.setVisible(true);
		this.add(launch);
		
		//initialisation du slider pour la hauteur du vecteur
		hauteur.setMaximum(90);
		hauteur.setMinimum(0);
		hauteur.setLocation(0, 500);
		hauteur.setVisible(true);
		hauteur.setSize(24, 200);
		hauteur.setOrientation(JSlider.VERTICAL);
		hauteur.setMajorTickSpacing(1);
		hauteur.setMinorTickSpacing(1);
		hauteur.setPaintTicks(true);
		this.add(hauteur);
		
		//initialisation du slider pour le longeur du victeur
		longeur.setMaximum(90);
		longeur.setMinimum(0);
		longeur.setLocation(24, 664);
		longeur.setVisible(true);
		longeur.setSize(200, 24);
		longeur.setMajorTickSpacing(1);
		longeur.setMinorTickSpacing(1);
		longeur.setPaintTicks(true);
		this.add(longeur);
		
	}
	
	//charge l'image depuis la source
	public Image LoadImage(InputStream file, Image img) {
		try {
			if (img == null){
				Image image;
				image = ImageIO.read(file);
				return image;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void setBackground(InputStream file){
		this.background = this.LoadImage(file, this.background);
	}
	
	public void setBoatPlayer(InputStream file){
		this.boatPlayer = this.LoadImage(file, boatPlayer);
	}
	
	public void setBoatbot(InputStream file){
		this.boatbot = this.LoadImage(file, boatbot);
	}

	public void setbullet(InputStream file){
		this.bullet = this.LoadImage(file, bullet);
	}
	
	public void setList(LinkedList<Components> list){
		this.list = list;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (background != null)
			g.drawImage(background, 0, 0, null);
		if (boatPlayer != null)
			g.drawImage(boatPlayer, 40, 510, null);
		if (list != null){
		for (Components components : list) {
			if (components instanceof Boat) {
				this.setBoatbot(components.getImage());
				g.drawImage(this.boatbot, (int)components.getX(), this.getHeight() - (int)components.getY(), null);
			}
			if (components instanceof Bullet) {
				this.setbullet(components.getImage());
				g.drawImage(bullet, (int)(components.getX()-(0.5*bullet.getWidth(null))), this.getHeight() - (int)(components.getY()-(0.5*bullet.getHeight(null))), null);
			}
			}
		this.list = null;
		}
	}
}
