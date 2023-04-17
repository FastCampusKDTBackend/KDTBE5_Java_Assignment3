package me.day05.practice.Practice01;

public class MainTest {
    public static void main(String[] args) {
        Electronic SMonitor = new Electronic("Monitor", Company.SAMSUNG, AuthMethod.FACE);
        Electronic IMac = new Electronic("Mac", Company.APPLE, AuthMethod.FINGERPRINT);
        Electronic Gram = new Electronic("Gram", Company.LG, AuthMethod.PIN);

        User user01 = new User("Kim", "1234qwer", "01012345678", "Kim@naver.com", 19950927, Gram);
        User user02 = new User("Park", "qwer1234asdf", "01012345678", "Park@mail.com", 19920901, null );

        IMac.setAuthMethod(AuthMethod.PATTERN);
        Gram.setAuthMethod(AuthMethod.FACE);

        user02.addElectronicDevices(SMonitor);
        user02.addElectronicDevices(IMac);

        System.out.println(user01);
        System.out.println(user02);

    }
}
