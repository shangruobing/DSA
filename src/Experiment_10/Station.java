package Experiment_10;

import java.awt.*;

public class Station {
	public Station( double ix,double iy){x=ix;y=iy;}

	private double angle = Math.PI/2.0;
	private int hits = 0;
	private final double x;
	private final double y;

	
	public void moveLeft(){
		angle = angle +0.1;
	}
	public void moveRight(){
		angle = angle -0.1;
	}

	/**
	 * 发射击火箭
	 * @param rockets 保存射出火箭的线性表
	 */
	public void fire (UnorderedListADT<Rocket> rockets){
		double cosAngle = Math.cos(angle);
		double sinAngle = Math.sin(angle);
		  // rocket goes same direction as gun is pointing
		Rocket r= new Rocket(x +15*cosAngle, y-15 *sinAngle, 5*cosAngle, -5*sinAngle);
		rockets.addToRear(r);		
	}

	/**
	 * 检查炮站是非被行星击中,并记录伤害程度
	 * @param rock 袭击炮站的行星
	 */
	public void checkHid(Asteroid rock){
		if (rock.nearTo(x, y))
			hits += rock.size;


	}
	//画出炮站
	public void paint(Graphics g){

		double lv = 20 *Math.sin(angle); //炮有 20个像素点长
		double lh = 20 * Math.cos(angle);
		g.drawLine((int)x, (int) y, (int)(x+lh),(int)( y-lv));
		g.drawString("hits:" +hits, (int)(x+10),(int)(y-5));


	}
}
