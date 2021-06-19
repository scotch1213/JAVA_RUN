package ch13;

import javax.swing.JOptionPane;

public class ThreadEx14 {
    public static void main(String[] args) {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
        System.out.println("입력한 값은 " + input + " 입니다.");
        th1.interrupt();
        System.out.println("th1.interrupt() : "+th1.isInterrupted());
    }
}

class ThreadEx14_1 extends Thread{
    public void run(){
        int i = 10;
        while((i !=0) && (!isInterrupted()))           //패널 입력 후, 인터럽트 동작하면 While문 탈출.
        {
            System.out.println(i--);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e)               //슬립 후, 인터럽트 익셉션 발생. 인터럽트 익셉션 발생 후 false 초기화.
            {
                interrupt();                            // 때문에 인터럽트를 다시 설정해줘야 한다.
            }
        }
    }
    
}
