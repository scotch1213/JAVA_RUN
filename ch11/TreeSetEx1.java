package ch11;

import java.util.*;

public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<String>();

        String from = "b";
        String to   = "d";

        set.add("abc");
        set.add("alien");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("dance");
        set.add("dzzz");
        set.add("dZZZ");
        set.add("elephant");
        set.add("elevator");
        set.add("fan");
        set.add("flower");
        set.add("123");

        System.out.println("Treeset : "+set);
        // Treeset : [123, Car, abc, alien, bat, car, dZZZ, dance, disc, dzzz, elephant, elevator, fan, flower]
        // 대문자 먼저 정렬된다.(ascii 순서대로 정렬된다.)    TreeSet은 알아서 정렬한다. LinkedHashSet과 다름.
        System.out.println("range Search(from 2 to) : "+set.subSet(from, to));
        //from <= subset < to. ==> [bat, car]
        System.out.println("range Search(from 2 to +zzz) : "+set.subSet(from, to+"zzz"));
          //from <= subset < (to + "zzz" == dzzz). ==> [bat, car, dZZZ, dance, disc]
    }
}
