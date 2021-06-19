package ch13;

public class ThreadEx12 {
    public static void main(String[] args) {
        ThreadEx12_1 th1 = new ThreadEx12_1();
        ThreadEx12_2 th2 = new ThreadEx12_2();

        th1.start();
        th2.start();

        try{
            th1.sleep(1000);                        //th1이 아닌, main thread가 멈춘다.
        }catch(InterruptedException e){}

        System.out.println("main thread 종료.");
    }
}

class ThreadEx12_1 extends Thread{
    public void run(){
        for(int i=0;i<300;i++){
            System.out.print("-");
        }
        System.out.println("Thread1 종료");
    }
}

class ThreadEx12_2 extends Thread{
    public void run(){
        for(int i=0;i<300;i++){
            System.out.print("+");
        }
        System.out.println("Thread2 종료");
    }
}