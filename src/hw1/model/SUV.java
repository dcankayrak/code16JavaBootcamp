package hw1.model;

public class SUV extends Car{
    private static final String CARTYPE = "SUV";

    public SUV(builder builder) {
        super(CARTYPE,builder);
    }
}
