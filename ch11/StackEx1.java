package ch11;

import java.util.*;

public class StackEx1 {
    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    public static void goURL(String url){
        back.push(url);
        if(!forward.empty())
        {
            forward.clear();
        }
    }

    public static void goForward(){
        if(!forward.empty())
        {
            back.push(forward.pop());
        }
    }

    public static void goBack(){
        if(!back.empty())
        {
            forward.push(back.pop());
        }
    }

    public static void printStatus(){
        System.out.println("back:"+back);
        System.out.println("forward:"+forward);
        System.out.println("current:"+back.peek());
        System.out.println();

    }
    public static void main(String[] args) {
        goURL("1.네이트");
        printStatus();
        goURL("2.네이버");
        printStatus();
        goURL("3.다음");
        printStatus();
        goURL("4.구글");
        printStatus();

        goBack();
        System.out.println("-- after goBack --");
        printStatus();
        
        goBack();
        System.out.println("-- after goBack --");
        printStatus();
        
        goForward();
        System.out.println("-- after goForward --");
        printStatus();

        goURL("카카오.");
        System.out.println("-- goURL(카카오.) --");
        printStatus();

    }
}
