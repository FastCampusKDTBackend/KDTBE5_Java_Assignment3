package ForSubmission.me.day05.practice.Practice01;

public class Main {
    public static void main(String[] args) {
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
        //기기 추가
        Electronic TV = new Electronic("TV-01", Company.SAMSUNG, AuthMethod.PIN);
        Electronic Mac = new Electronic("Mac-01", Company.APPLE, AuthMethod.FINGERPRINT);
        Electronic Vaccum = new Electronic("VaccumCleaner-01", Company.LG);
        Vaccum.setAuthMethod(AuthMethod.PATTERN);
        Mac.setAuthMethod(AuthMethod.FACE);

        user01.addElectronicDevices(TV);
        User user03 = new User("user03", "user03!", "01003030303", "user03@gmail.com", "19990308", Mac);
        user03.addElectronicDevices(Vaccum);

        System.out.println(user01);
        System.out.println(user02);
        System.out.println(user03);
    }
}
