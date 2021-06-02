package ch11;

import java.util.*;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object[] objarr = {"1",1,"2","2","3","3","3","4","4","4","4"};
        Set<Object> set = new HashSet<Object>();

        for(int i=0;i<objarr.length;i++)
        {
            set.add(objarr[i]);
        }   

        System.out.println("objarr = "+Arrays.toString(objarr));
        System.out.println("objarr.length = "+objarr.length);
        //Hashset은 중복되는 데이터는 무시함.
        System.out.println("HashSet = "+set);
        System.out.println("HashSet.size = "+set.size());



    }
    
}
