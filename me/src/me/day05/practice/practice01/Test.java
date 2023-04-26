package me.day05.practice.practice01;

import me.day05.practice.practice02.Users;

public class Test {

	public static void main(String[] args) {
		
		User kil = new User("k1m2njun", "alsals");
		kil.setUserBirthDate("19901109");
		kil.setUserEmail("k1m2njun@naver.com");

		Electronic a = new Electronic("애플", Company.APPLE, AuthMethod.얼굴인증);
		Electronic b = new Electronic("삼성", Company.APPLE, AuthMethod.얼굴인증);
		kil.addElectronicDevices(a);
		kil.addElectronicDevices(b);
		
		System.out.println(kil.toString()); // k1m2njun, 19901109, k1m2njun@naver.com, 사용중인 제품 수 2
		System.out.println(kil.getElectronicDevices().get(1).getProductNo()); // 202304160002
		System.out.println(kil.getElectronicDevices().get(0).getProductNo()); // 202304160001
		
		User hong = new User("hhhhhhhh", "alsals");
		hong.setUserBirthDate("19101009");
		hong.setUserEmail("hhhhhhh@naver.com");

		Electronic ap = new Electronic("애플1", Company.APPLE, AuthMethod.얼굴인증);
		Electronic ss = new Electronic("삼성2", Company.APPLE, AuthMethod.얼굴인증);
		hong.addElectronicDevices(ap);
		hong.addElectronicDevices(ss);
		
		Users users = Users.gerInstance();
		users.addUsers(hong);
		users.addUsers(kil);
		
		// User copy
		System.out.println(users.toString());
		User hong2 = users.copy(hong);
		
		Electronic sss = new Electronic("삼성2", Company.APPLE, AuthMethod.얼굴인증);
		hong2.addElectronicDevices(sss);
		
		System.out.println(hong2.toString());
		System.out.println(hong.toString());
	}

}
