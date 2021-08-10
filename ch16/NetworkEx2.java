package ch16;

import java.io.IOException;
import java.net.*;

public class NetworkEx2 {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.hios.gg");

            System.out.println("url.getAuthority() : "+url.getAuthority());
            try {
                System.out.println("url.getContent() : "+url.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("url.getDefaultPort() : "+url.getDefaultPort());
            System.out.println("url.getPort() : "+url.getPort());
            System.out.println("url.getHost() : "+url.getHost());
            System.out.println("url.getPath() : "+url.getPath());
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }

    }
}
