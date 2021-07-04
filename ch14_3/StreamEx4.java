package ch14_3;

import java.util.*;
import java.util.stream.*;

public class StreamEx4 {
    public static void main(String[] args) {
        Stream<String []> strrArrStrm = Stream.of(
            new String[]{"abc","def","jkl"},
            new String[]{"ABC","GHI","JKL"}
        );

        //Stream<Stream<String>> strStrmStrm = strrArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strrArrStrm.flatMap(Arrays::stream);
        // new String[]{"abc","def","jkl"},
        // new String[]{"ABC","GHI","JKL"}
        strStrm.map(String::toLowerCase)            // "abc","def","jkl"          소문자로 변환.
                                                    // "abc","ghi","jkl"
               .distinct()                          // "abc","def","jkl","ghi"    중복 제거.
               .sorted()                            // abc def ghi jkl            내림차순으로 정렬.
               .forEach(System.out::println);

        System.out.println();

        String[] lineArr = {
            "Believe or not It is true",
            "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" ")))    //문자열을 여백 단위로 쪼갬
        .map(String::toLowerCase)                                 //소문자로 변환
        .distinct()                                               // 중복 제거.
        .sorted()                                                 // 내림차순으로 정렬.
        .forEach(System.out::println);
        System.out.println();

        Stream<String> strStrm1 = Stream.of("AAA","ABC","bBb","Dd");
        Stream<String> strStrm2 = Stream.of("bbb","aaa","ccc","dd");

        Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
        Stream<String> strStream = strStrmStrm.map(s->s.toArray(String[]::new))      //Stream<Stream<String>>  ==> Stream<String []>
                                              .flatMap(Arrays::stream);              //Stream<String []>       ==> Stream<String>

        strStream.map(String::toLowerCase)
                 .distinct()
                 .forEach(System.out::println);
    
    }
}
