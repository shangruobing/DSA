package Experiment_11;

import java.awt.*;
import java.util.Arrays;

public class Hanoi extends Panel {
	private int[] poleA, poleB, poleC;
	int i, j, pA[], pB[];
	private String message = "";
	private int totalDisks;

	public Hanoi() {
		totalDisks = hanoiGame.Disks;
		poleA = new int[totalDisks + 1];
		poleB = new int[totalDisks + 1];
		poleC = new int[totalDisks + 1];
		for (int i = 0; i <= totalDisks; i++)
			poleA[i] = totalDisks - i;
	}

	public void paint(Graphics g) {
		g.drawString(message, 95, 20);
		g.drawString("A", 95, 200);
		g.drawString("B", 195, 200);
		g.drawString("C", 295, 200);

		paintStack(poleA, g, 100, 180);
		paintStack(poleB, g, 200, 180);
		paintStack(poleC, g, 300, 180);
	}

	private void paintStack(int[] stk, Graphics g, int x, int y) {
		int i = 0;
		while (i < stk.length && stk[i] != 0) {
			// each disk is 10 pixels high, 4*size wide
			g.fillRect(x - 4 * stk[i], y, 8 * stk[i], 9);
			y = y - 10;
			i++;
		}
	}

	public void solve() {
		moveTower(totalDisks, 1, 3, 2);
	}

	private void moveTower(int numDisks, int start, int end, int temp) {
		if (numDisks == 1)
			moveOneDisk(start, end);
		else {
			moveTower(numDisks-1, start, temp, end);
			//将上面的numDisks-1个圆盘从start移到temp柱，end作临时柱

			try {
			//从start柱将最下面的大盘从start柱移到end柱
				moveOneDisk(start,end);
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			moveTower(numDisks-1, temp, end, start);
			//将上面的numDisks-1个圆盘从temp移到end柱，start作临时柱
		}
	}

	private void moveOneDisk(int start, int end) {
	//	System.out.println("Move one disk from " + start + " to " + end);
		switch (start) {
			case 1:
				pA = poleA;
				break;
			case 3:
				pA = poleB;
				break;
			case 2:
				pA = poleC;
				break;
		}
		switch (end) {
			case 1:
				pB = poleA;
				break;
			case 3:
				pB = poleB;
				break;
			case 2:
				pB = poleC;
				break;
		}

		for (i = 0; i < pA.length && pA[i] != 0; i++) ;
		for (j = 0; j < pB.length && pB[j] != 0; j++) ;
		pB[j]=pA[i-1];
		pA[i-1]=0;

		update(getGraphics());
	/*  repaint是异步执行的，它只会给组件发送一个刷新外观的消息，然后马上返回
		并不等待组件的外观刷新完，也不保证外观一定会刷新，外观是否需要刷新由系统自己决定
		（比如如果系统发现外观没变化，就不需要刷新），即便系统决定刷新外观，跟调用repaint的时刻相比也可能有延迟。
		而update是同步执行的，它会等待组件的外观刷新完后才返回，所以能保证继续执行接下来的代码前，外观一定被刷新

		System.out.println("poleA"+Arrays.toString(poleA));
		System.out.println("poleB"+Arrays.toString(poleB));
		System.out.println("poleC"+Arrays.toString(poleC));
    */
	}
}
