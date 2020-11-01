package Experiment_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener{
	private JFrame frame;
	private JLabel jLabel1,jLabel2;
	private JTextField input,output;
	private JPanel jPanel1,jPanel2;
	private JMenuItem push,pop,peek,size,toString,isEmpty,exit;
	StackADT<String> stack;

	public void run(){
		stack =new ArrayStack<String>();
		frame =new JFrame("栈操作演示——尚若冰");

		jLabel1=new JLabel("输入元素");
		jLabel2=new JLabel("输出内容");
		input=new JTextField(6);
		output=new JTextField(30);


		JMenuBar menubar =new JMenuBar();//设置队列操作
		JMenu menu=new JMenu("栈操作");
		push= new JMenuItem("push()");
		push.addActionListener(this);
		pop = new JMenuItem("pop()");
		pop.addActionListener(this);
		peek = new JMenuItem("peek()");
		peek.addActionListener(this);
		size = new JMenuItem("size()");
		size.addActionListener(this);
		toString =new JMenuItem("toString()");
		toString.addActionListener(this);
		isEmpty = new JMenuItem("isEmpty()");
		isEmpty.addActionListener(this);
		exit = new JMenuItem("退出");
		exit.addActionListener(this);
		menu.add(push);
		menu.add(pop);
		menu.add(peek);
		menu.add(size);
		menu.add(toString);
		menu.add(isEmpty);
		menu.addSeparator();
		menu.add(exit);


		menubar.add(menu);
		frame.setJMenuBar(menubar);

		frame.setLayout(new GridLayout(2,1));

		jPanel1 = new JPanel();
		jPanel2 = new JPanel();

		jPanel1.add(jLabel1);
		jPanel1.add(input);

		jPanel2.add(jLabel2);
		jPanel2.add(output);



		frame.add(jPanel1);
		frame.add(jPanel2);

		frame.setSize(400,250);
		frame.setLocation(500,350);
		frame.setVisible(true);

	}



	public void actionPerformed(ActionEvent e){

		//LinkedQueue<String> queue1=new LinkedQueue<>();

		//CircularArrayQueue<String>queue2 =new CircularArrayQueue<>();

		JMenuItem mi=(JMenuItem)e.getSource();
		if(mi==exit){ //退出
			System.exit(0);
		}
		if(mi==push){
			if(input.getText()!=null && input.getText().length()>0){
				stack.push(input.getText());
				input.setText(null);
			}
		}
		if(mi==pop){
			try {
				output.setText(stack.pop().toString());
			} catch (Experiment_5.EmptyCollectionException e1) {
				e1.printStackTrace();
			}
		}
		if(mi==peek){
			try {
				output.setText(stack.peek().toString());
			} catch (EmptyCollectionException e1) {
				e1.printStackTrace();
			}
		}
		if(mi==size){
			output.setText("size()="+stack.size());
		}
		if(mi==toString){
			output.setText(stack.toString());
		}
		if(mi==isEmpty){
			output.setText("isEmpty()="+stack.isEmpty());
		}
	}
}
