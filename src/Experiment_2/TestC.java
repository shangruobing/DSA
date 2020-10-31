package Experiment_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestC implements ActionListener {
	private JButton login, exit;
	private JFrame jFrame;
	private JLabel title, name, password;
	private JTextField jTextField;
	private JPasswordField jPasswordField;

	public static void main(String[] args) {
		TestC world = new TestC();
		world.run();
	}

	public void run() {
		jFrame = new JFrame("注册 窗口");
		title = new JLabel("请输入如下信息登陆进入系统");

		JPanel jPanel1 = new JPanel();
		jPanel1.add(title);
		JPanel jPanel2 = new JPanel();
		name = new JLabel("用户名：");
		jTextField = new JTextField(8);
		jPanel2.add(name);
		jPanel2.add(jTextField);

		JPanel jPanel3 = new JPanel();
		password = new JLabel("密码");
		jPasswordField = new JPasswordField(8);
		jPanel3.add(password);
		jPanel3.add(jPasswordField);

		JPanel jPanel4 = new JPanel();
		jPanel4.setLayout(new GridLayout(2, 1));
		jPanel4.add(jPanel2);
		jPanel4.add(jPanel3);

		JPanel jPanel5 = new JPanel();
		login = new JButton("注册");
		exit = new JButton("退出");
		jPanel5.add(login);
		jPanel5.add(exit);

		jFrame.add(jPanel1, BorderLayout.NORTH);
		jFrame.add(jPanel4, BorderLayout.CENTER);
		jFrame.add(jPanel5, BorderLayout.SOUTH);
		jFrame.setSize(250, 200);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setLocation(600, 300);
		login.addActionListener(this);
		exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();

		if (source == login) { // 是"注册"按钮
			if ((jTextField.getText().equals("sys")) && (String.valueOf(jPasswordField.getPassword()).equals("123"))) {
			// IDEA提示 getText 方法被抛弃 'getText()' is deprecated
			// if (jTextField.getText().equals("sys") && jPasswordField.getText().equals("123")) {
				title.setText("注册成功");
			} else
				title.setText("注册错误，请重注册!");
		}
		if (source == exit) //是"退出"按纽,退出程序
			System.exit(0);
	}
}
