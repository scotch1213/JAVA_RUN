package ch14;

import java.util.*;
import java.util.stream.*;

public class StreamEx1 {
    public static void main(String[] args) {
        //Student Class로 Stream 선언.
        Stream<Student> studentStream = Stream.of(
            new Student("이자바",3,300),
            new Student("김자바",1,200),
            new Student("안자바",2,100),
            new Student("박자바",2,150),
            new Student("소자바",1,200),
            new Student("나자바",3,290),
            new Student("감자바",3,180)
        );
        
        studentStream.sorted(Comparator.comparing(Student::getBan)                  //Student Class 중 '반'을 기준으로 정렬.
                            .thenComparing(Comparator.naturalOrder()))              //Student Class 중 '반'을 기준으로 정렬 이후 내림차순 정렬.
                            .forEach(System.out::println);                          //Stream 요소에 할 액션.
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
