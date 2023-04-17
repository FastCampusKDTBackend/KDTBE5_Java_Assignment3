package me.day05.practice.practice02;

import me.day05.practice.practice01.User;
import java.util.Arrays;

public class Users {
    private static Users users;
    private User[] userList;

    //1.Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    public static Users getInstance() {
        if (users == null) {
            users = new Users();
        }
        return users;    }
    //2.회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성하시오.
    public User findByUserId(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
    //3.인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.
    public User copy(User user) {
        User UserCopy = new User(
                user.getUserId(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserBirthDate(),
                user.getUserPhoneNumber(),
                user.getElectronicDevices());
        return UserCopy;
    }


    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public Users(User[] userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Arrays.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(userList);
    }

    @Override
    public String toString() {
        return "{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }
}