package ch13;

public class ThreadEx20 {
    public static void main(String[] args) {
        ThreadEx20_1 gc = new ThreadEx20_1();
        gc.setDaemon(true);
        gc.start();

        int required_memory;
        for(int i=0; i<20; i++)
        {
            required_memory = (int)(Math.random()*10)*20;
            System.out.println("required_memory : "+required_memory);
            if((gc.free_memory() < required_memory)||(gc.free_memory()<400)){
                System.out.println("need more memory!!");
                gc.interrupt();
                try{
                    gc.join(1000);
                }catch(InterruptedException e){}
            }
            gc.usedMemory +=required_memory;
            System.out.printf("[%d] total memory, used Memory, freeMemory = %d, %d, %d\n",i,gc.total_memory(),gc.usedMemory,gc.free_memory());
        }
    }
}

class ThreadEx20_1 extends Thread{
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    public void run(){
        while(true)
        {
            try{
                Thread.sleep(10*1000);
            }catch(InterruptedException e){
                System.out.println("awaken by Interrupt().");
            }
            
            gc();
            System.out.println("Garbage Collected, FreeMemory : "+ free_memory());
        }
    }

    public void gc(){
        usedMemory -= 300;
        if(usedMemory < 0)
        {
            usedMemory = 0;
        }
    }

    public int total_memory(){  return MAX_MEMORY;}
    public int free_memory(){  return MAX_MEMORY-usedMemory;}

}