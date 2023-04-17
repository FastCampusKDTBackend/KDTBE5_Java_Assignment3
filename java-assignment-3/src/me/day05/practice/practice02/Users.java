package me.day05.practice.practice02;

import me.day05.practice.practice01.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Users {
    private static Users instance = null;
    private User[] userList;

    private Users() {
        userList = new User[10];
    }

    public static Users getInstance() {
        if (instance==null) {
            instance = new Users();
        }
        return instance;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Arrays.equals(userList, users.userList);
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public User findByUserId(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) return user;
        }
        return null;
    }

    public User copy(User user) {
        String userId = user.getUserId();
        String userPassword = user.getUserPassword();
        int userPhoneNumber = user.getUserPhoneNumber();
        String userEmail = user.getUserEmail();
        int userBirthDate = user.getUserBirthDate();
        ArrayList<String> electronicDevices = new ArrayList<>(user.getElectronicDevices());
        User dummyUser = new User(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, electronicDevices);
        dummyUser.setRegisterTime(user.getRegisterTime());
        return dummyUser;
    }
}
