package Experiment_12;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertionSort extends Frame {
	public static void main(String[] args) {
		InsertionSort world = new InsertionSort();
		world.insertionSort();
	}

	public InsertionSort() {
		setTitle("实验十二 插入排序 尚若冰");
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

	public void insertionSort() {

		for (int index = 1; index < data.length; index++) {
			int key = data[index];
			int position = index;
			//将大一些的变量向后移动
			while (position > 0 && data[position-1].compareTo(key) > 0){
				data[position] = data[position-1];
				position--;
			}
			data[position] = key;
			array.show();
		}
	}
}
