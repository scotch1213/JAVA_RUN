package ch13;

public class ThreadEx18 {
    public static void main(String[] args) {
        ThreadEx18_1 th1 = new ThreadEx18_1("*");
        ThreadEx18_1 th2 = new ThreadEx18_1("**");
        ThreadEx18_1 th3 = new ThreadEx18_1("***");

        th1.start();
        th2.start();
        th3.start();

        try{
            Thread.sleep(2000);
            th1.suspended();
            Thread.sleep(2000);
            th2.suspended();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stopped();
            th2.stopped();
            Thread.sleep(2000);
            th3.stopped();
        }catch(InterruptedException e){}

    }
}

class ThreadEx18_1 implements Runnable{
    boolean suspended = false;
    boolean stopped   = false;

    Thread th;

    ThreadEx18_1(String name)
    {
        th = new Thread(this, name);
    }

    public void run(){
        String name = th.getName();

        while(!stopped)
        {
            if(!suspended)
            {
                System.out.println("thread "+name);
                try{
                    Thread.sleep(1000);
                    // System.out.println("thread "+name + "sleep");
                }catch(InterruptedException e){
                    System.out.println(name + " - Interrupted");
                }
            }
            else{
                Thread.yield();         //suspended일 때, Busy Wating 삭제.
            }
        }
        System.out.println(name + " - stopped");
    }

    public void stopped(){
        stopped = true;
        th.interrupt();
        System.out.println(th.getName() + " - stopped by interrupt");
    }

    public void suspended()
    {
        suspended = true;
        th.interrupt();
        System.out.println(th.getName() + " - suspended by interrupt");
    }

    public void start(){th.start();}
    public void resume(){suspended = false;}

}