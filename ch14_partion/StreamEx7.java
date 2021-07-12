package ch14_partion;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student{
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student(String name, boolean isMale, int hak, int ban, int score)
    {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }
    String getName(){ return name;  }
    boolean isMale(){ return isMale;}
    int gethak()    { return hak;   }
    int getban()    { return ban;   }
    int getscore()  { return score; }

    public String toString(){
        return String.format("[%s %s %d학년 %d반 %3d점]", name, isMale? "남":"여", hak, ban, score);
    }

    enum level {HIGH,MIDDLE, LOW}
}

public class StreamEx7 {
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
        System.out.println("1. 단순 분할(성별로)");
        Map<Boolean, List<Student>> stuBysex = Stream.of(stuarr).collect(partitioningBy(Student::isMale));

        List<Student> malestu = stuBysex.get(true);
        List<Student> femalestu = stuBysex.get(false);

        for(Student s : malestu)
        {
            System.out.println(s);
        }
        System.out.println();
        for(Student s : femalestu)
        {
            System.out.println(s);
        }
        System.out.println();

        Map<Boolean, Long> stuNumbySex = Stream.of(stuarr).collect(partitioningBy(Student::isMale, counting()));
        
        System.out.println("2. 단순 분할(성별 카운트)");
        System.out.println("남학생 수 : "+ stuNumbySex.get(true));
        System.out.println("여학생 수 : "+ stuNumbySex.get(false));
        System.out.println();

        Map<Boolean, Optional<Student>> topScorebySex = Stream.of(stuarr).collect(partitioningBy
                                                                                    (Student::isMale, 
                                                                                        maxBy(comparingInt(Student::getscore))));
        
        System.out.println("3. 단순 분할(성별 1등)");
        System.out.println("남학생 1등 : "+ topScorebySex.get(true));
        System.out.println("여학생 1등 : "+ topScorebySex.get(false)); 
        // Map table에, Optional이 들어가서, 리턴도 Optional
        // 남학생 1등 : Optional[[나자바 남 1학년 1반 300점]]
        // 여학생 1등 : Optional[[김지미 여 1학년 1반 250점]]
        System.out.println();      
        
        Map<Boolean, Student> topScorebySex2 = Stream.of(stuarr).collect(partitioningBy(Student::isMale, 
                                                        collectingAndThen(
                                                            maxBy(comparingInt(Student::getscore)),Optional::get
                                                            )
                                                        ));
                                                        
        System.out.println("남학생 1등 : "+ topScorebySex2.get(true));
        System.out.println("여학생 1등 : "+ topScorebySex2.get(false)); 
        System.out.println();    
        
        System.out.println("4. 다중분할.");
        Map<Boolean, Map<Boolean, List<Student>>> stubyfailed = Stream.of(stuarr).collect(partitioningBy(Student::isMale,
                                                                    partitioningBy(s->s.getscore()<=100))
                                                                    );
        System.out.println("남학생 불합격 : ");
        List<Student> maleFailed = stubyfailed.get(true).get(true);
        List<Student> femaleFailed = stubyfailed.get(false).get(true);
        for(Student s : maleFailed)
        {
            System.out.println(s);
        }
        System.out.println("남학생 불합격 : ");
        for(Student s : femaleFailed)
        {
            System.out.println(s);
        }
                                                                                 
    }
}
