package Experiment_10;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Rocket{

	public Rocket (double ix,double iy,double idx, double idy) {
		x = ix; y=iy; dx = idx; dy=idy;
	}

	public double x,y;
	private double dx,dy;
	
	public void move(ListADT<Asteroid> asteroids){
		x+=dx; y+=dy;
		Iterator<Asteroid> e = asteroids.iterator();
		while (e.hasNext()){
			Asteroid rock = (Asteroid) e.next();
			if (rock.nearTo(x,y)){
				rock.hit();
				AsteroidGame.score++;
			}
		}
	}

	public void paint(Graphics g){
		Image Rocket;
		Rocket = new ImageIcon("C:/Users/冰/Desktop/DSA/src/Experiment_10/Rocket.png").getImage();
		g.drawImage(Rocket,(int) x-10, (int) y,30,30, null);
	}
}
