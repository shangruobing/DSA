package Experiment_2;

import javax.swing.*;
import java.awt.*;

public class TestB {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("课程显示 窗口");
		jFrame.setLayout(new GridLayout(3, 2));

		JLabel jLabel1 = new JLabel("课程");
		JLabel jLabel2 = new JLabel("考试时间");
		JLabel jLabel3 = new JLabel("数据结构");
		JLabel jLabel4 = new JLabel("五月三十日");
		JLabel jLabel5 = new JLabel("英语");
		JLabel jLabel6 = new JLabel("六月二日");

		jFrame.add(jLabel1);
		jFrame.add(jLabel2);
		jFrame.add(jLabel3);
		jFrame.add(jLabel4);
		jFrame.add(jLabel5);
		jFrame.add(jLabel6);

		jFrame.setLocation(500, 400);
		jFrame.setSize(350, 100);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	}
}
