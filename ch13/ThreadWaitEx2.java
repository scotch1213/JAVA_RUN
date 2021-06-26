package ch13;

import java.util.ArrayList;

public class ThreadWaitEx2 {
    public static void main(String[] args) throws Exception {
        Table2 table = new Table2();

        new Thread(new Cook2(table), "COOK1").start();                       // 테이블에 음식을 생성.
        new Thread(new Customer2(table, "donut"),"CUST1").start();           //손님 1은 도넛
        new Thread(new Customer2(table, "burger"),"CUST2").start();          //손님 2는 버거를 먹음.
    
        Thread.sleep(5000);
        System.exit(0);
    }
}

class Customer2 implements Runnable{
    private Table2 table;
    private String food;

    Customer2(Table2 table, String food)
    {
        this.table = table;
        this.food = food;
    }

    public void run()
    {
        while(true){
            try{ Thread.sleep(10); }catch(InterruptedException e){}
            String name = Thread.currentThread().getName();

            if(eatfood() == true)
            {
                System.out.println(name + " ate a "+food);
            }
            else{
                System.out.println(name + " failed to eat. :(");
            }
        }
    }
    boolean eatfood(){return table.remove(food);}
}

class Cook2 implements Runnable{
    private Table2 table;
    Cook2(Table2 table){this.table = table;}

    public void run(){
        while(true){
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);

            try{ Thread.sleep(100); }catch(InterruptedException e){}
        }
    }
}

class Table2 {
    String[] dishNames = {"donut","donut","burger"};
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<String>();

    public synchronized void add(String dish){
        if(dishes.size()>=MAX_FOOD)
        {
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes : "+dishes.toString());
    }

    public boolean remove(String dishName){
        synchronized(this){
            while(dishes.size()==0)                     // 음식이 비었을 때, Lock이 걸려서, 기다리게 된다.
            {
                String name = Thread.currentThread().getName();
                System.out.println(name+" is waiting.");
                try{Thread.sleep(500);}catch(InterruptedException e){}
            }

            for(int i=0;i<dishes.size();i++){
                if(dishName.equals(dishes.get(i)))
                {
                    dishes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public int dishNum(){return dishNames.length;}
}


