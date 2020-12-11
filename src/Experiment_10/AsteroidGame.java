package Experiment_10;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

public class AsteroidGame extends Frame{
	static public void main (String []args){
		AsteroidGame world = new AsteroidGame();
		world.setVisible(true);
		world.run();
	}
	
	public AsteroidGame(){
		setTitle("实验十  太空大战  尚若冰");
		setSize(FrameWidth,FrameHeight);
		addKeyListener(new KeyReader());
		addWindowListener(new CloseQuit());
		setLocationRelativeTo(null);
		
	}
	private static class CloseQuit extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
    private int score=0;
	private int FrameWidth = 500;
	private int FrameHeight = 400;
	private UnorderedListADT<Asteroid> asteroids = new ArrayUnorderedList<Asteroid>();
	private UnorderedListADT<Rocket> rockets = new ArrayUnorderedList<Rocket>();
	private Station station = new Station(FrameWidth/2, FrameHeight - 20);
	//Asteroid asteroid = new Asteroid(3,3,3,3);
	public void paint(Graphics g){
		station.paint(g);
	//	g.setColor(Color.blue);
		//g.drawString("得分"+score,100,10);
		//asteroid.paint(g);
		Iterator<Asteroid> e = asteroids.iterator();
		while (e.hasNext()){
			Asteroid rock = (Asteroid) e.next();
			rock.paint(g);
		}
		Iterator<Rocket> e1 =rockets.iterator();
		while (e1.hasNext()){
			Rocket rock =(Rocket) e1.next();
			rock.paint(g);
		}
	//g.drawString("得分"+score,100,10);
	}
	/**
	 * 键盘响应事件函数
	 * @author Huarong Du
	 *
	 */
	private class KeyReader extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			char key = e.getKeyChar();
			switch(key){
			  case 'j': station.moveLeft();break;
			  case 'k': station.moveRight();break;
			  case ' ': station.fire(rockets);break;
			  case 'q': System.exit(0);
			}
		}
	}
	/**
	 * 画面移动一格
	 */
	private void movePieces(){
		  //随机产生新的行星
		if(Math.random()<0.3){
			Asteroid newRock = new Asteroid(FrameWidth * Math.random(),20, 10*Math.random()-5,3+3*Math.random());
			asteroids.addToRear(newRock);
		}
		 // 移动画面上的所有物体
		Iterator<Asteroid> e = asteroids.iterator();
		while (e.hasNext()){ //对所有的行星进行移动
			Asteroid rock = (Asteroid) e.next();
			if(rock!=null){
				rock.move();

				if (outofscreen(rock.x,rock.y))
				try {   //删除屏幕外的行星
					asteroids.remove(rock);
				} catch (ElementNotFoundException e2) {
					e2.printStackTrace();
				} catch (EmptyCollectionException e2) {
					e2.printStackTrace();
				}
				station.checkHid(rock);

			}
		}
		Iterator<Rocket> e1 = rockets.iterator();
		while (e1.hasNext()){ //对所有火箭进行移动
			Rocket rock = (Rocket) e1.next();
			if(rock!=null){
				if (outofscreen(rock.x,rock.y))
					try {  //删除屏幕外的火箭
						rockets.remove(rock);
					} catch (ElementNotFoundException e2) {
						e2.printStackTrace();
					} catch (EmptyCollectionException e2) {
						e2.printStackTrace();
					}
					rock.move(asteroids);
			}
		}
	}
	/**
	 * 判断指定点是否在屏幕内
	 * @param x 指定点的x坐标
	 * @param y 指定点的y坐标
	 * @return  该点是否在屏幕内
	 */
	private boolean outofscreen(double x,double y){
		if (x<0||x>FrameWidth ||y<0 ||y> FrameHeight ) return true;
		return false;
	}
	/**
	 * 程序运行
	 */
	public void run(){
		while (true){ //now move pieces
			movePieces();
			repaint();
			try{
				 Thread.sleep(100);
			} catch (Exception e){}
		}
	}
}
