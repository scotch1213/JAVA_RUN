package ch14;

interface Myfunction{
    void run();
}
public class LambdaEx1 {
    static void execute(Myfunction f){          // 매개변수가 Myfunction인 함수.
        f.run();
    }

    static Myfunction getMyfunction(){
        Myfunction f = ()->System.out.println("f1.run()");                //람다표현
        return f;
    }

    public static void main(String[] args) {
        Myfunction f1 = ()->System.out.println("f1.run()");

        Myfunction f2 = new Myfunction(){
            public void run(){
                System.out.println("f2.run()");
            }
        };

        Myfunction f3 = getMyfunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(()->System.out.println("run()"));
    }
}
