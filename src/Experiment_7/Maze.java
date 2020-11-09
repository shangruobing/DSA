package Experiment_7;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Maze extends Frame {
	int Min_Value = 0;


	public static void main(String[] args) {
		Maze world = new Maze();
		world.setVisible(true);
		world.solveMaze();
	}

	public Maze() {
		setSize(350, 330);
		setTitle("实验七 走迷宫 尚若冰");
		addWindowListener(new CloseQuit());
	}

	private static class CloseQuit extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	private int mazeWidth = 5;
	private int mazeHeight = 5;
	private int[][] walls = {{10,14, 5, 4, 6},
							 {10, 9, 4, 3,10},
			                 { 9, 5, 2,13, 2},
							 {14,14,10,12, 2},
							 { 9, 1, 1, 3,11}};
	private int[][] visited = new int[5][5];

	private void solveMaze() {
		//用迷宫的起始点（右下角）初始队列
		StackADT<Point> stack = new ArrayStack<Point>();
		stack.push(new Point(mazeWidth - 1, mazeHeight - 1));
		//System.out.println(stack.toString());

		int visitCount = 0;
		while (!stack.isEmpty()) {//开始搜索
			Point p;
			try {
				p = stack.pop();
			//	System.out.println(p);
				if (visited[p.x][p.y] == 0) {//未搜索过的新点

					//findMin_Value(p);
					visited[p.x][p.y]=++visitCount;
					//System.out.println(stack.toString());
					repaint();

					if ((p.x == 0) && (p.y == 0))
						return;//搜索成功
					putNeighbors(p.x, p.y, stack);
					try {
						Thread.sleep(200);
					} catch (Exception e) {
					}
				}
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
				x += 50;
			}
			y += 50;

		}
	}

	private void putNeighbors(int x, int y, StackADT<Point> stack) {

		if((walls[x][y]&1) ==0) stack.push(new Point(x+1,y)); //下方有墙 新产生的点在该点右方
		if((walls[x][y]&2) ==0) stack.push(new Point(x,y+1)); //右方有墙 新产生的点在该点下方
		if((walls[x][y]&4) ==0) stack.push(new Point(x-1,y)); //上方有墙 新产生的点在该点左方
		if((walls[x][y]&8) ==0) stack.push(new Point(x,y-1)); //左方有墙 新产生的点在该点上方
		System.out.println(stack.toString());


	/*
		if ((walls[x][y] & 1) == 0) { //下有墙
			if ((walls[x][y] & 2) != 0)
				stack.push(new Point(x + 1, y));
			if ((walls[x][y] & 4) != 0)
				stack.push(new Point(x , y-1));
			if ((walls[x][y] & 8) != 0)
				stack.push(new Point(x-1, y ));

		}

		if ((walls[x][y] & 2) == 0) {  //右有墙
			if ((walls[x][y] & 1) != 0)
				stack.push(new Point(x , y+1));
			if ((walls[x][y] & 4) != 0)
				stack.push(new Point(x , y-1));
			if ((walls[x][y] & 8) != 0)
				stack.push(new Point(x-1, y ));
		}


		if ((walls[x][y] & 4) == 0){ //上有墙
			if ((walls[x][y] & 1) != 0)
				stack.push(new Point(x , y+1));
			if ((walls[x][y] & 2) != 0)
				stack.push(new Point(x+1 , y));
			if ((walls[x][y] & 8) != 0)
				stack.push(new Point(x-1, y ));
		}


		if ((walls[x][y] & 8) == 0) {//左有墙
			if ((walls[x][y] & 1) != 0)
				stack.push(new Point(x , y+1));
			if ((walls[x][y] & 2) != 0)
			    stack.push(new Point(x+1 , y));
			if ((walls[x][y] & 4) != 0)
				stack.push(new Point(x, y-1 ));
		}


	 */
	}
}

//	private int findMin_Value(Point p) {
	//	int [] array=new int [4];
      /*  for (int i=0;i<visited.length;i++){
	        for (int j=0;j<visited.length;j++)

        	visited[i][j]=1;
        }

       */
//找 该点（四个方向）并且在无墙的情况下的 最小值
/*
			if (p.x > 0 && visited[p.x - 1][p.y] != 0)
				array[0] = visited[p.x - 1][p.y];
			else
			if (p.y > 0 && visited[p.x][p.y - 1] != 0)
				array[1] = visited[p.x][p.y - 1];
			else
			if (p.x < mazeWidth - 2 && visited[p.x + 1][p.y] != 0)
				array[2] = visited[p.x + 1][p.y];
			else
			if (p.y < mazeHeight - 2 && visited[p.x][p.y + 1] != 0)
				array[3] = visited[p.x][p.y + 1];
			System.out.println(Arrays.toString(array));

 */


		//if ((walls[p.x][p.y] & 1) != 0)
		//visited[p.x][p.y]++;
		//if ((walls[p.x][p.y] & 2) != 0)
		//	visited[4][4]=1;

		//if ((walls[p.x][p.y] & 4) != 0)

		//	visited[p.x][p.y-1]=visited[p.x][p.y]++;


		//	if ((walls[p.x][p.y] & 8) != 0)

				//return visited[p.x][p.y];


/*
		for (int i = 0; i < array.length; i++) {

				if (array[i] > Min_Value)
					Min_Value = array[i];
			}
			visited[p.x][p.y] = ++Min_Value;
			System.out.println("最小值为" + Min_Value);

 */
		//return visited[p.x][p.y]++;


