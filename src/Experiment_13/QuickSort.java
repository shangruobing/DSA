package Experiment_13;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class QuickSort extends Frame {
	public static void main(String[] args) {
		QuickSort world = new QuickSort();
		world.quickSort(world.data);
	}

	public QuickSort() {
		setTitle("实验十三 快速排序 尚若冰");
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

	Integer[] data = new Integer[numberOfElements];
	VisualArray array = new VisualArray(data);
	private final static int numberOfElements = 100;

	public void quickSort(Integer[] data)
	{
		quickSort(data, 0, data.length - 1);
	}

	public void quickSort(Integer[] data,int min,int max) {
		if (min < max)
		{
			// create partitions创建分区
			int indexofpartition = partition(data,min,max);

			// sort the left partition (lower values)对左分区排序（较小的值）
			quickSort(data,min, indexofpartition - 1);
			// sort the right partition (higher values)对右分区排序（较大的值）
			quickSort(data,indexofpartition + 1, max);
		}

	}

	private int partition(Integer[] data,int min,int max){

		Integer partitionelement;
		int left,right;
		int middle = (min+max)/2;
		//使用位于中间的数据作为分区元素
		partitionelement=data[middle];
		//进行互换
		array.swap(middle,min);
		left=min;
		right=max;

		while(left<right) {
			//搜索大于分区元素的数据
			while(left<right && data[left].compareTo(partitionelement)
					<=0)
				left++;
			//搜索小于分区元素的数据
			while(data[right].compareTo(partitionelement)>0)
				right--;
			//互换数据
			if(left<right)
				array.swap(left,right);
		}
			//令分区数据在应在的位置
		array.swap(min,right);
		return right;
	}
}

