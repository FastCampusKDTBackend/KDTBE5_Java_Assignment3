package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.util.Arrays;


public class Users {
    private static Users instance = null;
    private User[] userList;

    private Users() {
        userList = new User[0];
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

    @Override
    public int hashCode() {
        return Arrays.hashCode(userList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Users users = (Users) obj;
        return Arrays.equals(userList, users.userList);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }

    public User findByUserId(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
    public User Copy(User user) {
        User userCopy = new User(user.getUserId(), user.getUserPassword(), user.getUserPhoneNumber(),
                user.getUserEmail(), user.getUserBirthDate(), user.getElectronicDevices());
        return userCopy;
    }
}