package ch13;

import java.util.concurrent.*;

public class ForkJoinEx1 {
    static final ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {
        long from = 1L;
        long to = 100L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        Long result = pool.invoke(task);

        System.out.println("Elapsed Time 4: "+(System.currentTimeMillis()-start));

        System.out.printf("sum of %d~%d=%d\n",from,to,result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis();

        for(long i = from;i<=to;i++)
        {
            result +=i;
        }
        System.out.println("Elapsed Time 1: "+(System.currentTimeMillis()-start));
        System.out.printf("sum of %d~%d=%d\n",from,to,result);
        System.out.println();
    }
}

class SumTask extends RecursiveTask<Long>{
    long from, to;

    SumTask(long from, long to){
        this.from = from;
        this.to = to;
    }

    public Long compute(){
        long size = to - from + 1;
        if(size <=5)
        {
            return sum();
        }

        long half = (to+from)/2;
        SumTask leftSum = new SumTask(from, half);
        SumTask rightSum = new SumTask(half+1, to);

        leftSum.fork();             // fork로 스레드풀에 대기.

        return rightSum.compute()+leftSum.join();       //

    }

    long sum(){
        long tmp =0L;
        for(long i=from;i<=to;i++){
            tmp+=i;
        }
        return tmp;
    }
}
