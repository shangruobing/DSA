package Experiment_11;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Maze extends Frame {

	public static void main(String[] args) {
		Maze world = new Maze();
		world.setVisible(true);
		world.solveMaze(4, 4);
	}

	public Maze() {
		setSize(350, 330);
		setTitle("实验十一 迷宫递归算法 尚若冰");
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
	int visitCount = 0;
	private int solveMaze(int x, int y) {

		if (x == 0 && y == 0) {
			return visited[0][0] = 1;
			//搜索成功
		} else {
			if (x >= 0 && x < 5 && y >= 0 && y < 5) {
				if (visited[x][y] == 0) {//未搜索过的新点
					visited[x][y] = -1; //表示已经尝试过
					if ((walls[x][y] & 1) == 0) {  // ==0有墙    !=0无墙
						solveMaze(x+1 , y); //下方有墙
					}
					if ((walls[x][y] & 2) == 0) {
						solveMaze(x, y+1); //右方有墙
					}
					if ((walls[x][y] & 4) == 0) {
						solveMaze(x-1 , y);//上方有墙
					}
					if ((walls[x][y] & 8) == 0) {
						solveMaze(x, y-1 ); //左方有墙
					}
					if (((walls[x][y] & 1) == 0) && ((walls[x][y] & 2) == 0) && ((walls[x][y] & 4) == 0) && ((walls[x][y] & 8) == 0))
						return visited[x][y] = 3;

					else return visited[x][y] =3;
				} else return visited[x][y] = -1;
			}
		}
	return -1;
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

				if (visited[i][j] != 0){ //标路径值
					g.drawString(String.valueOf(visited[i][j]), x + 5, y + 30);
				}

				x += 50;
			}
			y += 50;

		}
	}

}


