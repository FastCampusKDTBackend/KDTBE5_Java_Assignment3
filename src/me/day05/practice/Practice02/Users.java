package me.day05.practice.Practice02;
import me.day05.practice.Practice01.User;

import java.util.Arrays;

public class Users {
    private User[] userList;
    private Users() {
    }

    private static Users instance = new Users();

    //2-1 Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성
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

    //2-2 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성
    public User findByUserId(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    //2-3 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성
    public User copy(User original) {
        User user_info = new User(
                original.getUserId(),
                original.getUserEmail(),
                original.getUserPassword(),
                original.getUserBirthDate(),
                original.getUserPhoneNumber(),
                original.getElectronicDevices()
        );
        return user_info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Users users = (Users) obj;
        return Arrays.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(userList);
    }

    @Override
    public String toString() {
        return "{" + "userList=" + Arrays.toString(userList) + "}";
    }
}
