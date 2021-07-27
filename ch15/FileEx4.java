package ch15;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileEx4 {
    public static void main(String[] args) {
        File dir = new File("D:\\Github\\JAVA_RUN-1\\ch15");
        System.out.println("File Name : "+dir.getName());

        File[] files = dir.listFiles();
        for(int i=0;i<files.length;i++)
        {
            File f = files[i];
            String name = f.getName();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mma");
            String attribute = "";
            String size = "";

            if(files[i].isDirectory())
            {
                attribute +="DIR";
            }
            else{
                size += f.length()+"";
                attribute += f.canRead()    ?   "R":".";
                attribute += f.canWrite()   ?   "W":".";
                attribute += f.isHidden()   ?   "H":".";
            }

            System.out.printf("%s %3s %6s %s\n", 
                            df.format(new Date(f.lastModified())),attribute,size,name);
        }
    }
}
