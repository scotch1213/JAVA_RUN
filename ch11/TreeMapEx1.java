package ch11;

import java.util.*;

public class TreeMapEx1 {
    public static void main(String[] args) {
        String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        for(int i=0;i<data.length;i++)
        {
            if(map.containsKey(data[i]))
            {
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i], (value.intValue()+1));
            }
            else{
                map.put(data[i], 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

        System.out.println("기본정렬");

        while(it.hasNext())
        {
            Map.Entry<String, Integer> entry = it.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : "+printbar('#', value)+" "+value);
        }

        //map을  ArrayList로 변환한 이후, Sort.
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
        
        Collections.sort(list,new ValueComparator());

        it = list.iterator();

        System.out.println("Sort 이후,");
        while(it.hasNext())
        {
            Map.Entry<String, Integer> entry = it.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : "+printbar('#', value)+" "+value);
        }
    }

    static class ValueComparator implements Comparator{
        public int compare(Object o1, Object o2)
        {
            if (o1 instanceof Map.Entry && o2 instanceof Map.Entry)
            {
                Map.Entry e1 = (Map.Entry)o1;
                Map.Entry e2 = (Map.Entry)o2;

                int v1 = ((Integer)e1.getValue()).intValue();
                int v2 = ((Integer)e2.getValue()).intValue();

                return v2 - v1;
            }
            else{
                return -1;
            }
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

