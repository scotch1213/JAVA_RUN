package ch14_3;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamEx6 {
    public static void main(String[] args) {
        Student[] stuarr = {
        new Student("이자바", 3, 300),
        new Student("김자바", 1, 200),
        new Student("안자바", 2, 100),
        new Student("박자바", 2, 150),
        new Student("소자바", 1, 200),
        new Student("나자바", 3, 290),
        new Student("강자바", 3, 180)};

        // List에 이름만 저장
        List<String> names = Stream.of(stuarr).map(Student::getName).collect(Collectors.toList());
        System.out.println("names : "+ names);

        // 배열로 변환.
        Student[] stuarr2 = Stream.of(stuarr).toArray(Student[]::new);

        for(Student s : stuarr2)
        {
            System.out.println(s);
        }
        // 이름을 key로 해서 데이터 출력.
        Map<String,Student> stuMap = Stream.of(stuarr).collect(Collectors.toMap(s->s.getName(), p->p));
        for(String name : stuMap.keySet())
        {
            System.out.println(name+"="+stuMap.get(name));
        }

        long count = Stream.of(stuarr).collect(counting());
        long totalscore = Stream.of(stuarr).collect(summingInt(Student::gettotalscore));
        System.out.println("count = "+count);
        System.out.println("total score = "+totalscore);

        totalscore = Stream.of(stuarr).collect(reducing(0,Student::gettotalscore,Integer::sum));
        System.out.println("total score = "+totalscore);
        
        Optional<Student> topStudent = Stream.of(stuarr).
                                        collect(maxBy(Comparator.comparingInt(Student::gettotalscore)));
        System.out.println("topStudent : "+topStudent.get());

        IntSummaryStatistics stat = Stream.of(stuarr).collect(summarizingInt(Student::gettotalscore));
        System.out.println("stat : "+stat);

        String stuNames = Stream.of(stuarr).map(Student::getName).collect(joining(",","{","}"));
        System.out.println("stuNames : "+stuNames);
    }

}

// Student 클래스 관한 정보.
class Student implements Comparable<Student>{
    String name;
    int ban;
    int totalscore;

    Student(String name, int ban, int totalscore)
    {
        this.name = name;
        this.ban = ban;
        this.totalscore = totalscore;
    }

    public String toString(){
        return String.format("[%s %d %d]", name, ban, totalscore);
    }

    String getName(){return name;}
    int getBan(){return ban;}
    int gettotalscore(){return totalscore;}

    public int compareTo(Student s)
    {
        return s.totalscore - this.totalscore;
    }
}

