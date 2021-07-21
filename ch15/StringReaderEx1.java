package ch15;

import java.io.*;

public class StringReaderEx1 {
    public static void main(String[] args) {
        String input_data = "Heroes of the Storm";
        StringReader input = new StringReader(input_data);
        StringWriter output = new StringWriter();

        int data = 0;

        try{
            while((data=input.read())!=-1)
            {
                output.write(data);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("input  : "+input_data);
        System.out.println("output : "+output.toString());
    }
}
