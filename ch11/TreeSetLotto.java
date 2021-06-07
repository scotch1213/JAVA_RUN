package ch11;

import java.util.*;

public class TreeSetLotto {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();

        for(int i=0;set.size()<6;i++)
        {
            int num = (int)(Math.random()*45.0f)+1;
            set.add(num);
        }

        System.out.println("TreeSet : "+set);
    }
}
