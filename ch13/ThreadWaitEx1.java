package ch13;

import  java.util.ArrayList;

// 테이블에 음식을 생성하는 Cook Thread의 table.add()와
// 테이블에 음식을 제거하는 Customer thread의 table.remove()가
// 동시에 접근하게 되면 예외처리가 발생하게 된다.
// ex) 
// Exception in thread "COOK1" CUST2 ate a burger
// java.util.ConcurrentModificationException
public class ThreadWaitEx1 {
    public static void main(String[] args) throws Exception {
        Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();                       // 테이블에 음식을 생성.
        new Thread(new Customer(table, "donut"),"CUST1").start();           //손님 1은 도넛
        new Thread(new Customer(table, "burger"),"CUST2").start();          //손님 2는 버거를 먹음.
    
        Thread.sleep(100);
        System.exit(0);
    }
}

class Customer implements Runnable{
    private Table table;
    private String food;

    Customer(Table table, String food)
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

class Cook implements Runnable{
    private Table table;
    Cook(Table table){this.table = table;}

    public void run(){
        while(true){
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);

            try{ Thread.sleep(1); }catch(InterruptedException e){}
        }
    }
}

class Table {
    String[] dishNames = {"donut","donut","burger"};
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<String>();

    public void add(String dish){
        if(dishes.size()>=MAX_FOOD)
        {
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes : "+dishes.toString());
    }

    public boolean remove(String dishName){
        for(int i=0;i<dishes.size();i++){
            if(dishName.equals(dishes.get(i)))
            {
                dishes.remove(i);
                return true;
            }
        }
        return false;
    }

    public int dishNum(){return dishNames.length;}
}


