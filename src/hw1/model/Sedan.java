package hw1.model;

public class Sedan extends Car{
    private static final String CARTYPE = "SEDAN";

    public Sedan(builder builder) {
        super(CARTYPE,builder);
    }
}
