package ch13;

import java.util.*;

public class ThreadWaitEx3 {
    
    public static void main(String[] args) throws Exception {
        Table3 table = new Table3();

        new Thread(new Cook3(table), "COOK1").start();                       // 테이블에 음식을 생성.
        new Thread(new Customer3(table, "donut"),"CUST1").start();           //손님 1은 도넛
        new Thread(new Customer3(table, "burger"),"CUST2").start();          //손님 2는 버거를 먹음.
    
        Thread.sleep(5000);
        System.exit(0);
    }
}

class Customer3 implements Runnable{
    private Table3 table;
    private String food;

    Customer3(Table3 table, String food)
    {
        this.table = table;
        this.food = food;
    }

    public void run()
    {
        while(true){
            try{ Thread.sleep(100); }catch(InterruptedException e){}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a "+food);
        }
    }
}

class Cook3 implements Runnable{
    private Table3 table;
    Cook3(Table3 table){this.table = table;}

    public void run(){
        while(true){
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);

            try{ Thread.sleep(10); }catch(InterruptedException e){}
        }
    }
}

class Table3 {
    String[] dishNames = {"donut","donut","burger"};
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<String>();

    public synchronized void add(String dish){
        while(dishes.size()>=MAX_FOOD)
        {
            String name = Thread.currentThread().getName();
            System.out.println(name+" is waiting.");
            try{
                wait();                 //Cook 쓰레드 락 해제.
                Thread.sleep(500);
            }catch(InterruptedException e){}
        }
        dishes.add(dish);
        notify();                       //Cust 쓰레드에 알림.
        System.out.println("Dishes : "+dishes.toString());
    }

    public void remove(String dishName){
        synchronized(this){
            String name = Thread.currentThread().getName();
            while(dishes.size()==0)                     // 음식이 비었을 때, Lock이 걸려서, 기다리게 된다.
            {
                System.out.println(name+" is waiting.");
                try{
                    wait();
                    Thread.sleep(500);
                }catch(InterruptedException e){}
            }

            while(true){
                for(int i=0;i<dishes.size();i++){
                    if(dishName.equals(dishes.get(i)))
                    {
                        dishes.remove(i);
                        notify();       //Cook에게 알림.
                        return;
                    }
                }

                try{
                    System.out.println(name+" is waiting.");
                    wait();
                    Thread.sleep(500);
                }catch(InterruptedException e){}
            }
        }
    }

    public int dishNum(){return dishNames.length;}
}


