package ch15;

import java.io.*;
import java.util.Arrays;

public class IOEx3 {
    public static void main(String[] args) {
        byte[] inSrc  = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp   = new byte[4];

        //Stream 선언.
        ByteArrayInputStream  input_s  = null;
        ByteArrayOutputStream output_s = null;

        //Byte Array ==> input Stream 전달.
        input_s  = new ByteArrayInputStream(inSrc);
        output_s = new ByteArrayOutputStream();

        System.out.println("input source = " + Arrays.toString(inSrc));

        try{
            while(input_s.available()>0)
            {
                input_s.read(temp);
                output_s.write(temp);
                System.out.println("temp : "+Arrays.toString(temp));
            
                outSrc = output_s.toByteArray();
                System.out.println("outSrc : "+Arrays.toString(outSrc));

                // input source = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
                // temp : [0, 1, 2, 3]
                // outSrc : [0, 1, 2, 3]
                // temp : [4, 5, 6, 7]
                // outSrc : [0, 1, 2, 3, 4, 5, 6, 7]
                // temp : [8, 9, 6, 7]      --> 읽을수 있는 부분만 읽어서 덮어씌움. 6,7은 이전에 읽은 쓰레기값임.
                // outSrc : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 7]    --> 쓰레기값이 그대로 복사.
            }
        }
        catch(IOException e)
        {
        }
    }
}
