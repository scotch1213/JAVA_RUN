package ch12_enum_ex1;

import java.lang.Enum;
import java.util.Arrays;

enum Direction { EAST, WEST, SOUTH, NORTH }

public class EnumEx1 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");
    
        System.out.println("d1 :"+d1);
        System.out.println("d2 :"+d2);
        System.out.println("d3 :"+d3);

        System.out.println("d1 == d2? " + (d1==d2));
        System.out.println("d1 == d3? " + (d1==d3));
        System.out.println("d1.equal(d3)? " + (d1.equals(d3)));

        // enum의 ordinal 비교.
        System.out.println("d1.compare(d3)? "+ d1.compareTo(d3));
        System.out.println("d1.compare(d2)? "+ d1.compareTo(d2));
        System.out.println("d2.compare(d1)? "+ d2.compareTo(d1));

        switch(d1){
            case EAST:
            {
                System.out.println("The direction is EAST");
            }
            break;
            case WEST:
            {
                System.out.println("The direction is WEST");
            }
            break;
            case SOUTH:
            {
                System.out.println("The direction is SOUTH");
            }
            break;
            case NORTH:
            {
                System.out.println("The direction is NORTH");
            }
            break;
        }
        
        Direction[] darr = Direction.values();
        System.out.println("Direction.values() : "+Arrays.toString(Direction.values()));

        for(Direction d : darr)
        {
            System.out.printf("%s = %d\n",d.name(),d.ordinal());
        }
    }
}
