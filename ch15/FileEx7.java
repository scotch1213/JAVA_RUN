package ch15;

import java.io.*;

//FilenameFilter 사용법.

public class FileEx7 {
    public static void main(String[] args) {
        String currdir = "D:\\Github\\JAVA_RUN-1\\ch15";
        System.out.println("user.dir : "+currdir);

        File dir = new File(currdir);
        final String pattern ="FileEx";

        String[] files = dir.list(new FilenameFilter(){
            public boolean accept(File dir, String name)
            {
                return name.indexOf(pattern)!=-1;
            }
        });

        for(int i=0;i<files.length;i++)
        {
            System.out.println(files[i]);
        }
    }
}
