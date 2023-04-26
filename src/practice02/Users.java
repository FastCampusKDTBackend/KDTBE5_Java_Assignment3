package src.practice02;

import src.practice01.User;

import java.util.ArrayList;
import java.util.Objects;

public class Users {
    private ArrayList<User> userList = new ArrayList<>();

    // 싱글톤
    private static Users instance;
    public Users() {}
    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User findByUserId(String userId) {
        for (User user : userList) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }
        return null;
    }

    public User Copy(User user) {
        User copyUser = new User();
        copyUser.setUserId(user.getUserId());
        copyUser.setUserPassword(user.getUserPassword());
        copyUser.setUserEmail(user.getUserEmail());
        copyUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copyUser.setUserBirthDate(user.getUserBirthDate());
        copyUser.setElectronicDevices(user.getElectronicDevices());
        return copyUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + userList +
                '}';
    }
}
