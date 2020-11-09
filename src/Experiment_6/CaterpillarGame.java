package Experiment_6;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class CaterpillarGame extends Frame{
	public static void main(String []args){
		CaterpillarGame world = new CaterpillarGame();
		world.run();
	}
	public CaterpillarGame(){
		setSize((BoardWidth+2)*SegmentSize,
				BoardHeight*SegmentSize+30);
		setTitle("实验六，毛毛虫--尚若冰");
		addKeyListener(new KeyReader());
		addWindowListener(new CloseQuit());
		setLocation(400,200);
		setVisible(true);
	}

	private Caterpillar playerOne =
			new Caterpillar(Color.blue,new Point(20,10));
	final static int BoardWidth = 60; //窗口宽以网格为单位
	final static int BoardHeight = 40; //窗口高,以网格为单位
	final static int SegmentSize = 10; //网格大小,以象素点为单位

	public void run(){
		while (true){
			movePieces(); //虫移动
			repaint(); //重画桌面

			try{
				Thread.sleep(100);
			} catch (Exception e){}//等待 100 毫秒
		}
	}
	public void paint(Graphics g) {
		playerOne.paint(g);
	} //画虫
	public void movePieces(){
		playerOne.move(this);
	}
	private class KeyReader extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			char c = e.getKeyChar();
			switch(c){
				case 'a': playerOne.setDirection('W');break;
				case 'd': playerOne.setDirection('E');break;
				case 'w': playerOne.setDirection('N');break;
				case 's': playerOne.setDirection('S');break;
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

		private Color color;
		private Point position; //虫头所在位置
		private char direction ='E'; //虫移动的方向
		private QueueADT<Point> body = new LinkedQueue<>();//虫体所在位置
		private QueueADT<Character> commands = new LinkedQueue<>(); //键盘命令

		public void setDirection(char d) {
			commands.enqueue(d);
			System.out.println("键盘命令为"+commands.toString());
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
					body.dequeue();
					body.enqueue(np);
					position = np;
				}
				catch (EmptyCollectionException e) {
					e.printStackTrace();
				}
			}
		}
		/**
		 * 根据虫头的位置及移动方向确定虫头下一点的应在哪一点
		 * @return 下一点的位置
		 */
		private Point newPosition(){
			int x = position.x; //获取虫头位置
			int y = position.y;
			System.out.println("原位置"+x+","+y);
			if(direction =='E') x++; //根据移动方向确定下一点
			else if (direction =='W') x--;
			else if (direction =='N') y--;
			else if (direction == 'S') y++;
			System.out.println("新位置"+x+","+y);
			return new Point(x,y);
		}
		/**
		 * 将虫体画出来
		 * @param g 画布对象
		 */
		public void paint(Graphics g){
			g.setColor(color);
			Iterator<Point> e = body.iterator();

			System.out.println("虫体队列为"+body);
			System.out.println("迭代器为"+e);

			while(e.hasNext()){ //将虫体用圆形画出来
				Point p= e.next();
				if(p!=null)
				g.fillOval(5+CaterpillarGame.SegmentSize*p.x, 10+CaterpillarGame.SegmentSize*p.y,
						CaterpillarGame.SegmentSize,
						CaterpillarGame.SegmentSize);
			}
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
}