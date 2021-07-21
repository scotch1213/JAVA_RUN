package ch15;

import java.io.*;
import java.util.*;

public class SequenceInputStreamEx {
    public static void main(String[] args) {
        byte[] arr1 = {0,1,2};
        byte[] arr2 = {3,4,5};
        byte[] arr3 = {6,7,8};
        byte[] outsrc = null;

        Vector v = new Vector();
        v.add(new ByteArrayInputStream(arr1));
        v.add(new ByteArrayInputStream(arr2));
        v.add(new ByteArrayInputStream(arr3));

        //여러개의 input Stream을 병합할 대, Sequence 사용.
        SequenceInputStream input = new SequenceInputStream(v.elements());          
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        try{
            while((data = input.read())!=-1)
            {
                output.write(data);
            }
        }catch(IOException e){}

        outsrc = output.toByteArray();

        System.out.println("input 1 : "+Arrays.toString(arr1));
        System.out.println("input 2 : "+Arrays.toString(arr2));
        System.out.println("input 3 : "+Arrays.toString(arr3));
        System.out.println("output : "+Arrays.toString(outsrc));
    }
}
