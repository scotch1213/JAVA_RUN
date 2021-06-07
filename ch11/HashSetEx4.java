package ch11;

import java.util.*;

public class HashSetEx4 {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<Object>();

        // add메서드가 새로운 요소를 추가하기전에 기존의 저장요소와 판별하기 위해 hashcode, equals 호출.
        // Person2 클래스에, hash code, equals를 오버라이딩함.

        System.out.println("chk 1");
        set.add(new String("abc"));
        System.out.println("chk 2");
        set.add(new String("abc"));                         //abc가 이미 있어서 인식이 안됨.
        System.out.println("chk 3");
        set.add(new Person2("Dick",22));   
        System.out.println("chk 4");                
        set.add(new Person2("Dick",22));         //같은 자료형을 추가해도, 인식이 되어 자료형이 추가됨.

        System.out.println("HashSet :"+set);
    }    
}

class Person2{
    String name;
    int age;

    Person2(String name, int age){
            this.name = name;
            this.age  = age;
    }

    public String toString(){
        System.out.println("chk toString");
        return name + ":" + age;
    }

    public boolean equals(Object obj)
    {
        System.out.println("chk equals");
        if(obj instanceof Person2)
        {
            Person2 tmp = (Person2)obj;     //오브젝트를 Person2 클래스로 형변환.
            return name.equals(tmp.name) && age == tmp.age;
        }
        return false;
    }

    public int hashCode(){
        System.out.println("chk hashCode :"+(name+age).hashCode());
        return (name+age).hashCode();
    }

}