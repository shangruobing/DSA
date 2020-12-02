package Experiment_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class hanoiGame extends Frame implements ActionListener {
	Button start;
	Label label;
	TextField count;
	Hanoi hanoi;
	private Object Graphics;

	public static void main(String[] args) {
		hanoiGame world = new hanoiGame();

		world.setVisible(true);
	}
	public hanoiGame(){
		label=new Label("盘数:");
		start=new Button("开始");
		count=new TextField(4);
		JPanel panel=new JPanel();

		panel.add(label);

		panel.add(count);
		panel.add(start);
		start.addActionListener(this);
		this.add(panel,BorderLayout.SOUTH);
		setSize(400,300);
		setTitle("实验十一 自动汉诺塔游戏 尚若冰");
		addWindowListener(new CloseQuit());

	}
	private static class CloseQuit extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Button) //点击按钮命令
		{ Button bt=(Button)e.getSource();
			if(bt==start&& count.getText()!=null){ //开始命令
				int n =Integer.parseInt(count.getText());
				hanoi=new Hanoi(n);
				this.add(hanoi, BorderLayout.CENTER);
				setSize(400,300);
				System.out.println("n为"+n);


			}
		}
	}
}