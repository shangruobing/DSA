public void actionPerformed(ActionEvent e){
	QueueADT queue;
	if(cbg.getSelectedCheckbox()==cbArray)
		queue=queue1;   //�ڶ��е������ж������ԣ�queue1��������ʵ�ֶ���
	else queue=queue2;      //queue2��������ʵ�ֶ��� 
	if(e.getSource()==bEnqueue && input.getText()!=null) 
		queue.enqueue(input.getText()); //bEnqueueΪ���Ӱ�Ŧ���ʽ��Ӳ���
	if(e.getSource()==bDequeue)            //bDequeueΪ���Ӱ�Ŧ
		try {
			queue.dequeue();                 //���Ӳ���
		} catch (EmptyCollectionException e1) {
			e1.printStackTrace();
		}
	output.setText(queue.toString());   //��ʾ��������
}

