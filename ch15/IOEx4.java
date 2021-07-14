package ch15;

import java.io.*;
import java.util.Arrays;

public class IOEx4 {
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
                //
                int d_length;
                d_length = input_s.read(temp);
                System.out.println("d_length : "+d_length);
                output_s.write(temp,0,d_length);
                System.out.println("temp : "+Arrays.toString(temp));
            
                outSrc = output_s.toByteArray();
                System.out.println("outSrc : "+Arrays.toString(outSrc));

                // input source = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
                // d_length : 4
                // temp : [0, 1, 2, 3]
                // outSrc : [0, 1, 2, 3]
                // d_length : 4
                // temp : [4, 5, 6, 7]
                // outSrc : [0, 1, 2, 3, 4, 5, 6, 7]
                // d_length : 2
                // temp : [8, 9, 6, 7]
                // outSrc : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]      ==> d_length 크기 만큼만 복사하기 때문에, 쓰레기값을 안 읽음.
            }
        }
        catch(IOException e)
        {
        }
    }
}
