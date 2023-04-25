package me.day05.practice.ArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Users userList = Users.getInstance();
        Electronics deviceList = Electronics.getElectronicsInstance();
        System.out.print("Electronics Companies : ");
        for(Company company : Company.values()) {
            System.out.print(company.getCompanyName() + " ");
        }
        System.out.println();
        System.out.print("AuthMethods : ");
        for(AuthMethod authMethod : AuthMethod.values()) {
            System.out.print(authMethod.getAuthMethod() + " ");
        }
        System.out.println();

        //사용자 추가
        User user01 = new User("user01", "user01!", "01001010101", "user01@gmail.com", "19990908");
        User user02 = new User("user02", "user02!", "01002020202", "user02@gmail.com", "19990902");
        userList.addUser(user01);
        //기기 추가
        Electronic TV1 = new Electronic("TV-01", Company.SAMSUNG, AuthMethod.PIN);
        Electronic Mac1 = new Electronic("Mac-01", Company.APPLE, AuthMethod.FINGERPRINT);
        Electronic Vaccum1 = new Electronic("VaccumCleaner-01", Company.LG);
        Electronic TV2 = new Electronic("TV-01", Company.SAMSUNG, AuthMethod.PIN);
        Electronic Mac2 = new Electronic("Mac-01", Company.APPLE, AuthMethod.FINGERPRINT);
        Electronic Vaccum2 = new Electronic("VaccumCleaner-01", Company.LG);
        Electronic TV3 = new Electronic("TV-01", Company.SAMSUNG, AuthMethod.PIN);
        Electronic Mac3 = new Electronic("Mac-01", Company.APPLE, AuthMethod.FINGERPRINT);
        Electronic Vaccum3 = new Electronic("VaccumCleaner-01", Company.LG);

        deviceList.addDevice(TV1);
        deviceList.addDevice(TV2);
        deviceList.addDevice(TV3);
        deviceList.addDevice(Mac1);
        deviceList.addDevice(Mac2);
        deviceList.addDevice(Mac3);
        deviceList.addDevice(Vaccum1);
        deviceList.addDevice(Vaccum2);
        deviceList.addDevice(Vaccum3);

        user01.addElectronicDevices(TV1);
        user01.addElectronicDevices(TV2);
        user01.addElectronicDevices(TV3);
        user01.addElectronicDevices(Mac1);
        user01.addElectronicDevices(Mac2);
        user01.addElectronicDevices(Mac3);
        user01.addElectronicDevices(Vaccum1);
        user01.addElectronicDevices(Vaccum2);
        user01.addElectronicDevices(Vaccum3);

        System.out.println(deviceList.findByProductNo("2304120009"));

//        ArrayList<Electronic> test = new ArrayList<>();
//        test = deviceList.groupByCompanyName(Company.APPLE);
//        for(Electronic test1 : test) {
//            System.out.println(test1);
//        }

        ArrayList<Electronic> authTest = new ArrayList<>();
        authTest = deviceList.groupByAuthMethod(AuthMethod.FINGERPRINT);
        for(Electronic test2 : authTest) {
            System.out.println(test2);
        }

        System.out.println(deviceList.getElectronicList().get(0).getAuthMethod().get(0));
        System.out.println(AuthMethod.PIN);
        System.out.println(deviceList.getElectronicList().get(0).getCompanyName());
        System.out.println(Company.SAMSUNG);
    }
}