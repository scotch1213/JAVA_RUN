package ch12_enum_ex3;

enum Transportation{
    BUS(100)            { int fare(int distance){ return distance*BASIC_FARE;}},
    TRAIN(150)          { int fare(int distance){ return distance*BASIC_FARE;}},
    SHIP(200)           { int fare(int distance){ return distance*BASIC_FARE;}},
    AIRPLANE(300)       { int fare(int distance){ return distance*BASIC_FARE;}};
    protected final int BASIC_FARE;

    Transportation(int value)
    {
        this.BASIC_FARE = value;
    }
    public int getBasicFare(){return BASIC_FARE;}
    abstract int fare(int distatnce);
}

public class EnumEx3 {
    public static void main(String[] args) {
        System.out.println("Bus : "+Transportation.BUS.fare(100));
        System.out.println("Train : "+Transportation.TRAIN.fare(100));
        System.out.println("Ship : "+Transportation.SHIP.fare(100));
        System.out.println("Airplane : "+Transportation.AIRPLANE.fare(100));
    }
}
