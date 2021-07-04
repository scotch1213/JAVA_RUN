package ch14;

import java.io.*;
import java.util.stream.*;

public class StreamEx2 {
    public static void main(String[] args) {
        File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"),
                        new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};
        
        Stream<File> fileStream = Stream.of(fileArr);

        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);

        Stream<String> filenameStream2 = fileStream.map(File::getName);
        filenameStream2.filter(s -> s.indexOf('.')!=-1)
        .map(s -> s.substring(s.indexOf('.'+1))
        .map(String::toUpperCase))
        .distinct()
        .forEach(System.out::print);

        System.out.println();
    }
}
