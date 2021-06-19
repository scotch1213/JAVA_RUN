package ch13;

public class ThreadEx10 implements Runnable{
    static boolean autoSave = false;
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadEx10());
        t.setDaemon(true);
        t.start();

        for(int i=1;i<=20;i++)
        {
            try{
                Thread.sleep(1000);                 //main Thread sleep for 1000ms
            }catch(InterruptedException e){}        //슬립 후, 쓰레드를 다시 동작시키기 위해서 인터럽트 호출(인터럽트 익셉션)
            
            System.out.println(i);

            if(i==5)
            {
                autoSave = true;
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    public void run(){
        System.out.println("run");
        while(true)
        {
            try{
                Thread.sleep(3*1000);
            }catch(InterruptedException e){}

            if(autoSave)
            {
                autoSave();
            }
        }
    }

    public void autoSave(){
        System.out.println("자동저장이 실행되었습니다.");
    }
}
