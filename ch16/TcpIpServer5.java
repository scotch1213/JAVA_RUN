package ch16;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class TcpIpServer5 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try{
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"Server is ready.");
  
            socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 

    static String getTime()
    {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss] ");
        return f.format(new Date());
    }
}

class Sender extends Thread{
    Socket socket;
    DataOutputStream out;
    String name;

    Sender(Socket socket)
    {
        this.socket = socket;
        try{
            out = new DataOutputStream(socket.getOutputStream());
            name = "["+socket.getInetAddress()+":"+socket.getPort()+"]";
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        while(out!=null)
        {
            try{
                out.writeUTF(name + scanner.nextLine());
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class Receiver extends Thread{
    Socket socket;
    DataInputStream in;

    Receiver(Socket socket){
        this.socket = socket;
        try{
            in = new DataInputStream(socket.getInputStream());
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        while(in!=null)
        {
            try{
                System.out.println(in.readUTF());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
