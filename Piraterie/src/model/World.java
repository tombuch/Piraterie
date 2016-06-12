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

	public World() {
		this.factory = new Factory();
		this.list = new LinkedList<>();
		this.file = ClassLoader.getSystemResourceAsStream("Background.png");
		this.boatPlayer = ClassLoader.getSystemResourceAsStream("bateau.png");
	}

	//Boucle de jeux
	public void run() throws IOException{
		InputStream lvl= ClassLoader.getSystemResourceAsStream("level.txt");
		BufferedReader line = new BufferedReader(new InputStreamReader(lvl,StandardCharsets.UTF_8));
	
		this.game = initlvl(line);
		while (this.game == true){
//			this.game = initlvl(line);
			this.notifyView();
		
			for (Components components : list) {
				components.tick(this.list);
			}
			Iterator<Components> i = list.iterator();
			while (i.hasNext()){
				Components c = i.next();
				if (c instanceof Boat) {
					Boat boat = (Boat)c;
					if (boat.getmarq()){
						list.remove(boat);
						i = list.iterator();
					}
					
				}
			}
			
			System.out.println(list);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void runlvl(){
		
		
		
	}
	
	// notify la vue 60 fois par seconde
	public void notifyView(){
		if ((System.nanoTime() - this.time) > 1000000000/60){
			this.time = System.nanoTime();
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	// read file level.txt and create lvl with the content
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
	public void fire(Coord vitesse){
		if (abletofire == true){
			Bullet bullet = new Bullet(190, 132);
			bullet.setVitesse(vitesse);
			World.abletofire = false;
			this.list.add(bullet);
		}
	}

	public LinkedList<Components> getList(){
		return this.list;
	}

	public InputStream getBackground() {
		return this.file;
	}

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
