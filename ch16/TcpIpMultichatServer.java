package ch16;

import java.net.*;
import java.io.*;
import java.util.*;

public class TcpIpMultichatServer {
    HashMap clients;
    
    TcpIpMultichatServer(){
        clients = new HashMap<>();
        Collections.synchronizedMap(clients);
    }

    public void start()
    {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try{
            serverSocket = new ServerSocket(7777);
            System.out.println("server start.");

            while(true)
            {
                socket = serverSocket.accept();
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"is online");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    void snedToAll(String msg)
    {
        Iterator it  = clients.keySet().iterator();

        while(it.hasNext())
        {
            try{
                DataOutputStream out = (DataOutputStream)clients.get(it.next());
                out.writeUTF(msg);
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new TcpIpMultichatServer().start();
    }

    class ServerReceiver extends Thread{
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        ServerReceiver(Socket socket)
        {
            this.socket = socket;
            try{
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        public void run(){
            String name = "";

            try{
                name = in.readUTF();
                snedToAll("#"+name+"is online");

                clients.put(name, out);
                System.out.println("connect count is "+clients.size());

                while(in!=null)
                {
                    snedToAll(in.readUTF());
                }
            }
            catch(IOException e)
            {
            }
            finally{
                snedToAll("#"+name+"is log out");
                clients.remove(name);
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"is offline");
                System.out.println("connect count is "+clients.size());
            }

        }
    }
}
