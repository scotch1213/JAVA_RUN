package ch15;

import java.io.*;

public class RandomAccessFileEx3 {
    public static void main(String[] args) {
        int sum = 0;
        int data = 0;
        try{
            RandomAccessFile raf = new RandomAccessFile("D:\\Github\\JAVA_RUN-1\\score2.dat", "r");
            int i = 0;
            while(true)
            {
                //int 배열에 Byte 단위로 읽음. int니까, 4Byte 단위로 보면 된다.
                raf.seek(i);                
                System.out.println("파일 포인터의 위치 : "+raf.getFilePointer());
                data = raf.readInt();
                System.out.println("파일 포인터의 위치 : "+raf.getFilePointer());
                sum +=data;
                System.out.println("read data["+i+"]: "+ data +", sum :"+ sum);
                i+=4;
            }
        }catch(EOFException e)
        {
            System.out.println("sum "+ sum);}
        catch(IOException e)
        {}
    }
}
