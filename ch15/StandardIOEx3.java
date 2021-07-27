package ch15;

import java.io.*;

public class StandardIOEx3 {
    public static void main(String[] args) {
        PrintStream ps = null;
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream("D:\\Github\\JAVA_RUN-1\\test.txt");
            ps = new PrintStream(fos);

            System.setOut(ps);              //출력을 test.txt로 되게 설정.
        }catch(FileNotFoundException e)
        {
            System.err.println("File not Found.");
        }

        System.out.println("Hellow by System.out.");
        System.err.println("Hellow by System.err.");

    }    
}
