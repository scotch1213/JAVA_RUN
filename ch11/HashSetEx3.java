package ch11;

import java.util.*;

public class HashSetEx3 {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<Object>();

        set.add("abc");
        set.add("abc");                         //abc가 이미 있어서 인식이 안됨.
        set.add(new Person("Dick",22));         
        set.add(new Person("Dick",22));         //같은 자료형을 추가해도, 인식이 되어 자료형이 추가됨.

        System.out.println("HashSet :"+set);
    }    
}

class Person{
    String name;
    int age;

    Person(String name, int age){
            this.name = name;
            this.age  = age;
    }

    public String toString(){
        return name + ":" + age;
    }
}