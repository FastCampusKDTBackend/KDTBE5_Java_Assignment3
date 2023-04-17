package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.util.Arrays;

public class Users {
    private User[] userList;
    private static Users instance = null;

    private Users(){
    };

    public static Users getInstance() {
        if(instance == null) {
            instance = new Users();
        }
        return instance;
    }

    public User findByUserId(String userId) {
        for(User user : userList) {
            if(userId.equals(user.getUserId())) {
                return user;
            }
        }
        return null;
    }

    public User copy(User user) {
        User copyUser = new User();
        copyUser.setUserId(user.getUserId());
        copyUser.setUserPassword(user.getUserPassword());
        copyUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copyUser.setUserEmail(user.getUserEmail());
        copyUser.setUserBirthDate(user.getUserBirthDate());
        copyUser.setElectronicDevices(Arrays.copyOf(user.getElectronicDevices(), user.getElectronicDevices().length));
        return copyUser;
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
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
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }
}
