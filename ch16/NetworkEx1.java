package ch16;

import java.net.*;
import java.util.*;

public class NetworkEx1 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try{
            ip = InetAddress.getByName("hios.gg");
            System.out.println("getHostName : "+ip.getHostName());
            System.out.println("getHostAddress : "+ip.getHostAddress());
            System.out.println("toString() : "+ip.toString());

            byte[] ipAddr = ip.getAddress();            //signed data type.
            System.out.println("ipAddr = "+Arrays.toString(ipAddr));

            String result = "";
            for(int i=0;i<ipAddr.length;i++)
            {
                result += (ipAddr[i]<0)? ipAddr[i]+256 : ipAddr[i];     //if ipAddr is negative, change to positive.
                result += ".";
            }
            System.out.println("ipAddr = "+result);
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }

        try{
            ip = InetAddress.getLocalHost();                //my PC hostname and IP.
            System.out.println("getHostName : "+ip.getHostName());
            System.out.println("getHostAddress : "+ip.getHostAddress());
            System.out.println();
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }

        try{
            ipArr = InetAddress.getAllByName("hios.gg");                //my PC hostname and IP.
            for(int i=0;i<ipArr.length;i++)
            {
                System.out.println("ipArr["+i+"] : "+ipArr[i]);
            }
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
}
