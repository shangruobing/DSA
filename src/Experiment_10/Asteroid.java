package Experiment_10;

import javax.swing.*;
import java.awt.*;

public class Asteroid {
	public Asteroid (double ix,double iy,double idx,double idy) {
		x = ix; y=iy;dx=idx; dy=idy;
	}
	public double x,y;
	public int size = 20;
	public double dx,dy;
	/**
	 * 移到下一点
	 */
	public void move(){
		x+=dx;y+=dy;
	}

	public void paint(Graphics g){
		Image Plant;
		Plant =new ImageIcon("C:/Users/冰/Desktop/DSA/src/Experiment_10/Plant.png").getImage();
		g.drawImage(Plant,(int) x, (int) y, size+25, size+25,null);
	}

	public void hit(){
		size = size -15;
	}

	/**
	 * 判断行星是否靠近指定点
	 * @param tx 指定点的x坐标
	 * @param ty 指定点的y坐标
	 * @return 是否靠近指定点
	 */
	public boolean nearTo(double tx,double ty){
		double distance = Math.sqrt((x-tx)*(x-tx)+(y-ty)*(y-ty));
		return distance <size;
	}
}
