package me.day05.practice;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Electronics electronics = Electronics.getInstance();
        Users users = Users.getInstance();

        System.out.println("======================");
        System.out.println("Duplication Test");


        //initialize Electronics for test
        electronics.initElectronics();
        //initialize Users for test
        users.initUsers();

        Electronic electronic;


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


        //find by product number
        System.out.println("\n\n\n======================");
        System.out.println("Find by Product No\n");
        electronic = electronics.findByProductNo("2101210001");
        printObject(electronic);
        System.out.println("Find Product No : 2104210001");
        electronic = electronics.findByProductNo("2104210001");
        printObject(electronic);


        //find by Company
        System.out.println("\nFind by Company\n");
        printObject(electronics.groupByCompanyName(Company.GOOGLE));
        System.out.println("Find Product Made by : SAMSUNG");
        printObject(electronics.groupByCompanyName(Company.SAMSUNG));

        //find by AuthMethod
        System.out.println("\nFind by AuthMethod\n");
        printObject(electronics.groupByAuthMethod(AuthMethod.FOOT));
        System.out.println("Find Product by Provide AuthMethod : Pattern");
        printObject(electronics.groupByAuthMethod(AuthMethod.PATTERN));

    }

    public static void printObject(Object o){
        //print object values if Object != null
        if(o!=null){
            System.out.println(o.toString());
        }
    }
}
