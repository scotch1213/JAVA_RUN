package ch13;

import javax.swing.text.html.HTMLDocument.RunElement;

public class ThreadEx1 {
    public static void main(String[] args) {
        ThreadEx1_1 t1 = new ThreadEx1_1();         // Thread의 자손 클래스의 인스턴스를 생성.

        Runnable r = new ThreadEx1_2();             // Runnable을 구현한 클래스의 인스턴스 생성.
        Thread t2 = new Thread(r);                  // 생성자 쓰레드

        ThreadEx1_3 t3 = new ThreadEx1_3();

        //쓰레드 실행. 실행순서는 스케줄러에 의존.
        t1.start();     //쓰레드 실행을 위해 쓰레드의 스택 생성, 다돌면 스택 사라짐.
        t2.start();
        t3.start();
        
        //t1 쓰레드가 다 종료된 이후, 다시 쓰레드를 실행하려 하면, 안됨.
        t1 = new ThreadEx1_1();   
        t1.start(); 

    }
}

class ThreadEx1_1 extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("ThreadEx1_1 : "+getName());     //쓰레드 번호 리턴.
        }
    }
}

class ThreadEx1_3 extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("ThreadEx1_3 : "+getName());
        }
    }
}

class ThreadEx1_2 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++)
        {
            // Thread.currentThread();
            System.out.println("ThreadEx1_2 : "+Thread.currentThread().getName());
        }
    }
}


