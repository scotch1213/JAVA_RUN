package ch11;

import java.util.*;

public class VectorEx1 {
    public static void main(String[] args) {
        Vector v = new Vector(5);           //capcity가 세팅.
        Vector v1 = new Vector(5);
        v.add("1");
        v.add("2");
        v.add("3");

        System.out.println("v.size:"+v.size());
        System.out.println("v.capacity:"+v.capacity());
        System.out.print(v);
        System.out.println();
        System.out.println("System.identityHashCode(v):"+System.identityHashCode(v));
        System.out.println();

        System.out.println("after v.trimToSize");
        v.trimToSize();
        System.out.println("v.size:"+v.size());
        System.out.println("v.capacity:"+v.capacity());
        System.out.print(v);
        System.out.println();
        System.out.println("System.identityHashCode(v):"+System.identityHashCode(v));
        System.out.println();

        System.out.println("after ensureCapacity(6)");
        v.ensureCapacity(6);
        System.out.println("v.size:"+v.size());
        System.out.println("v.capacity:"+v.capacity());
        System.out.print(v);
        System.out.println();
        System.out.println("System.identityHashCode(v):"+System.identityHashCode(v));
        System.out.println();

        System.out.println("after setSize(7)");
        v.setSize(7);
        System.out.println("v.size:"+v.size());                     //size7로 증가.
        System.out.println("v.capacity:"+v.capacity());             //capcity가 5라서 7을 감당하지 못함. 때문에 시스템에서 12로 증가.
        System.out.print(v);
        System.out.println();
        System.out.println("System.identityHashCode(v):"+System.identityHashCode(v));

        
        System.out.println("after v.remove(0)");
        v.remove(0);
        System.out.println("v.size:"+v.size());
        System.out.println("v.capacity:"+v.capacity());
        System.out.print(v);
        System.out.println();
        System.out.println("System.identityHashCode(v):"+System.identityHashCode(v));

        
        System.out.println("after v.clear()");
        v.clear();
        System.out.println("v.size:"+v.size());
        System.out.println("v.capacity:"+v.capacity());
        System.out.print(v);
        System.out.println();
        System.out.println("System.identityHashCode(v):"+System.identityHashCode(v));
    }
}
