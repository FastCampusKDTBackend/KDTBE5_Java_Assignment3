package me.day05.practice;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // for electronics
        Electronics electronics = Electronics.getInstance();
        Electronic m1Air = new Electronic("Apple 2020 MacBook Air", Company.APPLE, new AuthMethod[] {AuthMethod.FINGERPRINT, AuthMethod.PIN});
        electronics.addElectronic(m1Air);

        Electronic iphone7 = new Electronic("Apple iPhone 7", Company.APPLE, new AuthMethod[] {AuthMethod.FINGERPRINT, AuthMethod.PIN, AuthMethod.PATTERN});
        electronics.addElectronic(iphone7);

        Electronic iphone12mini = new Electronic("Apple iPhone 12 mini", Company.APPLE, new AuthMethod[] {AuthMethod.FINGERPRINT, AuthMethod.PATTERN, AuthMethod.PIN, AuthMethod.FACE});
        electronics.addElectronic(iphone12mini);

        Electronic galaxyS23 = new Electronic("Samsung Galaxy S23", Company.SAMSUNG, new AuthMethod[]{AuthMethod.FINGERPRINT, AuthMethod.PATTERN, AuthMethod.PIN, AuthMethod.FACE});
        electronics.addElectronic(galaxyS23);

        Electronic galaxyTabA7 = new Electronic("Samsung Galaxy Tab A7 Lite 8.7", Company.SAMSUNG, new AuthMethod[] {AuthMethod.FINGERPRINT, AuthMethod.PATTERN, AuthMethod.PIN});
        electronics.addElectronic(galaxyTabA7);


        // for users
        Users users = Users.getInstance();

        User user01 = new User("fc-be5-01", "1234");
        user01.setElectronicDevices(new Electronic[] {m1Air, iphone7});
        users.addUser(user01);

        User user02 = new User("fc-be5-02", "1234");
        user02.setElectronicDevices(new Electronic[] {galaxyS23});
        users.addUser(user02);

        User user03 = new User("fc-be5-03", "1234");
        user03.setElectronicDevices(new Electronic[] {iphone12mini, galaxyTabA7});
        users.addUser(user03);

        // test getInstance() (singleton)
        assert Users.getInstance() == users;
        assert Electronics.getInstance() == electronics;

        // test findByUserId()
        assert users.findByUserId("fc-be5-02") == user02;
        assert users.findByUserId("fc-be5-04") == null;

        // test copy()
        User copiedOfUser03 = users.copy(user03);
        assert copiedOfUser03 != user03;
        assert copiedOfUser03.equals(user03);
        assert copiedOfUser03.getUserEmail().equals(user03.getUserEmail());
        copiedOfUser03.setUserEmail("test@mail.com");
        assert !copiedOfUser03.getUserEmail().equals(user03.getUserEmail());

        // test findByProductNo()
        String productNoOfM1Air = m1Air.getProductNo();
        assert electronics.findByProductNo(productNoOfM1Air) == m1Air;

        // test groupByCompanyName
        System.out.println("Electronic Devices Of Apple: " + Arrays.toString(electronics.groupByCompanyName(Company.APPLE)));
        System.out.println("Electronic Devices Of Samsung: " + Arrays.toString(electronics.groupByCompanyName(Company.SAMSUNG)));
        System.out.println("Electronic Devices Of LG: " + Arrays.toString(electronics.groupByCompanyName(Company.LG)));

        // test groupByAuthMethod
        System.out.println("Electronic Devices with Face Auth: " + Arrays.toString(electronics.groupByAuthMethod(AuthMethod.FACE)));
        System.out.println("Electronic Devices with Fingerprint Auth: " + Arrays.toString(electronics.groupByAuthMethod(AuthMethod.FINGERPRINT)));
    }

}
