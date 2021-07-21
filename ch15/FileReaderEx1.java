package ch15;

import java.io.*;

public class FileReaderEx1 {
    public static void main(String[] args) {
        try{
            String fileName = "FileReadertest.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;

            while((data=fis.read())!=-1)            //file read 끝날때까지.
            {
                System.out.print((char)data);
            }
            fis.close();
            System.out.println();

            while((data=fr.read())!=-1)            //file read 끝날때까지.
            {
                System.out.print((char)data);       //fr로 하면, 안깨짐...
            }
            fr.close();
        }catch(Exception e)
        {

        }
    }
}
