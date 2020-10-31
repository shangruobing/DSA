public void actionPerformed(ActionEvent e){
	QueueADT queue;
	if(cbg.getSelectedCheckbox()==cbArray)
		queue=queue1;   //在队列调试类中定义属性，queue1引用数组实现对象
	else queue=queue2;      //queue2引用链表实现对象 
	if(e.getSource()==bEnqueue && input.getText()!=null) 
		queue.enqueue(input.getText()); //bEnqueue为进队按纽，故进队操作
	if(e.getSource()==bDequeue)            //bDequeue为出队按纽
		try {
			queue.dequeue();                 //出队操作
		} catch (EmptyCollectionException e1) {
			e1.printStackTrace();
		}
	output.setText(queue.toString());   //显示队中内容
}

