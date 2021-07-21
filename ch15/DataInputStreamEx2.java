package ch15;

import java.io.*;

public class DataInputStreamEx2 {
    public static void main(String[] args) {
        int sum = 0;
        int score = 0;

        FileInputStream fis = null;
        DataInputStream dis = null;

        try{
            fis = new FileInputStream("score.dat");
            dis = new DataInputStream(fis);

            while(true)
            {
                score = dis.readInt();
                System.out.println(score);
                sum += score;
            }
        }catch(EOFException e)
        {
            System.out.println("점수의 총합은 " + sum);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally        
        { //예외 처리와 상관없이 실행되어야 하기 때문에, finally 처리.
            try{
                if(dis!=null)               //dis가 null일 때, Close 하면 에러 발생함.
                {
                    dis.close();                    
                }
            }catch(Exception ie)
            {
                ie.printStackTrace();
            }
        }

    }
}
