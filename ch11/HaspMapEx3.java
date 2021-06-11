package ch11;

import java.util.*;
import java.util.Map.Entry;

public class HaspMapEx3 {
    static HashMap<String, HashMap<String,String>> phoneBook 
                = new HashMap<String, HashMap<String,String>>();

    static void addPhoneNo(String groupname, String name, String tel)
    {
        addGroup(groupname);
        // phoneBook의 value값에 sub HashMap의 물리주소를 가져옴. 포인터와 같은 방식.
        // ex) phoneBook@0x11 -> key = "친구"@0x1f, value@0x1f == grouphHashMap@0x1f
        HashMap<String,String> grouphHashMap  = (HashMap<String,String>)phoneBook.get(groupname);
        grouphHashMap.put(tel, name);           // 이름은 중복 가능하니, 전화번호를  설정.
        
        // System.out.print("tel : "+tel+", ");
        // System.out.println("name : "+name);
        // System.out.println("grouphHashMap : "+grouphHashMap.get(tel));

    }

    static void addGroup(String groupName)
    {
        // System.out.print("groupName : "+groupName+", ");
        if(!phoneBook.containsKey(groupName))
        {
            phoneBook.put(groupName, new HashMap<String,String>());
        }
    }

    static void addPhoneNo(String name, String tel)
    {
        addPhoneNo("기타", name, tel);
    }

    public static void main(String[] args) {
        addPhoneNo("친구", "친구1", "010-111-1111");
        addPhoneNo("친구", "친구2", "010-222-2222");
        addPhoneNo("친구", "친구3", "010-333-3333");
        
        addPhoneNo("직장", "직장1", "010-444-4444");
        addPhoneNo("직장", "직장2", "010-555-5555");
        addPhoneNo("직장", "직장3", "010-666-6666");
        addPhoneNo("직장", "직장4", "010-777-7777");
        
        addPhoneNo("세탁소", "02-888-8888");

        Set<Map.Entry<String, HashMap<String,String>>> set = phoneBook.entrySet();
        Iterator<Map.Entry<String, HashMap<String,String>>> it = set.iterator();

        while(it.hasNext())
        {
            Map.Entry<String, HashMap<String,String>> e = 
                    (Map.Entry<String, HashMap<String,String>>)it.next();
            
            Set<Map.Entry<String, String>> subset = e.getValue().entrySet();

            Iterator<Entry<String, String>> subit = subset.iterator();
  
            System.out.println("그룹 : "+e.getKey()+"["+subset.size()+"]");
            while(subit.hasNext())
            {
                Map.Entry<String,String> subE = (Map.Entry<String,String>)subit.next();
                System.out.println(subE.getKey() + ", " + subE.getValue());
            }
        }
    }
}
