package hw1.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String nationalityId;
    private String firstName;
    private String lastName;
    private String userType;
    private List<Car> ownedCars;

    public User(String nationalityId, String firstName, String lastName, String userType) {
        this.nationalityId = nationalityId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    public void rentACar(Car car){
        if(ownedCars == null){
            ownedCars = new ArrayList<>();
        }
        ownedCars.add(car);
        System.out.println("Aracı Kiraladığınız için teşekkür ederiz!");
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Car> getOwnedCars() {
        return ownedCars;
    }

    public void setOwnedCars(List<Car> ownedCars) {
        this.ownedCars = ownedCars;
    }


}
