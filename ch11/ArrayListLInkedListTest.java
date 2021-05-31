package ch11;

import java.util.*;

public class ArrayListLInkedListTest {
    public static void main(String[] args) {
        ArrayList al = new ArrayList(2000000);
        LinkedList ll = new LinkedList();

        System.out.println("순차적으로 추가하기");
        System.out.println("Array List spend time= "+add1(al)+"ms");
        System.out.println("Linked List spend time= "+add1(ll)+"ms");
        // System.out.println("Array List = "+al);
        // System.out.println("Linked List = "+ll);
        System.out.println();

        System.out.println("중간에 추가하기");
        System.out.println("Array List spend time= "+add2(al)+"ms");
        System.out.println("Linked List spend time= "+add2(ll)+"ms");
        // System.out.println("Array List = "+al);
        // System.out.println("Linked List = "+ll);

        System.out.println("중간에 삭제하기");
        System.out.println("Array List spend time= "+remove2(al)+"ms");
        System.out.println("Linked List spend time= "+remove2(ll)+"ms");
        
        System.out.println("순차적으로 삭제하기");
        System.out.println("Array List spend time= "+remove1(al)+"ms");
        System.out.println("Linked List spend time= "+remove1(ll)+"ms");

    }

    public static long add1(List list){
        long start = System.currentTimeMillis();
        for(int i=0;i<1000000;i++)
        {
            list.add(i+"");
        }
        long end = System.currentTimeMillis();
        return end-start;
    }
    
    public static long add2(List list){
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++)
        {
            list.add(500,"X");
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

    public static long remove1(List list){
        long start = System.currentTimeMillis();
        for(int i=list.size()-1;i>=0;i--)
        {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

    public static long remove2(List list){
        long start = System.currentTimeMillis();
        for(int i=1000;i<10000;i++)
        {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end-start;
    }
}
