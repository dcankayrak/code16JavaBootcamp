package hw1;

import hw1.model.*;

import javax.naming.ldap.HasControls;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentACar {
    public static void main(String[] args) {
        RentACarService.start();
    }
}

class RentACarService{

    static List<Car> carList = new ArrayList<Car>();
    static List<User> userList = new ArrayList<User>();

    static {

        // Creating sample Users.
        userList.add(new IndividualUser("123","Ahmet","Kaya"));
        userList.add(new CorporateUser("1234","Mehmet","Kaya"));

        // Creating sample cars.
        carList.add(new Car
                .builder()
                .setPlate("2")
                .setBrand("Mercedes")
                .setModel("za")
                .setColor("")
                .setRentCost(BigDecimal.valueOf(300))
                .setTrunkWidth(300)
                .build());
        carList.add(new Hatchback(new Car
                .builder()
                .setPlate("123")
                .setBrand("Mercedes")
                .setModel("za")
                .setColor("Black")
                .setRentCost(BigDecimal.valueOf(300))
                .setTrunkWidth(300)));
    }

    static Scanner input = new Scanner(System.in);

    private static Car getCarWithPlate(String plate){
        for (Car car:carList) {
            if(car.getPlate().equals(plate)){
                return car;
            }
        }
        return null;
    }

    private static User getUserWithId(String id){
        for (User user:userList){
            if(user.getNationalityId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public static void start(){
        System.out.println("Araç Kiralama Şirketimize Hoşgeldiniz");
        System.out.println("--------------------------------------");
        User kullanici;
        while(true){
            System.out.println("İşlem yapmak için yapmak istediğiniz kullanıcının TC kimlik numarasını giriniz.");
            System.out.println("Çıkmak için 0'a basınız.");
            String selection = input.nextLine();
            kullanici = getUserWithId(selection);

            if(kullanici == null){
                selection = input.nextLine();
                kullanici = getUserWithId(selection);
            }

            if(selection.equals("0")){
                System.out.println("Bizi tercih ettiğiniz için teşekkür eder, iyi günler dileriz.");
                break;
            }

            System.out.println("Seçtiğiniz Kullanıcı Tipi : "+kullanici.getUserType());
            System.out.println("----------------------------------------");
            System.out.println("Tüm Arabaları Listelemek İçin 1'e\nAraba Kiralamak İçin 2'ye\nTüm kiralanan araçları görebilmek için 3'e\nBir Üst Menü İçin 0'a basınız.");
            int selectionInt = input.nextInt();
            switch (selectionInt){
                case 1:
                    // Tüm arabaları listele
                    for (Car listItem:carList) {
                        if(kullanici.getUserType().equals("BIREYSEL")){
                            if(listItem instanceof Hatchback){
                                System.out.println(listItem);
                            }
                        }else{
                            System.out.println(listItem);
                        }
                    }
                    break;
                case 2:
                    // Araba Kirala
                    String plate = input.nextLine();

                    // Get the car.
                    Car tempCar = getCarWithPlate(plate);
                    if(tempCar == null){
                        System.out.println("Kiralamak İstediğiniz aracın plakasını giriniz:");
                        tempCar = getCarWithPlate(input.nextLine());
                    }

                    // Kaç günlük kiralamak istiyorsunuz ?
                    System.out.println("Kiralanmak istenen günü giriniz:");
                    int day = input.nextInt();

                    System.out.println("İstenilen gün için bu aracın kira ücreti : "+
                            (tempCar.getRentCost().multiply(BigDecimal.valueOf(day))));
                    System.out.println("Onaylıyor musunuz ? (Onaylamak için 1'e basınız.)");
                    if(input.nextInt() == 1){
                        kullanici.rentACar(tempCar);
                    }
                    System.out.println("Onaylamadınız. Bir önceki menüye dönülüyor");
                    break;
                case 3:
                    // Get All Users and theirs owned cars
                        for (User listItem:userList) {
                            System.out.println(listItem.getFirstName()+" "+listItem.getLastName()+ " kullanıcısının kiraladığı araçlar:");
                            System.out.println("------------------------");
                            if(listItem.getOwnedCars() == null){
                                System.out.println("Kiralanan araç yok!");
                                break;
                            }else {
                                for (Car car : listItem.getOwnedCars()) {
                                    System.out.println("- " + car);
                                }
                            }
                        }
                    break;
                case 0:
                    return;
            }
        }


    }
}
