package me.day05.practice.NonArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Electronics deviceList = Electronics.getInstance();
        Electronic device01 = new Electronic("APPLE_TV", Electronic.CompanyName.APPLE, LocalDateTime.now(), new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT});
        Electronic device02 = new Electronic("LG_TV", Electronic.CompanyName.LG, LocalDateTime.now(), new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT});
        Electronic device03 = new Electronic("SAMSUNG_TV", Electronic.CompanyName.SAMSUNG, LocalDateTime.now(), new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT});
        Electronic device04 = new Electronic("MAC", Electronic.CompanyName.APPLE, LocalDateTime.now(), new Electronic.AuthMethod[]{});
        Electronic device05 = new Electronic("GRAM", Electronic.CompanyName.LG, LocalDateTime.now(), new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.PATTERN});
        Electronic device06 = new Electronic("ODYSSEY", Electronic.CompanyName.SAMSUNG, LocalDateTime.now(), new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT});
        Electronic device07 = new Electronic("IPHONE", Electronic.CompanyName.APPLE, LocalDateTime.now(), new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.FACE});
        Electronic device08 = new Electronic("GALAXY", Electronic.CompanyName.SAMSUNG, LocalDateTime.now(), new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.FACE});
        Electronic device09 = new Electronic("G", Electronic.CompanyName.LG, LocalDateTime.now(), new Electronic.AuthMethod[]{Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.PIN});
        deviceList.addDevice(device01);
        deviceList.addDevice(device02);
        deviceList.addDevice(device03);
        deviceList.addDevice(device04);
        deviceList.addDevice(device05);
        deviceList.addDevice(device06);
        deviceList.addDevice(device07);
        deviceList.addDevice(device08);
        deviceList.addDevice(device09);
        deviceList.showDeviceList();
        System.out.println();

        Users userList = Users.getInstance();
        User user01 = new User("user01", "user01!", "010-0101-0101", "user01@gmail.com", "19101010");
        User user02 = new User("user02", "user02!", "010-0202-0202", "user02@gmail.com", "19202020");
        User user03 = new User("user03", "user03!", "010-0303-0303", "user03@gmail.com", "19303030");
        User user04 = new User("user04", "user04!", "010-0404-0404", "user04@gmail.com", "19404040");
        User user05 = new User("user05", "user05!", "010-0505-0505", "user05@gmail.com", "19505050");
        userList.addUser(user01);
        userList.addUser(user02);
        userList.addUser(user03);
        userList.addUser(user04);
        userList.addUser(user05);
        userList.showUserList();

        System.out.println("==========================================================================");

        //2-2
        System.out.println(userList.findByUserId("user04"));
        //2-3
        User copiedUser = user01.copy();
        System.out.println("copied user01\n" + copiedUser);
        //3-2
        System.out.println(deviceList.findByProductNo("2304190004"));
        //3-3
        Electronic[] groupedByCompany = deviceList.groupByCompanyName(Electronic.CompanyName.APPLE);
        for(int i = 0; i < groupedByCompany.length; i++) {
            System.out.println(groupedByCompany[i]);
        }
        System.out.println();
        //3-4
        Electronic[] groupedByAuth = deviceList.groupByAuthMethod(Electronic.AuthMethod.FINGERPRINT);
        for (int i = 0; i < groupedByAuth.length; i++) {
            System.out.println(groupedByAuth[i]);
        }
    }
}