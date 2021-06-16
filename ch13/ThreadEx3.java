package ch13;

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run();
    }
}

class ThreadEx3_1 extends Thread{
    public void run()
    {
        throwException();
    }

    public void throwException()
    {
        try{
            throw new Exception();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}

//실행하면, 결과가 아래와 같은데,
/*
java.lang.Exception
        at ch13.ThreadEx3_1.throwException(ThreadEx3.java:19)
        at ch13.ThreadEx3_1.run(ThreadEx3.java:13)
        at ch13.ThreadEx3.main(ThreadEx3.java:6)
*/
// 호출 스택의 첫번째 메서드가 메인메서드