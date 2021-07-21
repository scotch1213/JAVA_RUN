package ch15;

import java.io.*;
// Thread간 데이터를 주고 받을 때, 사용하는 방식.
// Connect를 이용해서 물려 놓고 데이터 전송.
public class PipedReaderWriter {
    public static void main(String[] args) {
        InputThread inthread = new InputThread("input_Thread");
        OutputThread outthread = new OutputThread("output_Thread");

        inthread.connect(outthread.getOutput());

        inthread.start();
        outthread.start();
    }
}

class InputThread extends Thread{
    PipedReader     input   = new PipedReader();
    StringWriter    sw      = new StringWriter();
    
    InputThread(String name)
    {
        super(name);
    }

    public void run()
    {
        try{
            int data = 0;

            while((data=input.read())!=-1)
            {
                sw.write(data);
            }
            System.out.println(getName()+" received : " + sw.toString());
        }catch(IOException e)
        {}
    }

    public PipedReader getInput(){
        return input;
    }

    public void connect(PipedWriter output)
    {
        try{
            input.connect(output);
        }catch(IOException e){}
    }
}

class OutputThread extends Thread{
    PipedWriter output = new PipedWriter();

    OutputThread(String name)
    {
        super(name);
    }

    public void run()
    {
        try{
            String msg = "hello! 안녕하세요!";
            System.out.println(getName() + " sent : " + msg);
            output.write(msg);
            output.close();
        }catch(IOException e){}
    }

    public PipedWriter getOutput(){
        return output;
    }

    public void connect(PipedReader input)
    {
        try{
            output.connect(input);
        }catch(IOException e){}
    }
}
