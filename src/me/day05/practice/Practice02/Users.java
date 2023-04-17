package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.util.Arrays;

public class Users {
    private static Users instance;
    private User[] userList;
    private Users() {
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
        for (User userInfo : userList) {
            if (userInfo.getUserId().equals(userId)) {
                return userInfo;
            }
        }
        return null;
    }

    public User Copy(User user) {
        User copiedUser = new User();
        copiedUser.setUserId(user.getUserId());
        copiedUser.setUserEmail(user.getUserEmail());
        copiedUser.setUserPassword(user.getUserPassword());
        copiedUser.setUserBirthDate(user.getUserBirthDate());
        copiedUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copiedUser.setElectronicDevices(Arrays.copyOf(user.getElectronicDevices(), user.getElectronicDevices().length));
        return copiedUser;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Users{}";
    }
}