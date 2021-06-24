package ch13;

public class ThreadEx22 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx22();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account_for_EX22 {
    private int balance = 1000;

    public int getBalance(){
        return balance;
    }

    //출금하는 함수를 하나의 쓰레드만 접근 가능하도록 설정.
    public synchronized void withdraw(int money){
        if(balance >= money){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
            balance -= money;
        }
    }   //withdraw;
}

class RunnableEx22 implements Runnable{
    Account_for_EX22 acc = new Account_for_EX22();
    
    public void run(){
        while(acc.getBalance() > 0){
            // 100, 200, 300중 한값을 임의로 선택해서 출금.
            int money = (int)(Math.random()*3+1)*100;
            // Thread에서 WithDraw로 잔고에서 출금하려는 사이, 다른 쓰레드에서도 출금하면, 마이너스가 발생할 수 있다.
            // Thread끼리 자원을 동시에 점유해서 문제가 되는 케이스
            acc.withdraw(money);                
            System.out.println("Balance : "+acc.getBalance());
        }
    }
}
