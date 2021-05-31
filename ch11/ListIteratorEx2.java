package ch11;

import java.util.*;

public class ListIteratorEx2 {
    public static void main(String[] args) {
        ArrayList<Integer> origin = new ArrayList<Integer>();
        ArrayList<Integer> copy1 = new ArrayList<Integer>();
        ArrayList<Integer> copy2 = new ArrayList<Integer>();

        for(int i=0;i<10;i++)
        {
            origin.add(i);
        }

        System.out.println("origin : "+ origin);
        Iterator<Integer> it = origin.iterator();

        while(it.hasNext())
        {
            copy1.add(it.next());
        }
        
        System.out.println("copy1 : "+ copy1);

        if(it.hasNext())
        {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        //여기서 iterator는 더이상 next를 사용할수 없다.
        while(it.hasNext())
        {
            copy2.add(it.next());
            origin.remove(it.next());
        }
        System.out.println("origin : "+ origin);
        System.out.println("copy2 : "+ copy2);

        //iterator를 새로 선언.
        it = origin.iterator();
        while(it.hasNext())
        {
            copy2.add(it.next());
            it.remove();
        }
        System.out.println("origin : "+ origin);
        System.out.println("copy2 : "+ copy2);
    }    
}
