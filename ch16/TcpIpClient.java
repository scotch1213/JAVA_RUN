package ch16;

import java.net.*;
import java.io.*;

public class TcpIpClient {
    public static void main(String[] args) {
        try{
            String serverIp = "127.0.0.1";

            System.out.println("connneting... ServerIP : "+serverIp);
            Socket socket = new Socket(serverIp,7777);

            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            System.out.println("message from server : "+dis.readUTF());
            System.out.println("connection closing...");

            dis.close();
            socket.close();
            System.out.println("connection closed.");
        }
        catch(ConnectException ce)
        {
            ce.printStackTrace();
        }
        catch(IOException io)
        {
            io.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
}
