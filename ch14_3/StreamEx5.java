package ch14_3;

import java.util.*;
import java.util.stream.*;

public class StreamEx5 {
    public static void main(String[] args) {
        String[] strarr = {"Inheritance","Java","Lambda","stream","OptionalDouble","IntStream","count","sum"};

        Stream.of(strarr).forEach(System.out::println);

        boolean noEmptystr = Stream.of(strarr).noneMatch(s->s.length()==0);
        Optional<String> sWord = Stream.of(strarr).filter(s->s.charAt(0)=='s').findFirst();

        System.out.println("noEmptystr = "+noEmptystr);
        System.out.println("sWord = "+sWord.get());

        IntStream intStream1 = Stream.of(strarr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strarr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strarr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strarr).mapToInt(String::length);
        
        int count = intStream1.reduce(0, (a,b) -> a+1);
        int sum   = intStream2.reduce(0, (a,b) -> a+b);
        System.out.println("count = "+count);
        System.out.println("sum = "+sum);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("max = "+max.getAsInt());
        System.out.println("min = "+min.getAsInt());

    }    
}
