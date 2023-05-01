package me.day05.practice.practice01;



public class Main {
    public static void main(String[] args) {
        Electronic a1 = new Electronic("javis", Company.SAMSUNG, "", new AuthMethod[]{AuthMethod.PIN});
        System.out.println(a1.toString());
        Electronic a2 = new Electronic("havis", Company.SAMSUNG, "20000121", new AuthMethod[]{AuthMethod.PIN});
        System.out.println(a2.toString());

        User m1 = new User("fallen", "page7", "010-2222-3333", "ast@gmail.com", "060220", new String[]{"hell"});
        System.out.println(m1.toString());
    }
}
