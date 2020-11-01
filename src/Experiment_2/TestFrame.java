package Experiment_2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFrame implements ActionListener {
	private JFrame frame;
	private JTextField name,age,id,from;
	private JTextArea message;
	private JButton OK, clear, exit;
	public static void main(String[] args) {
		TestFrame world = new TestFrame(); //定义变量并将创建对象实例赋值给它
		world.run();                       //调用对象的方法run()
	}
	public void run(){
		 //定义窗口变量并实例化，窗口是边框布局的
		 frame = new JFrame("实验二 窗口范例--尚若冰"); //创建窗口
		 JLabel title = new JLabel("学生信息输入");   //定义标签变量并实例化
		 JPanel p = new JPanel();                       //定义并实例化面板变量
		 p.add(title);                                  //将标签放到面板中
		 frame.add(p,BorderLayout.NORTH);              //将面板放到窗口的上方
		 JPanel p1 = new JPanel();                      //定义面板变量并实例化
		 p1.setLayout(new GridLayout(2,4));   //将面板的布局管理设置为2行4列的网格布局
		 
		 //创建输入界面中的各字段的标签及编辑框
		 JLabel ln = new JLabel("姓  名");
		 name = new JTextField("冰");
		 JLabel la = new JLabel("年  龄");
		 age = new JTextField("19");
		 JLabel lid = new JLabel("学  号");
		 id = new JTextField("14");
		 JLabel lf = new JLabel("籍  贯");
		 from = new JTextField("昆明");
		 
		 //将标签及编辑框依次加入到网格布局的面板中
		 p1.add(ln);
		 p1.add(name);
		 p1.add(la);
		 p1.add(age);
		 p1.add(lid);
		 p1.add(id);
		 p1.add(lf);
		 p1.add(from);
		 
		 message = new JTextArea("\n");  //定义并实例化多行文本框
		 JPanel p2 = new JPanel();             //定义并实例化另一面板
		 p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS)); //面板设置为垂直排列的箱式布局
		 p2.add(p1);                           //加入输入界面面板
		 p2.add(message);                      //加入多行文本框
		 //将文本框放窗口下边
		 frame.add(p2, BorderLayout.CENTER);  //将面板放到窗口的中央
		 
		 JPanel p3 = new JPanel();           //定义并实例化另一面板变量
		 OK = new JButton("确定");   //定义并实例化三个按纽变量
		 clear = new JButton("清屏");
		 exit = new JButton("退出");
		 
		 
		 
		 //对三个按纽注册监听程序以响应点击事件
		 OK.addActionListener(this);  
		 clear.addActionListener(this);
		 exit.addActionListener(this);
		 p3.add(OK);       //将三个按钮加入到面板中，面板流式布局
		 p3.add(clear);
		 p3.add(exit);
		 frame.add(p3,BorderLayout.SOUTH);  //将按钮面板放到窗口下边(边框布局)
		 
		 frame.pack();
		 frame.setVisible(true);
		 
		 
		 
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();//获取事件发生的按纽对象
		if(source==OK){ //是"确认"按纽,将输入信息显示到多行文本框中
			message.setText("输入的学生信息是:\n学生姓名:"+
					name.getText()+"年龄:"+age.getText()+
					"学号:"+id.getText()+"籍贯:"+from.getText());
			}
		if(source==clear){//是"清屏"按纽,清空所有文本框
			name.setText("");
			age.setText("");
			id.setText("");
			from.setText("");
			message.setText("");
		}
		if (source==exit){//是"退出"按纽,退出程序
			System.exit(0);
		}
		
	}

}
