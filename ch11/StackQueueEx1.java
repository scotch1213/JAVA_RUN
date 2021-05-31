package ch11;

import java.util.*;

public class StackQueueEx1 {
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue qu = new LinkedList();

        st.push("0");
        st.push("1");
        st.push("2");
        st.push(0xff);

        qu.offer("0");
        qu.offer("1");
        qu.offer("2");
        qu.offer(0xff);

        
        System.out.println("= stack = ");
        System.out.println("= stack.size = "+st.size());
        while(!st.empty()){
            System.out.println(st.pop());
        }
        System.out.println();

        System.out.println("= queue = ");
        System.out.println("= queue.size = "+qu.size());
        while(!qu.isEmpty()){
            System.out.println(qu.poll());
        }

    }
}
