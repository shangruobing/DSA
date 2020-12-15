package Experiment_11;

import java.awt.*;
import java.awt.event.*;

public class hanoiGame extends Frame implements ActionListener{

	public static void main(String[] args) {
		hanoiGame world = new hanoiGame();
		world.setVisible(true);
	}
	public static int Disks;
	Hanoi h;
	Button start,move;
	Panel pan;
	TextField tf1;
	public hanoiGame(){
		Label lb1=new Label("盘数");
		start = new Button("开始");
		start.addActionListener(this);
		move = new Button("移动");
		move.addActionListener(this);
		tf1 = new TextField(3);

		pan = new Panel();
		pan.add(lb1);
		pan.add(tf1);
		pan.add(start);
		pan.add(move);
		this.add(pan,BorderLayout.SOUTH);
		setSize(400,300);
		setTitle("实验十一  自动汉诺塔游戏  尚若冰");
		addWindowListener(new CloseQuit());
		setLocationRelativeTo(null);
	}
	private static class CloseQuit extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Button){ //点击按钮命令
			Button bt=(Button)e.getSource();
			if(bt==start&& tf1.getText()!=null){ //开始命令
				Disks =Integer.parseInt(tf1.getText());
				h= new Hanoi();
				this.add(h, BorderLayout.CENTER);
				setSize(400,301);
			}
			if(bt==move){
				h.solve();
			}
		}
	}
}
