package me.day05.practice.practice01;

public class Test {

	public static void main(String[] args) {
		
		User kil = new User("k1m2njun", "alsals");
		kil.setUserBirthDate("19901109");
		kil.setUserEmail("k1m2njun@naver.com");

		Electronic a = new Electronic("홍홍", Company.APPLE, AuthMethod.얼굴인증);
		Electronic b = new Electronic("홍홍1", Company.APPLE, AuthMethod.얼굴인증);
		kil.addElectronicDevices(a);
		kil.addElectronicDevices(b);
		
		System.out.println(kil.toString()); // k1m2njun, 19901109, k1m2njun@naver.com, 사용중인 제품 수 2
		System.out.println(kil.getElectronicDevices().get(1).getProductNo()); // 202304160002
		System.out.println(kil.getElectronicDevices().get(0).getProductNo()); // 202304160001
		
	}

}
