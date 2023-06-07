package hw1.model;

public class CorporateUser extends User{

    public CorporateUser(String nationalityId, String firstName, String lastName) {
        super(nationalityId, firstName, lastName, "KURUMSAL");
    }
}
