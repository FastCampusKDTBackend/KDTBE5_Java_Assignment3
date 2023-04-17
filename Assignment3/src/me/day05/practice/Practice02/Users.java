package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.util.Arrays;
import java.util.Objects;

public class Users {

    private  User[] userList;        
    private static Users instance;

    private Users() {}

    public static Users getInstance() {
        if(instance == null) instance = new Users();

        return instance;
    }

    User findByUserId(String userId) {
        for(User user : userList) {
            if(user.getUserId().equals(userId))
                return user;
        }
        return null;
    }

    User copy(User user) {
        User userCopy = new User(user.getUserId(), user.getUserPassword(), user.getUserPhoneNumber()
                , user.getUserEmail(), user.getUserBirthDate(), user.getElectronicDevices());
        return userCopy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Users)) return false;

        Users list = (Users)obj;
        return Arrays.equals(userList, list.userList);
    }

    @Override
    public String toString() {
        return "{userList:" + Arrays.toString(userList) + "}";
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }
}
