package ch11;

import java.io.*;
import java.util.*;

public class PropertiesEx2 {

    // java PropertiesEx2.java input.txt;
    // input txt를 읽어서 출력한다.
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("USAGE : javja Properties2Ex INPUTFILENAME");
            System.exit(0);
        }

        Properties prop = new Properties();

        String inputFile = args[0];

        try{
            prop.load(new FileInputStream(inputFile));
        }
        catch(IOException e)
        {
            System.out.println("입력한 txt를 찾을 수 없습니다.");
            System.exit(0);
        }

        String name = prop.getProperty("name");
        String data[] = prop.getProperty("data").split(",");
        int max = 0;
        int min = 9999;
        int sum = 0;

        for(int i=0;i<data.length;i++)
        {
            int intvalue = Integer.parseInt(data[i]);
            if(i == 0)
            {
                max = intvalue;
                max = intvalue;
            }

            if(max < intvalue)
            {
                max = intvalue;
            }
            if(min > intvalue)
            {
                min = intvalue;
            }

            sum += intvalue;
        }

        System.out.println("이름 : "+name);
        System.out.println("max : "+max);
        System.out.println("min : "+min);
        System.out.println("sum : "+sum);
    }
}
