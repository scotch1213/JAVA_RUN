package ch11;

import java.util.*;

class PropertiesEx1{
    public static void main(String[] args) {
        Properties prop = new Properties();

        prop.setProperty("timeout", "30");
        prop.setProperty("language", "kr");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");

        Enumeration e = prop.propertyNames();

        while(e.hasMoreElements()){
            String elements = (String)e.nextElement();
            System.out.println(elements+"="+prop.getProperty(elements));
        }
        
        prop.setProperty("size", "20");
        System.out.println("size = "+prop.getProperty("size"));         //size 변경됨.
        System.out.println("capacity = "+prop.getProperty("capacity","30"));            //default 30으로 지정. 근데, key값이 있어서 default 출력은 일어나지 않음.
        System.out.println("loadfactor = "+prop.getProperty("loadfactor", "0.75"));     //prop.에 loadfactor는 없어서, default 지정한 값을 출력.
        System.out.println(prop);
        prop.list(System.out);
    }
}