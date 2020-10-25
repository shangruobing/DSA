package Experiment_1;

public class TestA {
    public static void main (String args[]){
        int x;
        for(x=10;x<100;x++){
            if(Math.pow(x,2)%100==x)
                System.out.println(x+"的自守数是"+x*x);
        }
    }
}
