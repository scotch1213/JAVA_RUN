package ch15;

import java.io.*;
import java.util.ArrayList;

public class SerialEx1 {
    public static void main(String[] args) {
        try{
            String filename = "UserInfo.ser";
            FileOutputStream        fos = new FileOutputStream(filename);
            BufferedOutputStream    bos = new BufferedOutputStream(fos);

            ObjectOutputStream oos = new ObjectOutputStream(bos);

            UserInfo user1 = new UserInfo("Javaman","1234",30);
            UserInfo user2 = new UserInfo("Javawoman","4321",24);
            UserInfo user3 = new UserInfo();

            ArrayList<UserInfo> user_List = new ArrayList<UserInfo>();

            user_List.add(user1);
            user_List.add(user2);
            user_List.add(user3);

            oos.writeObject(user1);
            oos.writeObject(user2);
            oos.writeObject(user3);
            oos.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
