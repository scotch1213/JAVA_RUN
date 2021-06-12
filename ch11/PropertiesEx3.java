package ch11;

import java.util.*;
import java.io.*;

public class PropertiesEx3 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        prop.setProperty("timeout", "30");
        prop.setProperty("language", "kr");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");

        try{
            prop.store(new FileOutputStream("Output.txt"),"Properties Example");
            prop.storeToXML(new FileOutputStream("Output.xml"),"Properties Example");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
