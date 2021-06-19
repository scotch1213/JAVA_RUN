package ch13;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthDesktopIconUI;

public class ThreadEx13 {
    public static void main(String[] args) {
        ThreadEx13_1 th1 = new ThreadEx13_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
        System.out.println("입력한 값은 " + input + " 입니다.");
        th1.interrupt();
        System.out.println("th1.interrupt() : "+th1.isInterrupted());
    }
}

class ThreadEx13_1 extends Thread{
    public void run()
    {
        int i = 50000;
        while((i !=0) && (!isInterrupted()))           //패널 입력 후, 인터럽트 동작하면 While문 탈출.
        {
            System.out.println(i--);
            for(long x=0;x<250000000L;x++)
            {}
        }
    }
}