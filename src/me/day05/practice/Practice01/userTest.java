package me.day05.practice.Practice01;

import me.day05.practice.Practice02.Users;
import me.day05.practice.Practice03.Electronics;

import java.time.LocalDate;
import java.util.Arrays;

import static me.day05.practice.Practice01.AuthMethod.*;


public class userTest {
    public static void main(String[] args) {
        User userSong = new User("Song", "a1234");

        System.out.println(userSong);

        String[] electronicDevices = {"GalaxyS", "GalaxyTablet"};

        User userTae = new User("Tae","b5678",
                "010-8885-9677","ussu1112@naver.com", LocalDate.of(1995,8,29), electronicDevices);

        System.out.println(userTae);


        //Users user = new Users(); - 싱글톤 패턴이기 때문에 불가능
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

        System.out.println("===========================");

        Electronics electronics = Electronics.getInstance();

        AuthMethod[] authArray = {FINGERPRINT, PIN};
        AuthMethod[] authArray2 = {PATTERN, FACE};

        Electronic electronic = electronics.createElectronic("Galaxy", CompanyName.SAMSUNG, LocalDate.now(), authArray);
        Electronic electronic2 = electronics.createElectronic("IPhone", CompanyName.APPLE, LocalDate.now(), authArray2);

        System.out.println(electronic);
        System.out.println(electronic2);

        System.out.println("===========================");

        Electronic electronicsA = electronics.createElectronic("Galaxy", CompanyName.SAMSUNG, LocalDate.now(), authArray);
        Electronic electronicsB = electronics.createElectronic("IPhone", CompanyName.APPLE, LocalDate.now(), authArray2);

        System.out.println(electronicsA);
        System.out.println(electronics.findByProductNo("2304250003"));
        System.out.println(Arrays.toString(electronics.groupByCompanyName(CompanyName.SAMSUNG)));
        System.out.println(Arrays.toString(electronicsB.getAuthMethod()));
        System.out.println(Arrays.toString(electronics.groupByAuthMethod(FINGERPRINT)));
    }
}
