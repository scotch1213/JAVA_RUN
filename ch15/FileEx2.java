package ch15;

import java.io.*;

public class FileEx2 {
    public static void main(String[] args) {
        if(args.length != 1)
        {
            System.out.println("USAGE : java FileEx2 DIRECTORY");
            System.exit(0);
        }

        File f = new File(args[0]);
        System.out.println(f.getName());

        File[] files = f.listFiles();

        for(int i=0; i<files.length;i++)
        {
            String fileNames = files[i].getName();
            System.out.println(files[i].isDirectory()? "["+fileNames+"]" : fileNames);      //Directory인지 아닌지 구분.
        }
    }
}
