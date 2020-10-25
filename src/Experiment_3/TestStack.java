package Experiment_3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestStack implements ActionListener{
	JFrame f;
	JTextField input,output;
	JMenuItem push,pop,peek,size,toString,isEmpty,exit;
	StackADT<String> stack;
	public static void main(String[] args) {
		TestStack application = new TestStack();
		application.go();
	}
	public void go(){
		stack = new ArrayStack<String>();
		f=new JFrame("栈操作演示");
		//创建栈操作菜单
		JMenuBar menubar =new JMenuBar();
		JMenu menu= new JMenu("栈操作");
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
		f.setJMenuBar(menubar);
		//创建窗口屏幕上的对象
		f.setLayout(new GridLayout(4,1,10,10));//网格布局
		Label lInput = new Label("输入元素");
		Label lOutput = new Label("输出内容");
		Label lSpace = new Label("");
		input = new JTextField(5);
		output= new JTextField(30);
		Panel pan1 = new Panel();
		Panel pan2 = new Panel();
		pan1.add(lInput);
		pan1.add(input);
		pan2.add(lOutput);
		pan2.add(output);
		f.add(lSpace);
		f.add(pan1);
		f.add(pan2);
		f.pack();
		f.setVisible(true);
		f.setLocation(500,350);
	}
	public void actionPerformed(ActionEvent e){
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
			} catch (EmptyCollectionException e1) {
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