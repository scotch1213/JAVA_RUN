package ch13;

class ThreadEx4{
    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();

        for(int i =0;i<300;i++)
        {
            System.out.printf("%s","-");
        }
        long end_time = System.currentTimeMillis();
        System.out.println("소요시간 : "+(end_time-start_time+"ms"));

        
        start_time = System.currentTimeMillis();

        for(int i =0;i<300;i++)
        {
            System.out.printf("%s","*");
        }
        end_time = System.currentTimeMillis();
        System.out.println("소요시간 : "+(end_time-start_time+"ms"));
    }
}