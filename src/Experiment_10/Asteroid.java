package Experiment_10;

import java.awt.*;

public class Asteroid {
	public Asteroid (double ix,double iy,double idx,double idy) {
		x = ix; y=iy;dx=idx; dy=idy;
	}
	public int score;
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
		g.setColor(Color.black);
		g.drawOval((int) x, (int) y, size, size);
		//g.drawString("得分"+score,10,100);
	//	g.drawString("得分"+score,10,100);
	}

	public void hit(){
		size = size -4;
		score++;
		System.out.println("当前得分为"+score);
	}

	/**
	 * 判断行星是否靠近指定点
	 * @param tx 指定点的x坐标
	 * @param ty 指定点的y坐标
	 * @return 是否靠近指定点
	 */
	public boolean nearTo(double tx,double ty){
		// use Pythagorean theorem to determine distance between points
		double distance = Math.sqrt((x-tx)*(x-tx)+(y-ty)*(y-ty));
		return distance <size;
	}

}
