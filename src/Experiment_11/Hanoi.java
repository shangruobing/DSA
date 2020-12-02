package Experiment_11;

import java.awt.*;

public class Hanoi extends Panel {
	private int[] poleA,poleB,poleC;
	private String message="";
	public Hanoi(int n){
		poleA=new int[n+1];
		poleB=new int[n+1];
		poleC=new int[n+1];
		for(int i=0;i<=n;i++)
			poleA[i]=n-i;

	}
	public void paint(Graphics g){
		g.drawString(message,95,20);
		g.drawString("A", 95, 200);
		g.drawString("B", 195, 200);
		g.drawString("C", 295, 200);
		paintStack(poleA,g,100,180);
		paintStack(poleB,g,200,180);
		paintStack(poleC,g,300,180);
	}
	private void paintStack(int[] stk,Graphics g, int x, int y){
		int i=0;
		while (i<stk.length && stk[i]!=0){
			// each disk is 10 pixels high, 4*size wide
			g.fillRect(x-4*stk[i], y, 8*stk[i], 9);
			y = y-10;
			i++;
		}
	}
	/**
	 * 移盘操作
	 * @param a 源柱
	 * @param b 目标柱
	 * @return 1 正确,-1 盘符名称错 -2 无盘可移-3 大盘压小盘错
	 */


	public boolean moveDish(char a, char b) {
		int i, j, pA[], pB[];
		switch (a) {
			case 'a':
			case 'A':
				pA = poleA;
				break;
			case 'b':
			case 'B':
				pA = poleB;
				break;
			case 'c':
			case 'C':
				pA = poleC;
				break;
			default:
				message = "盘符名称不对";
				this.repaint();
				return false;
		}
		switch (b) {
			case 'a':
			case 'A':
				pB = poleA;
				break;
			case 'b':
			case 'B':
				pB = poleB;
				break;
			case 'c':
			case 'C':
				pB = poleC;
				break;
			default:
				message = "盘符名称不对";
				this.repaint();
				return false;
		}
		for (i = 0; i < pA.length && pA[i] != 0; i++) ;
		for (j = 0; j < pB.length && pB[j] != 0; j++) ;
		if (i == 0) {
			message = "无盘可移";
			this.repaint();
			return false; //
		}
		if (j > 0 && pA[i - 1] > pB[j - 1]) {
			message = "大盘不能压小盘";
			this.repaint();
			return false;
		} else {
			pB[j] = pA[i - 1];
			pA[i - 1] = 0;
			message = "";
		}
		this.repaint();
		return true;
	}
		public void moveTower(int numDisks, int a, int b, int temp)
	{

		if (numDisks == 1)
			moveOneDisk(a, b);
		else
		{
			moveTower(numDisks-1, a, temp, b);
			moveOneDisk(a, b);
			moveTower(numDisks-1, temp, b, a);
		}
	}
	private void moveOneDisk(int start, int end)
	{
		System.out.println("Move one disk from " + start + " to " + end);
	}

}