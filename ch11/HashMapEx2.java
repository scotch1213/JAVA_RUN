package ch11;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        //key String, value Int.
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        map.put("김자바", 90);
        map.put("김자바", 100);             // Key 값 덮어씌움.
        map.put("이자바", 100);
        map.put("강자바", 80);
        map.put("안자바", 90);

        // value, key 둘다 쓰기 위해서 Set을 map.entryset으로 받음.
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        Iterator<Map.Entry<String,Integer>> it = set.iterator();

        while(it.hasNext())     //value, key 동시 출력.
        {
            Map.Entry<String,Integer> e = (Map.Entry<String,Integer>)it.next();
            System.out.println("이름 : "+e.getKey()+", 점수 : "+e.getValue());
        }

        // map에서 key만 출력.
        Set<String> setkey = map.keySet();
        System.out.println("참가자 명단 : "+setkey);           //key만 출력.

        // map에서 value만 출력.
        Collection<Integer> values = map.values();
        Iterator<Integer> it_val = values.iterator();

        int total =0;

        while(it_val.hasNext()){
            int i = (int)it_val.next();
            total += i;
        }

        System.out.println("총점 : "+total);
        System.out.println("평균 : "+total/set.size());
        System.out.println("최고점수 : "+Collections.max(values));
        System.out.println("최저점수 : "+Collections.min(values));

    }
}
