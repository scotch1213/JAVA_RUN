package ch11;

import java.util.*;

public class HashMapEx4 {
    public static void main(String[] args) {
        String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","S"};

        HashMap<String,Integer> map = new HashMap<String,Integer>();

        for(int i=0;i<data.length;i++)
        {
            if(map.containsKey(data[i])){
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i],value.intValue()+1);
            }
            else{
                map.put(data[i], 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

        while(it.hasNext())
        {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next(); 
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : "+printbar('#', value)+" "+value);
        }
    }    

    public static String printbar(char ch, int value){
        char[] bar = new char[value];

        for(int i=0;i<bar.length;i++)
        {
            bar[i] = ch;
        }
        return new String(bar);
    }
}
