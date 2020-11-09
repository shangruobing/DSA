package Experiment_8;

public class EmptyCollectionException extends Exception{
	private String detail;
	public EmptyCollectionException(String a){
		detail=a;
	}
	public String toString(){
		return "数据集"+detail+"为空";
	}

}
