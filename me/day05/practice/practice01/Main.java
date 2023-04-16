package me.day05.practice.practice01;



public class Main {
    public static void main(String[] args) {
        Electronic a1 = new Electronic("javis", Electronic.CompanyName.SAMSUNG, "20000120", new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN});
        System.out.println(a1.toString());
        Electronic a2 = new Electronic("havis", Electronic.CompanyName.SAMSUNG, "20000121", new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN});
        System.out.println(a2.toString());

        User m1 = new User("fallen", "page7", "010-2222-3333", "ast@gmail.com", "060220", new String[]{"hell"});
        System.out.println(m1.toString());
    }
}
