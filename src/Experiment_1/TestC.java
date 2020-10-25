package Experiment_1;
import java.util.Scanner;
public class TestC{
    public static void main(String args[]){

        int a,b,c;
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入a");
        a=scan.nextInt();
        System.out.println("请输入b");
        b=scan.nextInt();
        System.out.println("请输入c");
        c=scan.nextInt();

        double delta=b*b-4*a*c;
        float r1,r2,r,im;
        if(delta>=0) {
            r1 = (float)(-b+Math.sqrt(delta))/(2*a);
            r2 = (float)(-b-Math.sqrt(delta))/(2*a);
            System.out.println("该方程的解为"+r1+"和"+r2);
        }
        else {
            r = -b/(2*a);
            im = (float)Math.sqrt(-delta)/(2*a);
            System.out.println("该方程的解为"+r+"+"+im+"i"+"和"+r+"-"+im+"i");
        }
    }
}
