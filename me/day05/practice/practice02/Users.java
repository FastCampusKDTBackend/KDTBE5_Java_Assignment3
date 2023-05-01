package me.day05.practice.practice02;

import me.day05.practice.practice01.User;

import java.util.Arrays;

public class Users {
    private User[] userList;

    private Users() {

    }

    public User[] getUserList() {
        return userList;
    }

    //1. Users클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    private static Users instance = new Users();

    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }

    public User findByUserId(String userId) {
        return Arrays.stream(userList)
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }



    //3. 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.
    public User copy(User user) {
        User copyuser = new User(user.getUserId(),
                                user.getUserEmail(),
                                user.getUserPassword(),
                                user.getUserBirthDate(),
                                user.getUserPhoneNumber(),
                                user.getElectronicDevices());
        return copyuser;
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
