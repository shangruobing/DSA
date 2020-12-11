package Experiment_10;

import java.awt.*;
import java.util.Iterator;

public class Rocket {
	public Rocket (double ix,double iy,double idx, double idy) {
		x = ix; y=iy; dx = idx; dy=idy;
	}
	
	public double x,y;
	private double dx,dy;
	//private int score=0;
	
	public void move(ListADT<Asteroid> asteroids){
		x+=dx; y+=dy;
		Iterator<Asteroid> e = asteroids.iterator();
		while (e.hasNext()){
			Asteroid rock = (Asteroid) e.next();
			if (rock.nearTo(x,y)){
				rock.hit();

			}

		}
	}
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillOval((int) x, (int) y, 5, 5);

		//g.setFont(new Font("黑体",Font.BOLD,15));
		//g.setColor(Color.blue);
		//g.drawString("得分"+score,10,100);
	}
}
