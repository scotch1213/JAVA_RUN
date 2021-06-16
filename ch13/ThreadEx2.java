package ch13;

public class ThreadEx2 {
    public static void main(String[] args) throws Exception{
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();
    }
}

class ThreadEx2_1 extends Thread{
    public void run(){
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
        at ch13.ThreadEx2_1.throwException(ThreadEx2.java:18)
        at ch13.ThreadEx2_1.run(ThreadEx2.java:12)
*/
// 호출 스택의 첫번째 메서드가 런메서드임. 콜스택에 메인쓰레드가 없음.
// start로 쓰레드 스택이 따로 생성되었고, 메인 쓰레드는 종료되어서 콜스택에 메인메써드가 없음.