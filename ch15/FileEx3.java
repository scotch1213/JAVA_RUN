package ch15;

import java.io.*;
import java.util.ArrayList;

public class FileEx3 {
    static int totalfiles = 0;
    static int totalDirs = 0;
    public static void main(String[] args) {
        File dir = new File("D:\\Github\\JAVA_RUN-1");
        System.out.println(dir.getName());

        if((!dir.exists())||(!dir.isDirectory()))
        {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        printFileList(dir);
        System.out.println();
        System.out.println(totalfiles + "개의 파일");
        System.out.println(totalDirs + "개의 디렉토리");
    }

    public static void printFileList(File dir) {
        System.out.println(dir.getAbsolutePath() + " 디렉토리");
        File[] files = dir.listFiles();

        ArrayList subDir = new ArrayList<>();

        for(int i=0;i<files.length;i++)
        {
            String filename = files[i].getName();
            if(files[i].isDirectory())
            {
                filename = "["+filename+"]";
                subDir.add(i+"");

                System.out.println(filename);
            }
        }
            int dirNum = subDir.size();
            int fileNum = files.length - dirNum;

            totalfiles += fileNum;
            totalDirs += dirNum;

            System.out.println(fileNum + "개의 파일," + dirNum + "개의 디렉토리");
            System.out.println();

            for(int i=0;i<subDir.size();i++)
            {
                int index = Integer.parseInt((String)subDir.get(i));
                printFileList(files[index]);
            }
    }    
}
