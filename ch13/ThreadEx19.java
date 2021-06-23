package ch13;

public class ThreadEx19 {
    static long start_time = 0;
    public static void main(String[] args) {
        ThreadEx19_1 th1 = new ThreadEx19_1();
        ThreadEx19_2 th2 = new ThreadEx19_2();
        
        start_time = System.currentTimeMillis();
        th1.start();
        th2.start();


        try{
            th1.join();             //main thread가 th1 스레드가 끝날때까지 기다리게 함.
            th2.join();             //main thread가 th2 스레드가 끝날때까지 기다리게 함.
        }
        catch(InterruptedException e){
        }

        System.out.println("소요시간 : "+(System.currentTimeMillis()-start_time));
        
    }
}

class ThreadEx19_1 extends Thread{
    public void run(){
        for(int i=0;i<300;i++){
            System.out.print("-");
        }
    }
}

class ThreadEx19_2 extends Thread{
    public void run(){
        for(int i=0;i<300;i++){
            System.out.print("|");
        }
    }
}
