package Experiment_9;

import java.awt.*;
import java.awt.event.*;

public class TestLinkedList extends Frame implements ItemListener, ActionListener {
	private static final int TARGET=1;
	private static final int INSERT=2;
	private static final int DELETE=3;
	private static final int DISPLAY=4;
	private TextArea theArea;
	private CheckboxMenuItem check1,check2; //检查框菜单选项
	private MenuItem insert1,insert2,insert3,insert4;//增加操作的菜单选项
	private MenuItem remove1,remove2,remove3,exit; //删除操作的菜间选项
	//显示项
	private MenuItem display1,display2,display3,display4,display5;
	private Button bOK1,bOK2; //两种输入面板中的确定按纽
	private TextField tf1,tf2,tf3; //两种输入面板中的文本编辑对象
	private LinkedOrderedList<Integer> OList; //排序线性表
	private LinkedUnorderedList<Integer> UList; //未排序线性表
	private LinkedList<Integer> List; //线性表
	private int operation=0; //1到4代表:insert1到4,5代表remove3,6代表display5
	private Panel pen1,pen2;
	//构造函数 ,创建了窗口中的所有显示组件
	//注意创建的两个输入面板并未加入到窗口中
	public TestLinkedList(){
		this.setTitle("实验九 链表线性表测试--尚若冰");
		theArea = new TextArea(4,50); //创建文本显示框
		this.add(theArea,BorderLayout.CENTER); //加到窗口中
		MenuBar MBar = new MenuBar(); //创建菜单栏
		Menu Mtarget = buildMenu(TARGET); //创建菜单
		Menu MInsert = buildMenu(INSERT);
		Menu MDelete = buildMenu(DELETE);
		Menu MDisplay = buildMenu(DISPLAY);
		MBar.add(Mtarget); //将菜单加到菜单栏中
		MBar.add(MInsert);
		MBar.add(MDelete);
		MBar.add(MDisplay);
		pen1=new Panel(); //创建输入一个数的面板
		Label lb1=new Label("输入整数"); //下面为面板中的对象
		tf1=new TextField(10);
		bOK1 = new Button("确定");
		bOK1.addActionListener(this); //注册监听程序
		pen1.add(lb1); //将对象加入面板中
		pen1.add(tf1);
		pen1.add(bOK1);
		pen2 = new Panel(); //创建输入两个数的面板
		Label lb2=new Label("输入整数");
		tf2=new TextField(10);
		bOK2 = new Button("确定");
		bOK2.addActionListener(this); //注册监听程序
		Label lb3= new Label("指定的整数");
		tf3= new TextField(10);
		pen2.add(lb2);
		pen2.add(tf2);
		pen2.add(lb3);
		pen2.add(tf3);
		pen2.add(bOK2);
		this.setMenuBar(MBar); //窗口中设置菜单栏,否则无菜单
		OList = new LinkedOrderedList<Integer>();
		UList = new LinkedUnorderedList<Integer>();
		List=OList;
	}
	public static void main(String[] args){
		TestLinkedList world= new TestLinkedList();
		world.pack();
		world.addWindowListener(new CloseQuit());
		world.setVisible(true);
		world.setLocation(400,350);
	}

	private static class CloseQuit extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	//创建菜单
	private Menu buildMenu(int menu){
		Menu result=null;
		switch(menu){
			case TARGET: //选择线性表
				result= new Menu("操作");
				check1=new CheckboxMenuItem("排序线性表",true);
				check1.addItemListener(this);
				check2 = new CheckboxMenuItem("未排序线性表",false);
				check2.addItemListener(this);
				result.add(check1);
				result.add(check2);
				result.addSeparator();
				exit=new MenuItem("退出");
				exit.addActionListener(this);
				result.add(exit);
				break;
			case INSERT: //插入
				result = new Menu("增加");
				insert1=new MenuItem("增加数据");
				insert1.addActionListener(this);
				insert2=new MenuItem("增加到表头");
				insert2.addActionListener(this);
				insert2.setEnabled(false);
				insert3=new MenuItem("增加到表尾");
				insert3.addActionListener(this);
				insert3.setEnabled(false);
				insert4=new MenuItem("增加到指定元素后");
				insert4.addActionListener(this);
				insert4.setEnabled(false);
				result.add(insert1);
				result.add(insert2);
				result.add(insert3);
				result.add(insert4);
				break;
			case DELETE: //删除
				result = new Menu("删除");
				remove1 = new MenuItem("头节点");
				remove1.addActionListener(this);
				remove2 = new MenuItem("尾节点");
				remove2.addActionListener(this);
				remove3 = new MenuItem("指定元素节点");
				remove3.addActionListener(this);
				result.add(remove1);
				result.add(remove2);
				result.add(remove3);
				break;
			case DISPLAY: //显示
				result = new Menu("显示");
				display1=new MenuItem("线性表内容");
				display1.addActionListener(this);
				display2=new MenuItem("头节点");
				display2.addActionListener(this);
				display3=new MenuItem("尾节点");
				display3.addActionListener(this);
				display4=new MenuItem("节点数");
				display4.addActionListener(this);
				display5=new MenuItem("是否包函某元素");
				display5.addActionListener(this);
				result.add(display1);
				result.add(display2);
				result.add(display3);
				result.add(display4);
				result.add(display5);
		}
		return result;
	}
	//Item 事件监听处理程序, 处理选择排序或未排序线性表事件
	public void itemStateChanged(ItemEvent e) {
		CheckboxMenuItem cbm=(CheckboxMenuItem)e.getSource();
		if(cbm==check1) //两种线性表同一时刻只能选一种
			check2.setState(!check1.getState());
		else if (cbm==check2);
		check1.setState(!check2.getState());
		if (check1.getState())
		{ List=OList; //设置选择排序线性表可进行的操作
			insert1.setEnabled(true);
			insert2.setEnabled(false);
			insert3.setEnabled(false);
			insert4.setEnabled(false);
		}else
		{ List=UList; //设置选择排序线性表可进行的操作
			insert1.setEnabled(false);
			insert2.setEnabled(true);
			insert3.setEnabled(true);
			insert4.setEnabled(true);
		}
	}
	//Action事件监听处理程序,处理其它菜单项及按纽事件
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof MenuItem) //点击菜单命令项
		{ MenuItem mi=(MenuItem)e.getSource();
			if(mi==exit){ //退出
				System.exit(0);
			}
			//需要使用一个整数输入面板的菜单项

			if(mi==insert1||mi==insert2||mi==insert3||mi==remove3||mi==display5){
				this.removeAll(); // 删除窗口中所有对象
				this.add(theArea,BorderLayout.CENTER); //重加入文本显示框
				this.add(pen1,BorderLayout.SOUTH); //加入一个数的输入面板
				this.pack();
			}
			//用operation记录当前的操作,以便后续处理
			if(mi==insert1) operation=1;
			if(mi==insert2) operation=2;
			if(mi==insert3) operation=3;
			if(mi==remove3) operation=5;
			if(mi==display5) operation=6;
			//需要使用两个整数输入面板的菜单项
			if(mi==insert4){ //增加到指元素后
				operation=4;
				this.removeAll(); // 删除窗口中所有对象
				this.add(theArea,BorderLayout.CENTER); //重加入文本显示框
				this.add(pen2,BorderLayout.SOUTH); //加入两个数的输入面板
				this.pack();
			}
			if(mi==remove1){ //删除头节点
				if(!List.isEmpty()) {
					try {
						List.removeFirst();
					} catch (EmptyCollectionException emptyCollectionException) {
						emptyCollectionException.printStackTrace();
					}
				}
			}
			if(mi==remove2){ //删除尾节点
				if(!List.isEmpty()) {
					List.removeLast();
				}
			}
			if(mi==display1){ //显示线性表内容
				theArea.append(List.toString()+"\n");
			}
			if(mi==display2){ //显示头节点
				theArea.append("头节点为"+List.first().toString()+"\n");
			}
			if(mi==display3){ //显示尾节点
				theArea.append("尾节点为"+List.last().toString()+"\n");
			}
			if(mi==display4){ //显示线性表中节点数
				theArea.append("节点数为"+List.size()+"\n");
			}
		}
		if(e.getSource() instanceof Button){ //点击确定按纽事件
			Button bt=(Button) e.getSource();
			if(bt==bOK1){ //输入一个整数面板的确定按纽,先获取整数data
				Integer data=(Integer.parseInt(tf1.getText()));
				switch(operation)
				{
					case 1: // 增加
						OList.add(data);
						break;
					case 2: // 增加到表头
						UList.addToFront(data);
						break;
					case 3: // 增加到表尾
						UList.addToRear(data);
						break;
					case 5: // 删除指定元素节点
						try {
							List.remove(data);
						} catch (ElementNotFoundException | EmptyCollectionException e1) {
							e1.printStackTrace();
						}
						break;
					case 6: // 显示是否包含某元素
						if(List.contains(data))
							theArea.append("线性表包含"+tf1.getText()+"\n");
						else
							theArea.append("线性表不包含"+tf1.getText()+"\n");
				}
			}
			if(bt==bOK2){ //输入两个整数面板的确定按纽
				Integer data1=(Integer.parseInt(tf2.getText()));
				Integer data2=(Integer.parseInt(tf3.getText()));
				try {
					UList.addAfter(data1, data2);
				} catch (ElementNotFoundException elementNotFoundException) {
					elementNotFoundException.printStackTrace();
				}
			}
			//处理后,删除输入面板
			this.removeAll();
			this.add(theArea,BorderLayout.CENTER);
			this.pack();
		}
	}
}