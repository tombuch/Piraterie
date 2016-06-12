package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;


import controler.Controler;
import view.View;

// Monde physique

public class World extends Observable{

	public static final double G = 9.80665;
	public static boolean abletofire = true;
	private Factory factory;
	private LinkedList<Components> list;
	private Integer level = new Integer(0);
	private boolean game = true;
	private InputStream file;
	private InputStream boatPlayer;
	private Long time = System.nanoTime();
	private int i = 0;
	public World() {
		this.factory = new Factory();
		this.list = new LinkedList<>();
		this.file = ClassLoader.getSystemResourceAsStream("Background.png");
		this.boatPlayer = ClassLoader.getSystemResourceAsStream("bateau.png");
	}

	//Boucle de jeux
	/**
	 * Boucle principale du jeu
	 * @throws IOException
	 */
	public void run() throws IOException{
		InputStream lvl= ClassLoader.getSystemResourceAsStream("level.txt");
		BufferedReader line = new BufferedReader(new InputStreamReader(lvl,StandardCharsets.UTF_8));

		//		this.game = initlvl(line);
		while (this.game == true){
			this.game = initlvl(line);
			while(!this.list.isEmpty()){
				this.runlvl();
				this.notifyView();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void runlvl(){
		for (Components components : list) {
			components.tick(this.list);
		}
		
		// remove les components marque
		Iterator<Components> i = list.iterator();
		while (i.hasNext()){
			Components c = i.next();
			if (c.getmarq()){
				this.list.remove(c);
				i = list.iterator();
			}
		}
	}


	// notify la vue 60 fois par seconde
	/**
	 * M�thode permettant de notifier la vue de tout changement, 60 fois par secondes
	 */
	public void notifyView(){
		if ((System.nanoTime() - this.time) > 1000000000/120){
			this.time = System.nanoTime();
			this.moveObj();
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	public void moveObj() {
		i = i + 1;
		for (Components l : this.list)
		{
			l.setX(l.getX() + 1);
		}
	}

	// read file level.txt and create lvl with the content
	/**
	 * M�thode qui lit le fichier level.txt et cr�e le niveau avec les �l�ments du fichier
	 * @param line param�tre permettant de lire
	 * @return true si le lvl est cr�e, false si il ne l'est pas
	 */
	public boolean initlvl(BufferedReader line){
		String toCreate;
		this.level++;
		Integer i = level;
		i++;
		this.list.clear();
		try {
			while((toCreate = line.readLine()) != null){
				if (toCreate.equals(i.toString())){
					return true;
				}
				else if (!toCreate.equals(level.toString()))
					this.list.add(this.factory.create(toCreate));
			}
		} catch (IOException e) {
			System.out.println("Imposible de charger les level");
		}
		return false;
	}

	//shoot a bullet if possible
	/**
	 * Shoot un bullet si c'est possible
	 * @param vitesse changement de la vitesse pour le bullet
	 */
	public void fire(Coord vitesse){
		if (abletofire == true){
			Bullet bullet = new Bullet(190, 132);
			bullet.setVitesse(vitesse);
			World.abletofire = false;
			this.list.add(bullet);
		}
	}

	/**
	 * getter de l'attribut list
	 * @return list
	 */
	public LinkedList<Components> getList(){
		return this.list;
	}

	/**
	 * getter de l'attribut correspondant au background
	 * @return file
	 */
	public InputStream getBackground() {
		return this.file;
	}

	/**
	 * getter de l'attribut boatPlayer
	 * @return boatPlayer
	 */
	public InputStream getBoatPlayer(){
		return this.boatPlayer;
	}

	public static void main(String[] args) {

		View view = new View();
		World world = new World();
		world.addObserver(view);
		Controler controler = new Controler(world);

		try {
			view.init(controler);
			world.run();
		} catch (Exception e) {
			e.printStackTrace();
		}			

	}
}
