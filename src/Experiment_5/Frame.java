package Experiment_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener {
	private JFrame frame;
	private JLabel jLabel1,jLabel2;
	private JTextField input,output;
	private JRadioButton jRadioButton1,jRadioButton2;
	private JPanel jPanel1,jPanel2,jPanel3;
	private JMenuItem enqueue,dequeue,first,size,toString,isEmpty,exit;
	CircularArrayQueue<String>queue1 =new CircularArrayQueue<String>();
	LinkedQueue<String> queue2=new LinkedQueue<String>();


/*	public static void main(String[] args) {
		Frame world = new Frame();
		world.run();
	}
*/

	public void run(){
		frame =new JFrame("队列操作演示——尚若冰");
		jLabel1=new JLabel("输入元素");
		jLabel2=new JLabel("输出内容");
		input=new JTextField(6);
		output=new JTextField(30);
		jRadioButton1=new JRadioButton("数组实现");
		jRadioButton1.setSelected(true);
		jRadioButton2=new JRadioButton("链表实现");

		ButtonGroup buttonGroup=new ButtonGroup();//实现单选按钮
		buttonGroup.add(jRadioButton1);
		buttonGroup.add(jRadioButton2);

		JMenuBar menubar =new JMenuBar();//设置队列操作
		JMenu menu=new JMenu("队列操作");
		enqueue= new JMenuItem("enqueue()");
		enqueue.addActionListener(this);
		dequeue = new JMenuItem("dequeue()");
		dequeue.addActionListener(this);
		first = new JMenuItem("first()");
		first.addActionListener(this);
		size = new JMenuItem("size()");
		size.addActionListener(this);
		toString =new JMenuItem("toString()");
		toString.addActionListener(this);
		isEmpty = new JMenuItem("isEmpty()");
		isEmpty.addActionListener(this);
		exit = new JMenuItem("退出");
		exit.addActionListener(this);
		menu.add(enqueue);
		menu.add(dequeue);
		menu.add(first);
		menu.add(size);
		menu.add(toString);
		menu.add(isEmpty);
		menu.addSeparator();
		menu.add(exit);


		menubar.add(menu);
		frame.setJMenuBar(menubar);

		frame.setLayout(new GridLayout(3,1));

		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();

		jPanel1.add(jLabel1);
		jPanel1.add(input);

		jPanel2.add(jLabel2);
		jPanel2.add(output);

		jPanel3.add(jRadioButton1);
		jPanel3.add(jRadioButton2);

		frame.add(jPanel1);
		frame.add(jPanel2);
		frame.add(jPanel3);
		frame.setSize(400,250);
		frame.setLocation(500,350);
		frame.setVisible(true);

	}



	public void actionPerformed(ActionEvent e){
		QueueADT<String> queue;
		//LinkedQueue<String> queue1=new LinkedQueue<>();

		//CircularArrayQueue<String>queue2 =new CircularArrayQueue<>();

		if(jRadioButton1.isSelected()==true)
			queue=queue1;
		else
			queue=queue2;
		JMenuItem mi=(JMenuItem)e.getSource();
		if(mi==exit){ //退出
			System.exit(0);
		}
		if(mi==enqueue){
			if(input.getText()!=null && input.getText().length()>0){
				queue.enqueue(input.getText());
				input.setText(null);
			}
		}
		if(mi==dequeue){
			try {
				output.setText(queue.dequeue().toString());
			} catch (EmptyCollectionException e1) {
				e1.printStackTrace();
			}
		}
		if(mi==first){
			try {
				output.setText(queue.first().toString());
			} catch (EmptyCollectionException e1) {
				e1.printStackTrace();
			}
		}
		if(mi==size){
			output.setText("size()="+queue.size());
		}
		if(mi==toString){
			output.setText(queue.toString());
		}
		if(mi==isEmpty){
			output.setText("isEmpty()="+queue.isEmpty());
		}
	}

}
