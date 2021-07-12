package ch14_partion;

import java.util.*;
import java.util.stream.*;

import jdk.internal.net.http.frame.GoAwayFrame;

import java.util.function.*;
import static java.util.stream.Collectors.*;

import java.time.format.FormatStyle;
import java.time.format.SignStyle;

import static java.util.Comparator.*;

public class StreamEx8 {
    public static void main(String[] args) {
        Student[] stuarr = {
            new Student("나자바", true,  1, 1, 300),
            new Student("김지미", false, 1, 1, 250),
            new Student("김자바", true,  1, 1, 200),
            new Student("이지미", false, 1, 2, 150),
            new Student("남자바", true,  1, 2, 100),
            new Student("안지미", false, 1, 2,  50),
            new Student("황지미", false, 1, 3, 100),
            new Student("강지미", false, 1, 3, 150),
            new Student("이자바", true,  1, 3, 200),

            new Student("나자바", true,  2, 1, 300),
            new Student("김지미", false, 2, 1, 250),
            new Student("김자바", true,  2, 1, 200),
            new Student("이지미", false, 2, 2, 150),
            new Student("남자바", true,  2, 2, 100),
            new Student("안지미", false, 2, 2,  50),
            new Student("황지미", false, 2, 3, 100),
            new Student("강지미", false, 2, 3, 150),
            new Student("이자바", true,  2, 3, 200), 
        };

        System.out.println("1. 단순 분할(반별로)");
        Map<Integer, List<Student>> stubyban = Stream.of(stuarr).collect(groupingBy(Student::getban));
        
        for(List<Student> ban : stubyban.values())
        {
            for(Student s : ban){
                System.out.println(s);
            }
        }

        System.out.println("2. 단순 그룹(성적별로)");
        Map<Student.level, List<Student>> stubyScore = Stream.of(stuarr).collect(groupingBy
                                                        (s->{
                                                            if(s.getscore()>=200) return Student.level.HIGH;
                                                            if(s.getscore()>=100) return Student.level.MIDDLE;
                                                            else                  return Student.level.LOW;
                                                        }));
        //Map key에 따라 성적별로 구분.
        TreeSet<Student.level> keyset = new TreeSet<>(stubyScore.keySet());

        for(Student.level key : keyset)
        {
            System.out.println("["+key+"]");
            for(Student s : stubyScore.get(key))
            {
                System.out.println(s);
            }
            System.out.println();
        }
        
        System.out.println("3. 단순 그룹(성적별로) : 통계");
        Map<Student.level, Long> stubyScorecnt = Stream.of(stuarr).collect(groupingBy
                                                        (s->{
                                                            if(s.getscore()>=200) return Student.level.HIGH;
                                                            if(s.getscore()>=100) return Student.level.MIDDLE;
                                                            else                  return Student.level.LOW;
                                                        },counting()));

        for(Student.level key : stubyScorecnt.keySet())
        {
            //key에 해당하는 value 표시.
            System.out.printf("[%s] - %d명\n",key,stubyScorecnt.get(key));
        }
        
        System.out.println("4. 복합 그룹(학년, 반별로)");
        Map<Integer, Map<Integer, List<Student>>> stubyhak = Stream.of(stuarr).collect(groupingBy
                                                        (Student::gethak,groupingBy(Student::getban)
                                                        ));
        for(Map<Integer, List<Student>> hak : stubyhak.values())
        {
            for(List<Student> s : hak.values())
            {
                System.out.println(s);
            }
        }
        System.out.println();

        System.out.println("5. 복합 그룹(학년, 반별로 1등)");
        Map<Integer, Map<Integer, Student>> stutopbyhakban =  Stream.of(stuarr).collect(groupingBy
                                                        (Student::gethak,groupingBy(Student::getban,
                                                            collectingAndThen(
                                                                maxBy(comparingInt(Student::getscore))
                                                               , Optional::get
                                                               )
                                                            )
                                                        ));

        for(Map<Integer,Student> ban : stutopbyhakban.values())
        {
            for(Student s : ban.values())
            {
                System.out.println(s);
            }   
        }

        System.out.println("6. 복합 그룹(학년, 반별로 1등)");
        Map<String, Set<Student.level>> stubyScoreGroup = Stream.of(stuarr).collect(groupingBy(s->s.gethak()+"-"+s.getban(),
                                                                                    mapping(s-> {
                                                                                        if(s.getscore()>=200)       return Student.level.HIGH;
                                                                                        else if(s.getscore()>=100)  return Student.level.MIDDLE;
                                                                                        else                        return Student.level.LOW;
                                                                                    }, toSet())
                                                                                    ));
        Set<String> keyset2 = stubyScoreGroup.keySet();

        for(String key : keyset2)
        {
            System.out.println("["+key+"]"+stubyScoreGroup.get(key));
        }
    }
}
