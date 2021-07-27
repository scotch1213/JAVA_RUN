package ch15;

import java.io.*;

public class FIleEx1 {
    public static void main(String[] args) {
        try{
            File f = new File("D:\\Github\\JAVA_RUN-1\\ch15\\FIleEx1.java");
            String fileName = f.getName();
            int pos = fileName.lastIndexOf(".");

            System.out.println("경로를 제외한 파일 이름 : "+f.getName());
            System.out.println("확장자를 제외한 파일 이름 : "+fileName.substring(0, pos));
            System.out.println("확장자 이름 : "+fileName.substring(pos+1));
            System.out.println();
            
            System.out.println("경로를 포함한 파일 이름 : "+f.getPath());
            System.out.println("절대경로를 포함한 파일 이름 : "+f.getAbsolutePath());
            System.out.println("정규경로를 포함한 파일 이름 : "+f.getCanonicalPath());
            System.out.println("파일이 속해 있는 디렉토리 : "+f.getParent());
            System.out.println();
            System.out.println("File.pathSeparator : "  + File.pathSeparator);
            System.out.println("File.pathSeparatorChar  : "+File.pathSeparatorChar);

            
            System.out.println("File.Separator : "  + File.separator);
            System.out.println("File.separatorChar  : "+File.separatorChar);
            System.out.println();
            System.out.println("user.dir : "+System.getProperty("user.dir"));
            System.out.println("sun.boot.class.path : "+System.getProperty("sun.boot.class.path"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }   
}    
