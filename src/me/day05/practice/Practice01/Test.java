package me.day05.practice.Practice01;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        //checking electronic
        Electronic device1 = new Electronic("iphone13", CompanyName.APPLE, LocalDate.of(2021, 9, 1), new AuthMethod[] {AuthMethod.얼굴인증});
        Electronic device2 = new Electronic("iphone8", CompanyName.APPLE, LocalDate.of(2017, 9, 1), new AuthMethod[] {AuthMethod.지문인증});

        System.out.println(device1);
        System.out.println(device2);
        /* 출력
                Electronic{productNo='2304180001', modelName='iphone13', companyName=APPLE, dateOfMade=2021-09-01, authMethods=[얼굴인증]}
                Electronic{productNo='2304180002', modelName='iphone8', companyName=APPLE, dateOfMade=2017-09-01, authMethods=[지문인증]}
        */

        User user1 = new User("abc", "1234", "010-1111-2222", "abc@efg.com", "010101", new String[] {"device2"});
        System.out.println(user1);

        //출력 Users{userId='abc', userPassword='1234', userPhoneNumber='010-1111-2222', userEmail='abc@efg.com', userBirthDate='010101', electronicDevices=[device2], registerTime=2023-04-18}

    }
}
