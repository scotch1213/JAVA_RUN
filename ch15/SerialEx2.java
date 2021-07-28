package ch15;

import java.io.*;
import java.util.ArrayList;

public class SerialEx2 {
    public static void main(String[] args) {
        try{
            String filename = "UserInfo.ser";
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            UserInfo u1 = (UserInfo)ois.readObject();
            UserInfo u2 = (UserInfo)ois.readObject();
            UserInfo u3 = (UserInfo)ois.readObject();

            ArrayList userList = new ArrayList<>();

            userList.add(u1);
            userList.add(u2);
            userList.add(u3);

            System.out.println(userList);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
