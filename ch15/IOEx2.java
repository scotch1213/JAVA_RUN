package ch15;

import java.io.*;
import java.util.Arrays;

public class IOEx2 {
    public static void main(String[] args) {
        byte[] inSrc  = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp   = new byte[10];

        //Stream 선언.
        ByteArrayInputStream  input_s  = null;
        ByteArrayOutputStream output_s = null;

        //Byte Array ==> input Stream 전달.
        input_s  = new ByteArrayInputStream(inSrc);
        output_s = new ByteArrayOutputStream();

        // while대신 temp배열에 한번에 복사.
        // temp배열(byte[] b)에, 0byte(offset)부터, temp.length개(int len) read하여 저장.
        input_s.read(temp, 0, temp.length);
        // temp배열(byte[] b)에, 5byte(offset)부터, 5개(int len) 
        output_s.write(temp, 5, 5);

        // Output Stream -> Output ByteArrays 
        outSrc = output_s.toByteArray();

        System.out.println("input source = " + Arrays.toString(inSrc));
        System.out.println("temp = " + Arrays.toString(temp));
        System.out.println("output source = " + Arrays.toString(outSrc));
    }
    
}
