package ch11;

import java.util.*;

public class ArrayEx {
    public static void main(String[] args) {
        int[]   arr = {0,1,2,3,4};
        int[][] arr2D = {{11,12,13},{21,22,23}};

        System.out.println("arr = "+Arrays.toString(arr));
        System.out.println("arr2D = "+Arrays.deepToString(arr2D));

        //int[] java.util.Arrays.copyOf(int[] original, int newLength)
        int[]   arr2 = Arrays.copyOf(arr, arr.length);
        int[]   arr3 = Arrays.copyOf(arr, 3);           // copy 3 elements
        int[]   arr4 = Arrays.copyOf(arr, 7);           // size over copy;
        int[]   arr5 = Arrays.copyOfRange(arr, 2, 4);   // copy index 2 ~ 3
        int[]   arr6 = Arrays.copyOfRange(arr, 0, 7);   // copy index 0 ~ 6
        
        System.out.println("arr2 = "+Arrays.toString(arr2));
        System.out.println("arr3 = "+Arrays.toString(arr3));
        System.out.println("arr4 = "+Arrays.toString(arr4));
        System.out.println("arr5 = "+Arrays.toString(arr5));
        System.out.println("arr6 = "+Arrays.toString(arr6));

        int[]   arr7 = new int[5];
        Arrays.fill(arr7, 9);           //arr7 push 9 all.
        System.out.println("arr7 = "+Arrays.toString(arr7));

        Arrays.setAll(arr7, i -> (int)((Math.random()*6)+1));
        System.out.println("arr7 = "+Arrays.toString(arr7));

        for(int i=0;i<arr7.length;i++)
        {
            char[] graph = new char[arr7[i]];
            Arrays.fill(graph,'+');
            System.out.println(new String(graph)+1);
        }

        String[][] str2D = new String[][]{{"AAA","BBB"},{"CCC","DDD"}};
        String[][] str2D2 = new String[][]{{"AAA","BBB"},{"CCC","DDD"}};

        System.out.println("using equal, str2D == str2D2? :"+ Arrays.equals(str2D,str2D2));          //equals use only 1-Dimension
        System.out.println("using deepEquals, str2D == str2D2? :"+ Arrays.deepEquals(str2D,str2D2));

        char[] charr = {'A','D','C','B','E'};
        System.out.println("charr :"+ Arrays.toString(charr));
        System.out.println("index of A = "+Arrays.binarySearch(charr, 'A'));            //정렬이 안되서, binary Search가 정상동작하지 않음.
        System.out.println("index of B = "+Arrays.binarySearch(charr, 'B'));
        System.out.println("index of C = "+Arrays.binarySearch(charr, 'C'));
        System.out.println("index of D = "+Arrays.binarySearch(charr, 'D'));
        System.out.println("index of E = "+Arrays.binarySearch(charr, 'E'));

        System.out.println("--- after sort ---");
        Arrays.sort(charr);
        System.out.println("index of A = "+Arrays.binarySearch(charr, 'A'));            //정렬이 안되서, binary Search가 정상동작하지 않음.
        System.out.println("index of B = "+Arrays.binarySearch(charr, 'B'));
        System.out.println("index of C = "+Arrays.binarySearch(charr, 'C'));
        System.out.println("index of D = "+Arrays.binarySearch(charr, 'D'));
        System.out.println("index of E = "+Arrays.binarySearch(charr, 'E'));
    }
    
}
