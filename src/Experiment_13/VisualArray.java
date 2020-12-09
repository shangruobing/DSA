package Experiment_13;

import java.awt.*;

public class VisualArray<T> {
	/**
	 * 可视化数组
	 *
	 * @param data
	 */
	public VisualArray(Integer[] data) {
		elementData = data;
		display = new VectorPanel();
	}

	private Integer[] elementData;
	private Panel display;

	public void show() {
		pause();
		display.repaint();
	}

	public void swap(int x, int y) {
		Integer temp = elementData[x];
		elementData[x] = elementData[y];
		elementData[y] = temp;
		show();
	}

	public Panel getPanel() {
		return display;
	}

	private void pause() {
		try {
			Thread.sleep(50);
		} catch (Exception e) {
		}
	}

	private class VectorPanel extends Panel {
		public void paint(Graphics g) {
			int w = getSize().width; //获取屏幕宽
			int h = getSize().height - 20; //确定图的高
			int s = elementData.length; //显示数据个数
			if (s == 0) return;
			int m = 0;
			for (int i = 0; i < s; i++) { //找数据中最大数
				Integer in = (Integer) elementData[i];
				if (in.intValue() > m) m = in.intValue();
			}
			double hunit = 0;
			if (m != 0) hunit = h / (double) m; //求单位高
			double wunit = w / (double) s; //求每个数据的宽
			int leftMargin = (int) (w - s * wunit) / 2; //求左边空白
			for (int i = 0; i < s; i++) { //依次用直条显示每个数据
				Integer in = (Integer) elementData[i];
				int dh = (int) (in.intValue() * hunit);
				g.fillRect((int) (leftMargin + i * wunit),
						(int) (h - dh), (int) (wunit - 1), (int) dh);
			}
			super.paint(g);
		}
	}
}