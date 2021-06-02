package ch11;

import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();

        while(set.size()<6)             //set size = 6이 되면 break;
        {
            set.add((int)(Math.random()*45)+1);
        }
        System.out.println("HashSet = "+set);
        System.out.println("HashSet.size = "+set.size());

        LinkedList<Integer> list = new LinkedList<Integer>(set);
        Collections.sort(list);             //sort는 Collection클래스를 사용.
        
        System.out.println("after sort using by list");
        System.out.println("HashSet = "+list); 
    }
}
