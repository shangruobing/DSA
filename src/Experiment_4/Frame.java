package Experiment_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame implements ActionListener{
	private JFrame frame;
	private JLabel jLabel1,jLabel2;
	private JTextField experission,calcul;
	private JButton calculator,exit;
	private JPanel jPanel1,jPanel2;

/*	public static void main(String[] args) {
		Frame world = new Frame();
		world.run();
	}
*/

	public void run(){
		frame =new JFrame("表达式计算--尚若冰");
		jLabel1=new JLabel("请输入表达式");
		jLabel2=new JLabel("计算值");
		experission=new JTextField(20);
		calcul=new JTextField(10);
		calculator=new JButton("计算");
		exit=new JButton("退出");

		jPanel1 = new JPanel();
		jPanel1.add(jLabel1);
		jPanel1.add(experission);

		jPanel2 = new JPanel();
		jPanel2.add(calculator);
		jPanel2.add(jLabel2);
		jPanel2.add(calcul);
		jPanel2.add(exit);

		frame.add(jPanel1);
		frame.add(jPanel2);
		frame.pack();
		frame.setSize(400,150);
		frame.setLocation(500,350);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);

		exit.addActionListener(this);
        calculator.addActionListener(this);
		//experission.addActionListener(this);
		//calcul.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		Calculator Application=new Calculator();

		JButton source = (JButton) e.getSource();
		if(source==exit){ //退出
			System.exit(0);
		}

		if (source==calculator){
			Application.SetExpression(experission.getText());
			Application.GetState();
			Application.GetExpValue();
			calcul.setText(String.valueOf(Application.GetExpValue()));
		}

	}
}