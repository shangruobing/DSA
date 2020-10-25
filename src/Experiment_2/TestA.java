package Experiment_2;

import javax.swing.*;
import java.awt.*;

public class TestA {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("商品录入 窗口");
		JPanel jPanel = new JPanel();
		jFrame.setLayout(new FlowLayout());

		JLabel jLabel1 = new JLabel("商品名称");
		JLabel jLabel2 = new JLabel("数量");
		JLabel jLabel3 = new JLabel("单位");
		JTextField jTextField1 = new JTextField(10);
		JTextField jTextField2 = new JTextField(8);
		JTextField jTextField3 = new JTextField(6);

		jPanel.add(jLabel1);
		jPanel.add(jTextField1);
		jPanel.add(jLabel2);
		jPanel.add(jTextField2);
		jPanel.add(jLabel3);
		jPanel.add(jTextField3);
		jFrame.add(jPanel);

		jFrame.setLocation(500, 400);
		jFrame.setSize(380, 100);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);


	}
}
