package me.day05.practice.practice02;

import me.day05.practice.practice01.User;

import java.util.Arrays;

public class Users {
    private static final int DEFAULT_SIZE = 50;
    private static Users instance;
    private User[] userList;

    private Users() {
        userList = new User[DEFAULT_SIZE];
    }

    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }

        return instance;
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public User findByUserId(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        throw new IllegalArgumentException("찾는 " + userId + "는 존재하지 않습니다.");
    }

    public static User copy(User original) {
        User user = new User(
                original.getUserId(),
                original.getUserPassword(),
                original.getUserPhoneNumber(),
                original.getUserEmail(),
                original.getUserBirthDate()
        );
        user.setElectronicDevices(original.getElectronicDevices().clone());
        user.setRegisterTime(original.getRegisterTime());

        return user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Users users = (Users) obj;

        if (userList.length != users.userList.length) return false;
        for (int i = 0; i < users.userList.length; i++) {
            if (!userList[i].equals(users.userList[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(userList);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }
}
