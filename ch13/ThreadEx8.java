package ch13;

public class ThreadEx8 {
    public static void main(String[] args) {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();

        //set the Thread priority
        th1.setPriority(3);         //priority가 낮을수록 차선 순위.
        th2.setPriority(7);         //priority가 높을수록 우선 순위.

        System.out.println("th1.priority :"+th1.getPriority());
        System.out.println("th2.priority :"+th2.getPriority());

        th1.start();
        th2.start();
    }
}

class ThreadEx8_1 extends Thread{
    public void run(){
        for(int i=0;i<300;i++)
        {
            System.out.print("-");
            for(int x=0;x<10000000;x++)
            {
            }
        }
        System.out.println("th1.end");
    }
}

class ThreadEx8_2 extends Thread{
    public void run(){
        for(int i=0;i<300;i++)
        {
            System.out.print("|");
            for(int x=0;x<10000000;x++)
            {
            }
        }
        System.out.println("th2.end");
    }
}
