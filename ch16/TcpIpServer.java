package ch16;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpIpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"server ready!");
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        while(true)
        {
            try {
                System.out.println(getTime()+"server is waiting...");
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+socket.getInetAddress()+"from receive request");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("[Notice] Test Message1 form server.");
                System.out.println(getTime()+"data transfer");

                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }  
    
    static String getTime()
    {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
