package Experiment_13;

import java.awt.*;

public class VisualArray<T> {
	/**
	 * ���ӻ�����
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
			int w = getSize().width; //��ȡ��Ļ��
			int h = getSize().height - 20; //ȷ��ͼ�ĸ�
			int s = elementData.length; //��ʾ���ݸ���
			if (s == 0) return;
			int m = 0;
			for (int i = 0; i < s; i++) { //�������������
				Integer in = (Integer) elementData[i];
				if (in.intValue() > m) m = in.intValue();
			}
			double hunit = 0;
			if (m != 0) hunit = h / (double) m; //��λ��
			double wunit = w / (double) s; //��ÿ�����ݵĿ�
			int leftMargin = (int) (w - s * wunit) / 2; //����߿հ�
			for (int i = 0; i < s; i++) { //������ֱ����ʾÿ������
				Integer in = (Integer) elementData[i];
				int dh = (int) (in.intValue() * hunit);
				g.fillRect((int) (leftMargin + i * wunit),
						(int) (h - dh), (int) (wunit - 1), (int) dh);
			}
			super.paint(g);
		}
	}
}