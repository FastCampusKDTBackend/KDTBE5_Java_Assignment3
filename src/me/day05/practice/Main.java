package me.day05;

import me.day05.practice01.AuthMethod;
import me.day05.practice01.Company;
import me.day05.practice01.Electronic;
import me.day05.practice01.User;
import me.day05.practice02.Users;
import me.day05.practice03.Electronics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Users userList = Users.getInstance();
        Electronics electronicList = Electronics.getInstance();

        User park = new User("seonghye0n", "qwe123");
        User kim = new User("kim12", "asd123", "010-1234-5678", "", "19980711");

        System.out.println(userList);

        System.out.println("=============Find By UserID=============");
        System.out.println(userList.findByUserId("seonghye0n"));
        System.out.println();

        System.out.println("=============Copy AND Change Password=============");
        User copyPark = userList.copy(park);
        copyPark.setUserPassword("qwe123!@#");
        System.out.println(userList);
        System.out.println();

        Electronic samsungTv = new Electronic("50inch TV", Company.SAMSUNG);
        Electronic iMac = new Electronic("iMac", Company.APPLE, new AuthMethod[]{AuthMethod.FINGER, AuthMethod.FACEID});
        Electronic gram = new Electronic("16inch Gram", Company.LG, new AuthMethod[]{AuthMethod.PIN});

        System.out.println(electronicList);

        park.addElectronic(samsungTv);
        park.addElectronic(gram);

        kim.setElectronicDevices(electronicList.getElectronicList());

        System.out.println("=============Add Electronic AND Show Info=============");
        System.out.println(park);
        System.out.println(kim);
        System.out.println();

        System.out.println("=============Find By ProductNo : 2304140001=============");
        System.out.println(electronicList.findByProductNo("2304140001"));
        System.out.println("=============Find By ProductNo : 2304140003=============");
        System.out.println(electronicList.findByProductNo("2304140003"));
        System.out.println();

        System.out.println("=============Group By CompanyName : APPLE=============");
        Electronic[] appleList = electronicList.groupByCompanyName(Company.APPLE);
        System.out.println(Arrays.toString(appleList));
        System.out.println("=============Group By AuthMethod : PIN=============");
        Electronic[] pinList = electronicList.groupByAuthMethod(AuthMethod.PIN);
        System.out.println(Arrays.toString(pinList));
        System.out.println();

    }
}
