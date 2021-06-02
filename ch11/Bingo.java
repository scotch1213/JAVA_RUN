package ch11;

import java.util.*;

public class Bingo {
    public static void main(String[] args) {
        // Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set = new LinkedHashSet<Integer>();
        //hashset의 경우, 저장된 순서를 보장하지 않는다.
        int[][] board = new int[5][5];
        int cnt=0;

        while(set.size()<25) 
        {
            int num = (int)(Math.random()*50)+1;
            System.out.println("num["+cnt+"] : "+num);
            set.add(num);
            System.out.println("hashset : "+set);
            System.out.println("HashSet.size = "+set.size());
            System.out.println();
            cnt++;
        }

        System.out.println("hashset : "+set);
        Iterator<Integer> it = set.iterator();

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                board[i][j] = (int)it.next();
                System.out.print((board[i][j]<10? "  " : " ")+board[i][j]);
            }
            System.out.println();
        }
    }
}
