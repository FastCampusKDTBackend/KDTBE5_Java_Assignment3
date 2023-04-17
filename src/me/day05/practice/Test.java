package me.day05.practice;

import java.time.LocalDate;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Electronics electronics = Electronics.getInstance();
        Users users = Users.getInstance();

        System.out.println("======================");
        System.out.println("Duplication Test");


        //initialize Electronics for test
        electronics.initElectronics();
        System.out.println();
        //initialize Users for test
        users.initUsers();


        System.out.println("\n\n\n======================");
        User originalUser = new User.Builder().userId("copyTester1")
                .userPassword("copyTester1PW")
                .userPhoneNumber("010-9999-9999")
                .userEmail("copyTester1@gmail.com")
                .userBirthDate(LocalDate.parse("1999-12-31"))
                .build();
        //shallow copy object
        User copyUser = originalUser;
        System.out.println("Shallow copy");
        System.out.println("Original User : " + originalUser + "");
        System.out.println("Copy User : " + copyUser + "\n");

        System.out.println("Modify Element's value : copyUserId only");
        copyUser.setUserId("copyTester2(modified)");
        System.out.println("Original User : " + originalUser + "");
        System.out.println("Copy User : " + copyUser + "\n");

        //undo userId value
        copyUser.setUserId("copyTester1");
        //deep copy Object
        copyUser = User.copy(originalUser);

        System.out.println("Deep copy");
        System.out.println("Original User : " + originalUser + "");
        System.out.println("Copy User : " + copyUser + "\n");
        System.out.println("Modify Element's value : copyUserId only");
        copyUser.setUserId("copyTester2(modified)");
        System.out.println("Original User : " + originalUser + "");
        System.out.println("Copy User : " + copyUser + "\n");

        System.out.println("\n\n\n======================");
        System.out.println("Use List");
        //find by user ID
        System.out.println("Find by User ID\n");
        System.out.println("Find User ID : tester10");
        printObject(users.findByUserId("tester10"));
        System.out.println("Find User ID : tester01");
        printObject(users.findByUserId("tester01"));
        //find by product number
        System.out.println("\nFind by Product No\n");
        System.out.println("Find Product No : 2101210001");
        printObject(electronics.findByProductNo("2101210001"));
        System.out.println("Find Product No : 2104210001");
        printObject(electronics.findByProductNo("2104210001"));


        //find by Company
        System.out.println("\nFind by Company\n");
        System.out.println("Find Product Made by : GOOGLE");
        printObject(electronics.groupByCompanyName(Company.GOOGLE));
        System.out.println("Find Product Made by : SAMSUNG");
        printObject(electronics.groupByCompanyName(Company.SAMSUNG));

        System.out.println("\nFind by AuthMethod\n");
        System.out.println("Find Product by Provide AuthMethod : FOOT");
        printObject(electronics.groupByAuthMethod(AuthMethod.FOOT));
        System.out.println("Find Product by Provide AuthMethod : Pattern");
        printObject(electronics.groupByAuthMethod(AuthMethod.PATTERN));



        System.out.println("\n\nUse Array");
        //find by user ID
        System.out.println("Find by User ID\n");
        System.out.println("Find User ID : tester10");
        printObject(users.findByUserIdFromArray("tester10"));
        System.out.println("Find User ID : tester01");
        printObject(users.findByUserIdFromArray("tester01"));
        //find by product number
        System.out.println("\nFind by Product No\n");
        System.out.println("Find Product No : 2101210001");
        printObject(Arrays.asList(electronics.findByProductNoFromArray("2104210001")));
        System.out.println("Find Product No : 2101210005");
        printObject(Arrays.asList(electronics.findByProductNoFromArray("2104210005")));

        //find by Company
        System.out.println("\nFind by Company\n");
        System.out.println("Find Product Made by : GOOGLE");
        printObject(Arrays.asList(electronics.groupByCompanyNameFromArray(Company.GOOGLE)));
        System.out.println("Find Product Made by : SAMSUNG");
        printObject(Arrays.asList(electronics.groupByCompanyNameFromArray(Company.SAMSUNG)));


        //find by AuthMethod
        System.out.println("\nFind by AuthMethod\n");
        System.out.println("Find Product by Provide AuthMethod : FOOT");
        printObject(electronics.groupByAuthMethod(AuthMethod.FOOT));
        System.out.println("Find Product by Provide AuthMethod : Pattern");
        printObject(Arrays.asList(electronics.groupByAuthMethodFromArray(AuthMethod.PATTERN)));



    }

    public static void printObject(Object o){
        //print object values if Object != null
        if(o!=null){
            System.out.println(o.toString());
        }
    }
}
