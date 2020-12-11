package Experiment_7;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Maze extends Frame {
Point p;
	public static void main(String[] args) {
		Maze world = new Maze();
		world.setVisible(true);
		world.solveMaze();
	}

	public Maze() {
		setSize(350, 330);
		setTitle("实验七 走迷宫 尚若冰");
		setLocationRelativeTo(null);
		addWindowListener(new CloseQuit());
	}

	private static class CloseQuit extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	private int mazeWidth = 5;
	private int mazeHeight = 5;
	private int[][] walls = {{14, 14, 5, 4, 6},
			{10, 9, 4, 3, 10},
			{9, 5, 2, 13, 2},
			{14, 14, 10, 12, 2},
			{9, 1, 1, 3, 11}};
	private int[][] visited = new int[5][5];

	private void solveMaze() {
		//用迷宫的起始点（右下角）初始栈
		StackADT<Point> stack = new ArrayStack<>();
		stack.push(new Point(mazeWidth - 1, mazeHeight - 1));

		int visitCount = 0;

		while (!stack.isEmpty()) {//开始搜索
			Point p;
			//System.out.println(stack.toString());
			try {
				p = stack.pop();
				if (visited[p.x][p.y] == 0) {//未搜索过的新点
					//System.out.println(p);//试探过的点
					//	System.out.println(stack.toString());
					visited[4][4]=1;
					visited[p.x][p.y]=++visitCount;

					//if(visited[p.x][p.y-1]!=0)
					//visited[p.x][p.y] = visited[p.x][p.y-1]++;
					//visited[p.x][p.y] = ++visitCount;
					repaint();

					if ((p.x == 0) && (p.y == 0))
						return;//搜索成功

					putNeighbors(p.x, p.y, stack);
				}
               // else{
				////if(p.x<4&&p.y<4)
				//if(((walls[p.x][p.y] & 2) != 0)&&(visited[p.x][p.y]==visited[p.x][p.y+1])&&((walls[p.x][p.y] & 2) != 0)&&((walls[p.x][p.y] & 4) != 0)&&((walls[p.x][p.y] & 8)!= 0))
				//System.out.println(p.x+","+p.y);
					else visited[p.x][p.y]=--visitCount;
				   // if(p.y-1>0)
					//if(visited[p.x][p.y-1]!=0&&(walls[p.x][p.y] & 4) != 0)
					//visited[p.x][p.y]=visited[p.x][p.y-1]+1;}

			 //	if ((walls[p.x][p.y] & 1) == 0)
					//visited[p.x][p.y] = 0;

					//visited[p.x][p.y] = --visitCount;


					try {
						Thread.sleep(200);
					} catch (Exception e) {
					}
			//	}

			} catch (EmptyCollectionException e1) {
				e1.printStackTrace();
			}
		}
		System.err.println("no solution");
	}

	public void paint(Graphics g) {
		int y = 50;
		for (int i = 0; i < mazeHeight; i++) {
			int x = 50;
			for (int j = 0; j < mazeWidth; j++) {  //画迷宫
				if ((walls[i][j] & 1) != 0) g.drawLine(x, y + 50, x + 50, y + 50);
				if ((walls[i][j] & 2) != 0) g.drawLine(x + 50, y, x + 50, y + 50);
				if ((walls[i][j] & 4) != 0) g.drawLine(x, y, x + 50, y);
				if ((walls[i][j] & 8) != 0) g.drawLine(x, y, x, y + 50);
				if (visited[i][j] != 0) //标路径值
					g.drawString(String.valueOf(visited[i][j]), x + 5, y + 30);
				//System.out.println((visited[i][j]));
				x += 50;
			}
			y += 50;

		}
	}

	private void putNeighbors(int x, int y, StackADT<Point> stack) {

		if ((walls[x][y] & 1) == 0){
	//		visited[p.x][p.y]=++visited[p.x+1][p.y];
			stack.push(new Point(x + 1, y)); //下方无墙 新产生的点在该点右方

		}
		if ((walls[x][y] & 2) == 0){
		//	visited[p.x][p.y]=++visited[p.x][p.y+1];
			stack.push(new Point(x, y + 1)); //右方无墙 新产生的点在该点下方

		}
		if ((walls[x][y] & 4) == 0) {
//			visited[p.x][p.y]=++visited[p.x-1][p.y];
			stack.push(new Point(x -1, y));//上方无墙 新产生的点在该点左方

		}
		if ((walls[x][y] & 8) == 0) {
		//	visited[p.x][p.y] = ++visited[p.x][p.y-1];
			stack.push(new Point(x, y - 1)); //左方无墙 新产生的点在该点上方
		}
		//System.out.println(stack.toString());
		//System.out.println("新点"+x+","+y);
	}
}


