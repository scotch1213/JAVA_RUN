package ch11;

import java.util.*;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet<Integer> Tset = new TreeSet<Integer>();
        int[] score = {80,95,50,35,45,65,10,100};

        for(int i=0;i<score.length;i++)
        {
            Tset.add(score[i]);
        }
        System.out.println("Tset : "+Tset);
        // Tset : [10, 35, 45, 50, 65, 80, 95, 100]
        System.out.println("Tset_Head : "+Tset.headSet(50));
        // SortedSet<Integer> java.util.TreeSet.headSet(Integer toElement)
        // Returns a view of the portion of this set whose elements are 'strictly less' than toElement. 
        // Tset : [10, 35, 45]
        System.out.println("Tset_Tail : "+Tset.tailSet(50));
        // SortedSet<Integer> java.util.TreeSet.tailSet(Integer fromElement)
        // Returns a view of the portion of this set whose elements are 'greater than or equal' to fromElement.
        // Tset : [50, 65, 80, 95, 100]
    }
}
