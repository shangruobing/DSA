package Experiment_13;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MergeSort extends Frame {
	public static void main(String[] args) {
		MergeSort world = new MergeSort();
		world.mergeSort(world.data);
	}

	public MergeSort() {
		setTitle("实验十三 归并排序 尚若冰");
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

	public void mergeSort(Integer[] data)
	{
		mergeSort(data, 0, data.length - 1);
	}

	public void mergeSort(Integer[] data,int min,int max) {
		if (min < max)
		{
			int mid = (min+max)/2;
			mergeSort(data,min,mid);
			mergeSort(data,mid+1,max);
			merge(data,min,mid,max);
		}

	}

	private <T extends Comparable<T> >void merge (T [] data,int first,int mid,int last){

		T [] temp = (T [])  (new Comparable[data.length]);
		int first1 = first,last1 = mid;//分成第一个集合数组
		int first2 = mid+1,last2=last;//分为第二个集合数组
		int index = first1;//在临时数组中要打开的索引
		//将每一集合数组中的小项目从数组中拷贝到临时数组
		//直到有一个数组为空
		while(first1<=last1&&first2<=last2) {
			if(data[first1].compareTo(data[first2])<0)
			{
				temp[index]=data[first1];
				first1++;
			}
			else {
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		//从第一个集合数组中拷贝元素（如果还有的话）
					while (first1 <= last1) {
						temp[index] = data[first1];
						first1++;
						index++;
					}
		//从第二个集合数组中拷贝元素（如果还有的话）
					while (first2 <= last2) {
						temp[index]=data[first2];
						first2++;
						index++;
					}
		//将排好序的部分输出回原本的数组
					for(index = first;index <= last;index++)
						data[index] = temp[index];
					array.show();
	}
}

