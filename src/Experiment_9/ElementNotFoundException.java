package Experiment_9;
public class ElementNotFoundException extends Exception{
	private String detail;
	public ElementNotFoundException(String a){
		detail=a;
	}
	public String toString(){
		return "数据集"+detail+"没有要找的元素";
	}

}
