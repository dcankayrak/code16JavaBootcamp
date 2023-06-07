package hw1.model;

import java.math.BigDecimal;

public class Car {
    private String plate;
    private String brand;
    private String model;
    private String color;
    private BigDecimal rentCost;
    private String carType;
    private double trunkWidth;
    private boolean isRented;

    public Car(String carType,builder builder){
        this(builder);
        this.carType = carType;
    }

    public Car(builder builder){
        this.plate = builder.plate;
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.rentCost = builder.rentCost;
        this.trunkWidth = builder.trunkWidth;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getColor() {
        return color;
    }

    public BigDecimal getRentCost() {
        return rentCost;
    }

    public double getTrunkWidth() {
        return trunkWidth;
    }

    public String getCarType(){
        return carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", rentCost=" + rentCost +
                ", carType='" + carType + '\'' +
                ", trunkWidth=" + trunkWidth +
                '}';
    }

    public static class builder{
        private String plate;
        private String brand;
        private String model;
        private String color;
        private BigDecimal rentCost;
        private double trunkWidth;
        private String carType;
        private boolean isRented;

        public builder setPlate(String plate) {
            this.plate = plate;
            return this;
        }

        public builder setCarType(String carType){
            this.carType = carType;
            return this;
        }

        public builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public void setRented(boolean rented) {
            isRented = rented;
        }

        public builder setModel(String model) {
            this.model = model;
            return this;
        }

        public builder setColor(String color) {
            this.color = color;
            return this;
        }

        public builder setRentCost(BigDecimal rentCost) {
            this.rentCost = rentCost;
            return this;
        }

        public builder setTrunkWidth(double trunkWidth) {
            this.trunkWidth = trunkWidth;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }
}
