package Experiment_1;
public class TestVariable {
	public static void main(String[] args) {
		short sa;  //定义短整型变量sa
		int ia;    //定义整型变量ia
		float fa;  //定义浮点数变量fa
		char ca;   //定义字符变量ca
		//分别给变量赋值
		sa=100;
		ia=32760; 
		fa=35.55f;
		ca='A';
		System.out.println("变量sa="+sa+" ia=" +ia+" fa="+ fa+" ca=" + ca);
		//改变变量的值并输出
		while(ia<32770){
			ia=ia+1; 
			ca=(char)((int)ca+1);
			sa=(short)ia;
			if(sa==32767) //short的范围 -32768~32767
				System.out.println("执行次数为"+(sa-32760+1)+"时sa变为负数");
		}
        System.out.println("变量sa="+sa+" ia=" +ia+" fa="+ fa+" ca=" + ca);
	}
}
