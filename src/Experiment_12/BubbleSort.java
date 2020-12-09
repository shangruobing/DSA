package Experiment_12;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BubbleSort extends Frame {
	public static void main(String[] args) {
		BubbleSort world = new BubbleSort();
		world.bubbleSort();
	}

	public BubbleSort() {
		setTitle("实验十二 冒泡排序 尚若冰");
		setSize(500, 300);
		add("Center", array.getPanel());
		addWindowListener(new CloseQuit());
		setLocationRelativeTo(null);
		setVisible(true);
		for (int i = 0; i < numberOfElements; i++) {
			int d = (int) (numberOfElements * Math.random());
			data[i] = d;
		}
	}

	private class CloseQuit extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	private Integer[] data = new Integer[numberOfElements];
	private VisualArray array = new VisualArray(data);
	private final static int numberOfElements = 100;

	public void bubbleSort() {

		int position,scan;
		for (position = data.length - 1;position >= 0; position--){
			//数据遍历
			for (scan = 0; scan <= position - 1 ;scan++){
				//对全部相邻数据比较
				if(data[scan].compareTo(data[scan+1])>0)
					array.swap(scan,scan+1);
				array.show();
			}
		}
	}
}
