package ch16;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpIpServer3 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;      
        try{
            //7777 port binding
            serverSocket = new ServerSocket(7777); //7777 port user serversocket;            
            System.out.println(getTime()+"server ready!");
        }
        catch(IOException ie){
            ie.printStackTrace();
        }

        while(true)
        {
            try{
                System.out.println(getTime()+"server is waiting...");
                serverSocket.setSoTimeout(8000);    //Timeout 8000msec set.
                Socket socket = serverSocket.accept();      //wait until client connect. 
                System.out.println(getTime()+" : "+socket.getInetAddress()+" from receive request");
                System.out.println("getPort() : "+socket.getPort());            //check the client socket port no.
                System.out.println("getLocalPort() : "+socket.getLocalPort());  //check the server socket port no.

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("[Notice] Test Message1 from server.");
                System.out.println(getTime()+"data transfer");

                dos.close();
                socket.close();
            }
            catch(SocketTimeoutException se)
            {
                System.out.println(getTime()+"time out occurred, server closed.");
                System.exit(0);
            }
            catch(IOException ie)
            {
                ie.printStackTrace();
            }
        }
    }

    static String getTime()
    {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss] ");
        return f.format(new Date());
    }
}
