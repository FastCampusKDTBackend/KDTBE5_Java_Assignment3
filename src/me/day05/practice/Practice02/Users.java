package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.util.ArrayList;
import java.util.Objects;

public class Users {
    private ArrayList<User> userList = new ArrayList<>();

    public Users(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Users () {}
    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public static void setInstance(Users instance) {
        Users.instance = instance;
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

    // Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    private static Users instance;
    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }

        return instance;
    }


    //회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성하시오

    public User findByUserId(String userId) {
        for (User user : userList) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }
        return null;
    }

// 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.
    public User Copy(User user) {
        User userCopy = new User();
        userCopy.setUserId(user.getUserId());
        userCopy.setUserPassword(user.getUserPassword());
        userCopy.setUserEmail(user.getUserEmail());
        userCopy.setUserPhoneNumber(user.getUserPhoneNumber());
        userCopy.setUserBirthDate(user.getUserBirthDate());
        userCopy.setElectronicDevices(user.getElectronicDevices());

        return userCopy;
    }

}
