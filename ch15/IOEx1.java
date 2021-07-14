package ch15;

import java.io.*;
import java.util.Arrays;

public class IOEx1 {
    public static void main(String[] args) {
        // inSrc ==> OutSrc
        // inSrc    -->     input_s -->               output_s -->              outSrc
        // (byte array)     (ByteArrayInputStream)    (ByteArrayOutputStream)   (byte array)
        byte[] inSrc  = { 0,1,2,3,4,5,6,7,8,9 };
        byte[] outSrc = null;

        ByteArrayInputStream  input_s  = null;
        ByteArrayOutputStream output_s = null;

        input_s  = new ByteArrayInputStream(inSrc);
        output_s = new ByteArrayOutputStream();

        int data = 0;

        //1. input_s Data read
        //2. data !=1
        while((data = input_s.read())!=-1){
            output_s.write(data);
        }

        outSrc = output_s.toByteArray();

        System.out.println("input source = " + Arrays.toString(inSrc));
        System.out.println("output source = " + Arrays.toString(outSrc));

    }
}
