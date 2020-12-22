package Experiment_10;

import javax.swing.*;
import java.awt.*;

public class Station {
	Image Plane;
	public Station( double ix,double iy){
		x=ix;y=iy;
	}

	private double angle = Math.PI/2.0;
	private int hits = 100;
	private double x;
	private double y;

	public void moveUp(){
		y = y -20;
	}
	public void moveDown(){
		y = y +20;
	}
	public void moveLeft(){
		x = x -20;
	}
	public void moveRight(){
		x = x +20;
	}

	/**
	 * 发射击火箭
	 * @param rockets 保存射出火箭的线性表
	 */
	public void fire (UnorderedListADT<Rocket> rockets){
		double cosAngle = Math.cos(angle);
		double sinAngle = Math.sin(angle);

		Rocket rocket= new Rocket(x +15*cosAngle, y-15 *sinAngle, 5*cosAngle, -5*sinAngle);
		rockets.addToRear(rocket);
	}

	/**
	 * 检查炮站是非被行星击中,并记录伤害程度
	 * @param rock 袭击炮站的行星
	 */
	public void checkHid(Asteroid rock){
		if (rock.nearTo(x, y))
			hits =hits- rock.size;
		if (hits<=0){
			JOptionPane.showMessageDialog(null,"最终分数为:" + AsteroidGame.score);
			System.exit(0);
		}
	}
	//画出飞机
	public void paint(Graphics g){
		g.drawString("生命值:" +hits, 300,380);
		Plane = new ImageIcon("C:/Users/冰/Desktop/DSA/src/Experiment_10/Plane.png").getImage();
		g.drawImage(Plane, (int)x-40,(int)y-70,90,90,null);
	}
}
