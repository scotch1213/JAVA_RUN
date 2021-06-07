package ch11;

import java.util.*;

public class HashSetEx5 {
    public static void main(String[] args) {
        HashSet<String> setA = new HashSet<String>();
        HashSet<String> setB = new HashSet<String>();
        HashSet<String> setHab = new HashSet<String>();
        HashSet<String> setKyo = new HashSet<String>();
        HashSet<String> setCha = new HashSet<String>();

        setA.add("1");
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");

        setB.add("4");
        setB.add("5");
        setB.add("6");
        setB.add("7");
        setB.add("8");

        System.out.println("setA : "+setA);
        System.out.println("setB : "+setB);

        Iterator<String> it = setB.iterator();

        while(it.hasNext())
        {
            Object tmp = it.next();
            if(setA.contains(tmp)){
                setKyo.add((String)tmp);                //교집합은 Iterator로 비교함.
            }
        }
        
        System.out.println("setKyo : "+setKyo);

        it = setA.iterator();
        while(it.hasNext())
        {
            Object tmp = it.next();
            if(!setB.contains(tmp))
            {   
                setCha.add((String)tmp);                //차집합은 Iterator로 비교함.
            }
        }
        System.out.println("setCha : "+setCha);

        it = setA.iterator();
        while(it.hasNext())
        {
            setHab.add((String)it.next());
        }

        it = setB.iterator();
        while(it.hasNext())
        {
            setHab.add((String)it.next());              //합집합은 HashSet이라서, 알아서 걸러냄.
        }
        System.out.println("setHab : "+setHab);
        
    }    
}
