package ch11;

import java.util.*;

public class ValidCHeck {
    public static void main(String[] args) {
        
        System.out.println("args[0] :"+args[0]);
        // System.out.println("args.length :"+args.length);
        if(args.length != 1){
            System.out.println("Usage : java Validcheck \"Expression\"");
            System.out.println("Ex : java Validcheck \"((2+3)*1)+3\"");
            System.exit(0);
        }

        Stack<String> st = new Stack<String>();
        String expression = args[0];

        System.out.println("experssion :"+expression);
        System.out.println("experssion.length :"+expression.length());
        try
        {
            for(int i=0;i<expression.length();i++)
            {
                char ch = expression.charAt(i);
                
                System.out.print("ch :"+ch);
                if(ch == '(')
                {
                    st.push(Character.toString(ch));
                }
                else if(ch == ')')
                {
                    st.pop();
                }
                System.out.print(", st :"+st);
                System.out.println();
            }//for end 문자열 스캔 완료.

            if(st.isEmpty())
            {
                System.out.println("(is same.");
            }
            else
            {
                System.out.println("(is not same.");
            }
        }
        catch(EmptyStackException e)
        {
            System.out.println("Stack Exception!, (is not same.");
        }
    }
}
