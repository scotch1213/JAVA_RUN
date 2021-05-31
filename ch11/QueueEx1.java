package ch11;

import java.util.*;

import ch9.EqualsEx1;

public class QueueEx1 {
    static Queue<String> qu = new LinkedList<String>();
    static final int MAX_SIZE = 5;                  // 큐 사이즈 5로 제한.
    public static void main(String[] args) {
        System.out.println("help를 입력하면, 도움말을 볼 수 있습니다.");
        while(true)
        {
            System.out.print(">>");
            try{
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim();

                if("".equals(input))                        //공백 입력 체크.
                {
                    System.out.println("입력이 없음.");
                    continue;
                }

                if(input.equalsIgnoreCase("q")){
                    System.out.println("실행을 종료합니다.");
                    System.exit(0);
                }
                else if(input.equalsIgnoreCase("--help")){
                    System.out.println("help - 도움말을 보여줍니다.");
                    System.out.println("q or Q - Exit");
                    System.out.println("history - 최근에 입력한 명령어를" + MAX_SIZE + "개 보여줍니다.");
                }
                else if(input.equalsIgnoreCase("history")){
                    int i =0;
                    save(input);

                    LinkedList<String> tmp = (LinkedList<String>)qu;
                    ListIterator<String> it = tmp.listIterator();

                    while(it.hasNext()){
                        System.out.println(++i+"."+it.next());
                    }
                }
                else
                {
                    save(input);
                    System.out.println(input);
                }
            }
            catch(Exception e)
            {
                System.out.println("입력오류입니다.");
            }
        }
    }

    public static void save(String input){
        if(!"".equals(input)){
            qu.offer(input);
        }

        if(qu.size() > MAX_SIZE)
        {
            qu.remove();
        }
    }
}
