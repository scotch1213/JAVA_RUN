package ch16;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpIpServer4 implements Runnable{
    ServerSocket serverSocket = null;
    Thread[] threadArr;

    public static void main(String[] args) {
        TcpIpServer4 server = new TcpIpServer4(5);

        server.start();
    }

    public TcpIpServer4(int num){
        try{
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"Server is ready.");
        
            threadArr = new Thread[4];
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }    
    
    public void start()
    {
        for(int i=0;i<threadArr.length;i++)
        {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    public void run()
    {
        while(true)
        {
            try{
                System.out.println(getTime()+" server is waiting...");
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
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss] ");
        return f.format(new Date()) + " : " +name;
    }
}
