package me.day05.practice.Practice01;

import me.day05.practice.Practice02.Users;
import me.day05.practice.Practice03.Electronics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class userTest {
    public static void main(String[] args) {
        User userSong = new User("Song", "a1234");

        System.out.println(userSong);

        String[] electronicDevices = {"GalaxyS", "GalaxyTablet"};

        User userTae = new User("Tae","b5678",
                "010-8885-9677","ussu1112@naver.com", LocalDate.of(1995,8,29), electronicDevices);

        System.out.println(userTae);

        ArrayList<AuthMethod> authArray = new ArrayList<>();
        ArrayList<AuthMethod> authArray2 = new ArrayList<>();

        authArray.add(AuthMethod.FINGERPRINT);
        authArray.add(AuthMethod.PIN);
        authArray2.add(AuthMethod.PATTERN);
        authArray2.add(AuthMethod.FACE);
        authArray2.add(AuthMethod.FINGERPRINT);

        Electronic electronic = new Electronic("Galaxy", CompanyName.SAMSUNG, LocalDate.now(), authArray);
        Electronic electronic2 = new Electronic("IPhone", CompanyName.APPLE, LocalDate.now(), authArray2);

        System.out.println(electronic);
        System.out.println(electronic2);

        Users user = Users.getInstance();
        User userHyoung = user.createUser("Hyoung", "c8901");
        User userTaeHyoung = user.createUser("TaeHyoung", "d9021");
        User userSonng = user.createUser("Tae","b5678",
                "010-8885-9677","ussu1112@naver.com", LocalDate.of(1995,8,29), electronicDevices);

        System.out.println(userHyoung);
        System.out.println(userTaeHyoung);
        System.out.println(userSonng);
        System.out.println(Arrays.toString(user.getUserList()));
        System.out.println(user.findByUserId("Hyoung"));
        System.out.println(Users.copy(userHyoung));


        System.out.println("=============");

        Electronics elec = Electronics.getInstance();
        Electronic elecA = elec.createElectronic("Galaxy", CompanyName.SAMSUNG, LocalDate.now(), authArray);
        Electronic elecB = elec.createElectronic("IPhone", CompanyName.APPLE, LocalDate.now(), authArray2);

        System.out.println(elecA);
        System.out.println(elec.findByProductNo("2304180003"));
        System.out.println(Arrays.toString(elec.groupByCompanyName(CompanyName.SAMSUNG)));
        System.out.println(elecB);
        System.out.println(Arrays.toString(elec.groupByAuthMethod(AuthMethod.FINGERPRINT)));





    }
}
