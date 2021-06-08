package ch11;

import java.util.*;
public class HashMapEx1 {
    public static void main(String[] args) {
        //HashMap의 경우, Value, Key 2개의 형을 지정해줘야 함.
        HashMap<String,String> map = new HashMap<String,String>();          

        map.put("myId", "1234");
        map.put("asdf", "1111");            //
        map.put("asdf", "1234");            //key에 value가 중복. 마지막 value가 저장된다.

        System.out.println("map ="+map);

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("id와 pw를 입력해주세요.");
            System.out.print("id : ");
            String id = scan.nextLine().trim();              //trim은 스트링 앞뒤의 공백을 제거 해준다. ex) "  asdf  " ==> "asdf"
                                                             //nextline()은 엔터치기 전까지의 데이터 입력.
            System.out.print("pw : ");
            String pw = scan.nextLine().trim();              //trim은 스트링 앞뒤의 공백을 제거 해준다. ex) "  asdf  " ==> "asdf"
            System.out.println();

            if(!map.containsKey(id))                        //key에 해당하는 입력값이 없을때.
            {
                System.out.println("id는 존재하지 않습니다. 다시 입력해주세요.");
                // continue;                       
            }
            else{
                //map.get(key)  => key에 해당하는 Value return.
                if(!map.get(id).equals(pw))                         //key 해당하는 value가 입력받은 값과 일치하는가?
                {
                    System.out.println("Pw가 존재하지 않습니다.");
                }
                else{
                    System.out.println("Pw가 일치합니다.");
                    break;
                }
            }
        }

    }
}
