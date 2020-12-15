package Experiment_11;

import java.awt.*;
import java.awt.event.*;

public class HanoiGame extends Frame implements ActionListener{

	public static void main(String[] args) {
		HanoiGame world = new HanoiGame();
		world.setVisible(true);
	}
	public static int Disks;
	Hanoi h;
	Button confirm,start;
	Panel pan;
	TextField field;
	public HanoiGame(){
		Label label=new Label("盘数");
		confirm = new Button("确定");
		start = new Button("开始");
		field = new TextField(3);
		confirm.addActionListener(this);
		start.addActionListener(this);

		pan = new Panel();
		pan.add(label);
		pan.add(field);
		pan.add(confirm);
		pan.add(start);
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
			if(bt==confirm&& field.getText()!=null){ //确定输入的盘数
				Disks =Integer.parseInt(field.getText());
				h= new Hanoi();
				this.add(h, BorderLayout.CENTER);
				setSize(400,301);
			}
			if(bt==start){ //开始运行
				h.solve();
			}
		}
	}
}
