package ch15;

import java.io.*;

public class FileViewer {
    public static void main(String[] args) throws IOException {
            FileInputStream fis = new FileInputStream("D:\\Github\\JAVA_RUN-1\\ch15\\IOEx1.java");
            int data = 0;

            while((data = fis.read())!=-1)
            {
                char c = (char)data;
                System.out.print(c);
            }
            fis.close();
    }    
}
