package ch12_3;

import java.util.*;

class Fruit {   public String toString()    {   return "Fruit"; }}
class Apple extends Fruit {   public String toString()    {   return "Apple"; }}
class Grape extends Fruit {   public String toString()    {   return "Grape"; }}

class Juice {
    String name;

    Juice(String name)      {   this.name =  name + "Juice";    }
    public String toString(){   return name;    }
}

class Juicer {
    static Juice makejJuice(FruitBox<? extends Fruit>box)
    {
        String tmp = "";
        for(Fruit f : box.getList())
        {
            tmp += f+ " ";
        }

        return new Juice(tmp);
    }
}
//FruitBox 클래스의 제네릭타입은 Fruit을 상속한 <T>를 사용.
//FruitBox 클래스은 Box를 상속받아서 사용.
//FruitBox는 사용만 하고, 내용은 부모클래스인 Box에서 했기때문에, extends.
class FruitBox<T extends Fruit> extends Box<T>{}

class Box<T>{
    ArrayList <T> list = new ArrayList<T>();
    
    void add(T item){
        list.add(item);
    }

    T get(int i){
        return list.get(i);
    }

    ArrayList<T> getList(){
        return list;
    }

    int size()
    {
        return list.size();
    }

    public String toString()
    {
        return list.toString();
    }

}

public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println(Juicer.makejJuice(fruitBox));
        System.out.println(Juicer.makejJuice(appleBox));
    }
}
