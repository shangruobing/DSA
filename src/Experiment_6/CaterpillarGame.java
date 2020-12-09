package Experiment_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Random;

public class CaterpillarGame extends Frame{
	public static void main(String []args){
		CaterpillarGame world = new CaterpillarGame();
		world.run();
	}
	public CaterpillarGame(){
		setSize((BoardWidth+2)*SegmentSize, BoardHeight*SegmentSize+30);
		setTitle("实验六 贪吃蛇--尚若冰");
		addKeyListener(new KeyReader());
		addWindowListener(new CloseQuit());
		setLocationRelativeTo(null);
		setVisible(true);
	}
    Food food=new Food(Color.red,new Point());
	Caterpillar playerOne = new Caterpillar(Color.green,new Point(20,10));
	//Caterpillar playerTwo = new Caterpillar(Color.blue,new Point(0,10));
	final static int BoardWidth = 60; //窗口宽以网格为单位
	final static int BoardHeight = 40; //窗口高,以网格为单位
	final static int SegmentSize = 10; //网格大小,以象素点为单位

	public void run(){
		while (true){
			movePieces(); //虫移动
			repaint(); //重画桌面
			
			try{
				Thread.sleep( 100-playerOne.score/10 );
			} catch (Exception e){}//等待 100 毫秒
		}
	}
	public void paint(Graphics g) {//画虫
		playerOne.paint(g);
		food.paint(g);
		//playerTwo.paint(g);
	}
	public void movePieces(){
		playerOne.move(this);
		//playerTwo.move(this);
	}
	private class KeyReader extends KeyAdapter {
		public void keyPressed(KeyEvent e){   //键盘事件类 keyPressed 键按下时
			char c = e.getKeyChar();
			switch(c){
				case 'a': playerOne.setDirection('W');break;
				case 'd': playerOne.setDirection('E');break;
				case 'w': playerOne.setDirection('N');break;
				case 's': playerOne.setDirection('S');break;
				//default: System.out.println("非法输入"+e.getKeyChar());break;
		/*		case 'j': playerTwo.setDirection('W');break;
				case 'l': playerTwo.setDirection('E');break;
				case 'i': playerTwo.setDirection('N');break;
				case 'k': playerTwo.setDirection('S');break;
		 */
			}
		}
	}

	private static class CloseQuit extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	/**
	 *
	 * @author Huarong Du
	 * 毛毛虫类
	 */
	class Caterpillar{
		/**
		 * 构造函数
		 * @param c 虫的颜色
		 * @param sp 虫尾所在点(网格为单位)
		 */
		public Caterpillar(Color c, Point sp){
			color = c;
			for (int i=0;i<10;i++){ //虫的每一节在一个网格点,共 10 节
				position = new Point(sp.x+i,sp.y);
				body.enqueue(position);
			}
		}
		public int score=-1;
		private Color color;
		private Point position; //虫头所在位置
		private char direction='E'; //虫移动的方向
		private QueueADT<Point> body = new LinkedQueue<>();//虫体所在位置
		private QueueADT<Character> commands = new LinkedQueue<>(); //键盘命令


		public void setDirection(char d) {
			commands.enqueue(d);
		}


		public void move (CaterpillarGame game){
		// 先看是否要改变方向
			if (commands.size()>0){
				Character c;
				try {
					c =commands.dequeue();
					direction = c;
				} catch (EmptyCollectionException e) {
					e.printStackTrace();
				}
			}
		//再找到下一点的位置
			Point np =newPosition();
		//去掉尾部一节,在新的一点加下头部一节
			if (game.canMove(np)){
				try {
					//System.out.println("食物位置"+food.foodPosition);
					//if (food.getFoodPosition().x== newPosition().x&&food.getFoodPosition().y==newPosition().y){
					//注意 == 和 equals的区别
					if (food.getFoodPosition().equals(newPosition())){
						body.enqueue(np);
						position = np;
						position = np;
						score++;
						food.newFoodPosition();
					}
					else{
					body.dequeue();
					body.enqueue(np);
					position = np;
					}
				}
				catch (EmptyCollectionException e) {
					e.printStackTrace();
				}
			}
			//不能移动时退出程序
			else {
				JOptionPane.showMessageDialog(null,"最终分数为:" + score);
				System.exit(0);
			}
		}
		/**
		 * 根据虫头的位置及移动方向确定虫头下一点的应在哪一点
		 * @return 下一点的位置
		 */
		private Point newPosition(){
			int x = position.x; //获取虫头位置
			int y = position.y;
			//System.out.println("虫头位置"+x+y);
			if(direction =='E') x++; //根据移动方向确定下一点
			else if (direction =='W') x--;
			else if (direction =='N') y--;
			else if (direction == 'S') y++;
			return new Point(x,y);
		}
		/**
		 * 将虫体画出来
		 * @param g 画布对象
		 */
		public void paint(Graphics g){
			g.setColor(color);
			Iterator<Point> e = body.iterator();

			while(e.hasNext()){ //将虫体用圆形画出来
				Point p= e.next();
				if(p!=null)
				g.fillOval(5+CaterpillarGame.SegmentSize*p.x,10+CaterpillarGame.SegmentSize*p.y,
						CaterpillarGame.SegmentSize, CaterpillarGame.SegmentSize);
			}
			g.setFont(new Font("黑体",Font.BOLD,15));
			g.setColor(Color.black);
			g.drawString("得分："+score,10,100);

		}
		/**
		 * @param np //测试的点
		 * @return //虫体是否在这点上在
		 */

		public boolean inPosition (Point np){
			Iterator<Point> e = body.iterator();
			while (e.hasNext()){
				Point location = e.next();
				if(np.equals(location))
					return true;
			}
			return false;
		}
	}
	/**
	 * 测试虫是否能移动
	 * @param np 要移到的下一点
	 * @return 能否移动
	 */

	public boolean canMove (Point np){
		//测试是否到边界
		if ((np.x<=0)||(np.y<=0))
			return false;
		if ((np.x >=BoardWidth)|| (np.y >=BoardHeight))
			return false;
		//测试是否自己堵住自己
		if (playerOne.inPosition(np))
			return false;
		// 可以移动
		return true;
	}

	class Food{
		Point foodPosition;
		QueueADT<Point> foodlocation = new LinkedQueue<>();
		public Food(Color c,Point t) {
			Color color=c;
			foodPosition=new Point(30,10);
			foodlocation.enqueue(foodPosition);
		}
			//食物所在位置
		private Point getFoodPosition() {
			int x = foodPosition.x; //获取食物位置
			int y = foodPosition.y;
			//System.out.println("食物位置"+x+y);
			return new Point(x, y);
		}

		private Point newFoodPosition(){
			//改变食物位置
			int x,y;
			Random rand = new Random();
			int z=rand.nextInt(10)+5;

            if(z>8) {
	            x = foodPosition.x + rand.nextInt(5);
	            y = foodPosition.y + rand.nextInt(5);
            }

            else {
            	x = foodPosition.x - rand.nextInt(5);
            	y = foodPosition.y - rand.nextInt(5);
            }

            foodlocation.dequeue();
            foodPosition=new Point(x,y);
			foodlocation.enqueue(foodPosition);

			return new Point(x, y);
		}
		public void paint(Graphics g) {

			g.setColor(Color.red);
			Iterator<Point> e = foodlocation.iterator();

			while (e.hasNext()) { //将食物用圆形画出来
				Point p = e.next();
				if (p != null)
					if (getFoodPosition() != null)
						g.fillOval(5 + CaterpillarGame.SegmentSize * foodPosition.x, 10 + CaterpillarGame.SegmentSize * foodPosition.y,
								CaterpillarGame.SegmentSize, CaterpillarGame.SegmentSize);
			}
		}
	}
}
