package Experiment_1;

public class TestB {
    public static void main(String args[]){
        int i,j,k;
        for(i=1;i<10;i++)
            for (j=1;j<10;j++)
                for (k=1;k<10;k++)
                    if(i*100+j*10+k==Math.pow(i,3)+Math.pow(j,3)+Math.pow(k,3))
                        System.out.println(i*100+j*10+k);
    }
}
