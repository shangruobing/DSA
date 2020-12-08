package Experiment_12;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class  VisualSort extends Frame {
	public static void main(String[] args) {
		VisualSort world = new  VisualSort();
		world.selectionSort();
	}

	public VisualSort() {
		setTitle("实验十二 选择排序 尚若冰");
		setSize(500, 300);
		add("Center", array.getPanel());
		addWindowListener(new CloseQuit());
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

	public void selectionSort() {

		for (int index = 0; index < data.length - 1; index++) {
			int min = index;
			for (int scan = index + 1; scan < data.length; scan++)
				if (data[scan].compareTo(data[min]) < 0)
					min = scan;
			array.swap(min, index);
		}
	}
}
