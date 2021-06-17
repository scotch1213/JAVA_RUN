package ch13;

public class ThreadEx5 {
    static long start_time =0;
    public static void main(String[] args) {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();
        start_time = System.currentTimeMillis();

        for(int i =0;i<300;i++)
        {
            System.out.printf("%s","*");
        }
        long end_time = System.currentTimeMillis();
        System.out.println("소요시간 : "+(end_time-ThreadEx5.start_time+"ms"));

    }
}

class ThreadEx5_1 extends Thread{
    public void run(){
        for(int i =0;i<300;i++)
        {
            System.out.printf("%s","-");
        }
        long end_time2 = System.currentTimeMillis();
        System.out.println("소요시간 : "+(end_time2-ThreadEx5.start_time+"ms"));
    }
}
