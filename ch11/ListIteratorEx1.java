package ch11;

import java.util.*;

public class ListIteratorEx1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("list size :"+list.size());
        System.out.println("list :"+list);

        ListIterator<String> it = list.listIterator();          // ListIterator는 앞뒤로 자유롭게 움직일 수 있음.

        while(it.hasNext())
        {
            System.out.print("Next index : "+it.nextIndex()+", ");
            System.out.print("Next index value : "+it.next());
            System.out.println();
        }
        System.out.println();

        while(it.hasPrevious())
        {
            System.out.print("prev index : "+it.previousIndex()+", ");
            System.out.print("prev index value : "+it.previous());
            System.out.println();
        }
        System.out.println();

    }
}
