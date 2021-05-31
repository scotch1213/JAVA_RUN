package ch11;

import java.util.*;

public class ArrayListLinkedListTest2 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList(1000000);
        LinkedList ll = new LinkedList();

        System.out.println("al.size = "+al.size());
        System.out.println("ll.size = "+ll.size());
        add(al);
        add(ll);
        System.out.println("al.size = "+al.size());
        System.out.println("ll.size = "+ll.size());

        System.out.println("== 접근시간 테스트 ==");
        System.out.println("ArrayList 접근 시간 :"+access(al));
        System.out.println("Linked 접근 시간 :"+access(ll));

    }

    public static long access(List list){
        long start = System.currentTimeMillis();
        for(int i=0;i<list.size();i++)
        {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

    public static void add(List list){
        for(int i=0; i<100000; i++)
        {
            list.add(i+"");
        }
    }
}
