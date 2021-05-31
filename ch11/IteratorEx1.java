package ch11;

import java.util.*;

public class IteratorEx1{
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        al.add(5);
        al.add(3);
        al.add(1);
        al.add(2);
        al.add(4);

        System.out.println("al : "+al);  // ArrayList print.

        Iterator<Integer> al_it = al.iterator();
        int wh_cnt=0;
        while(al_it.hasNext()){         //means Iterator has more index? true : false
            System.out.println("while cnt : "+wh_cnt);
            System.out.println("it_index["+wh_cnt+"] = "+al_it.next());
            System.out.println("list_index["+wh_cnt+"] = "+al.get(wh_cnt));
            System.out.println();
            wh_cnt++;
        }   //while
    }   //main
}