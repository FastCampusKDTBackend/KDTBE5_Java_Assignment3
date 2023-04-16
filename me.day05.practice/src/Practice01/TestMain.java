package Practice01;

import practice02.Users;
import practice03.Electronics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {

        Users userList = Users.getInstance();
        Electronics electronicList = Electronics.getInstance();

        System.out.println("1. Create User Object Test");
        System.out.println("===============================================================================");
        User hong = new User("Hong1", "h1234", "010-1234-5678", "hong1@google.com",
                stringToDate("19800325"));
        User kim = new User("Kim1", "k1234", "010-2345-6789", "kim1@google.com",
                stringToDate("19680517"));
        User lee = new User("Lee1", "l1234", "010-2346-6780", "lee1@google.com",
                stringToDate("19810617"));
        User park = new User("Park1", "p1234", "010-2346-6780", "park1@google.com",
                stringToDate("19900825"));

        userList.add(hong);
        userList.add(kim);
        userList.add(lee);
        userList.add(park);
        System.out.println(userList);
        System.out.println();

        System.out.println("2. findByUserId Test");
        System.out.println("===============================================================================");
        System.out.println(userList.findByUserId("Hong1"));
        System.out.println();

        System.out.println("3. copy user Test");
        System.out.println("===============================================================================");
        User copyKim = userList.copy(kim);
        userList.add(copyKim);
        System.out.println(userList);
        System.out.println();

        System.out.println("4. Create Electronic Object Test");
        System.out.println("===============================================================================");
        Electronic smartphone = new Electronic("Galaxy S23", Electronic.Company.SAMSUNG,
                stringToDate("20230120"),
                new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.FACE,
                Electronic.AuthMethod.PIN, Electronic.AuthMethod.PATTERN});
        Electronic notebook = new Electronic("16그램", Electronic.Company.LG,
                stringToDate("20230401"), new Electronic.AuthMethod[]{Electronic.AuthMethod.FACE,
                Electronic.AuthMethod.FINGERPRINT});
        Electronic iphone = new Electronic("IPhone 14", Electronic.Company.APPLE,
                stringToDate("20230315"),
                new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.FACE,
                        Electronic.AuthMethod.PIN, Electronic.AuthMethod.PATTERN});
        Electronic iMac = new Electronic("아이맥24", Electronic.Company.APPLE,
                stringToDate("20230415"),
                new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.FACE});

        electronicList.add(smartphone);
        electronicList.add(notebook);
        electronicList.add(iphone);
        electronicList.add(iMac);
        System.out.println(electronicList);
        System.out.println();

        System.out.println("4. Add Electronic Object Test");
        System.out.println("===============================================================================");
        hong.addElectronicDevices(smartphone);
        hong.addElectronicDevices(notebook);
        lee.setElectronicDevices(electronicList.getElectronicList());
        System.out.println(hong);
        System.out.println(lee);
        System.out.println();

        System.out.println("5. findByProductNo Test");
        System.out.println("===============================================================================");
        System.out.println(electronicList.findByProductNo("2304160001"));
        System.out.println(electronicList.findByProductNo("2304160002"));
        System.out.println();

        System.out.println("6. groupByCompany Test");
        System.out.println("===============================================================================");
        Electronic[] selectGroupList = electronicList.groupByCompanyName(Electronic.Company.APPLE);
        System.out.println(Arrays.toString(selectGroupList));
        System.out.println();
        Electronic[] selectAuthList = electronicList.groupByAuthMethod(Electronic.AuthMethod.FINGERPRINT);
        System.out.println(Arrays.toString(selectAuthList));

        System.out.println("7. final copy user Test");
        System.out.println("===============================================================================");
        park.setElectronicDevices(electronicList.getElectronicList());
        User copyPark = userList.copy(park);
        userList.add(copyPark);
        System.out.println(copyPark);
        System.out.println();
        System.out.println(userList);
        System.out.println();
    }

    public static LocalDate stringToDate(String stringDate) {
        return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

}
