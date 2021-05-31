package ch11;

import java.util.*;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);                // Array List 10개 선언.

        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        System.out.print("list1 :"+list1);
        System.out.println();
        System.out.print("list1[0] :"+list1.get(0));
        System.out.println();
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        
        System.out.print("list1 :"+list1);
        System.out.println();
        System.out.print("list2 :"+list2);
        System.out.println();

        Collections.sort(list1);                //sort는 오름차순으로 정리해줌.
        Collections.sort(list2);

        System.out.println("after sort.");
        System.out.print("list1 :"+list1);
        System.out.println();
        System.out.print("list2 :"+list2);
        System.out.println();

        System.out.println("list1.contansAll(list2):"+list1.containsAll(list2));        // List1이 List2를 모두 포함하는가.

        System.out.println("after additional int add.");
        System.out.print("list2 :"+list2);
        System.out.println();
        list2.add("B");                          //List 뒤에 더함.

        System.out.print("list2 :"+list2);
        System.out.println();
        list2.add("C");                          //List 뒤에 더함.

        System.out.print("list2 :"+list2);
        System.out.println();
        list2.add(3,"C");                        //List 중 지정된 인덱스에 넣어버리고, 나머지를 뒤로 밀어버림.
        System.out.print("list2 :"+list2);
        System.out.println();
        
        System.out.print("list1 :"+list1);
        System.out.println();
        System.out.print("list2 :"+list2);
        System.out.println();
        System.out.println("list1.contansAll(list2):"+list1.containsAll(list2));        // List1이 List2를 모두 포함하는가?

        System.out.println("after same value delete.");
        System.out.print("list1.size() :"+list1.size());
        System.out.println();
        System.out.print("list2.size() :"+list2.size());
        System.out.println();
        for(int i=list2.size()-1;i>=0;i--)
        {
            if(list1.contains(list2.get(i)))
            {
                list2.remove(i);
            }
        }
 
        System.out.print("list1 :"+list1);
        System.out.println();
        System.out.print("list2 :"+list2);
        System.out.println();
        System.out.print("list1.size() :"+list1.size());
        System.out.println();
        System.out.print("list2.size() :"+list2.size());
        System.out.println();
    }
    
}
