package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.util.Arrays;
import java.util.Objects;

public class Users {

    User[] userList;        //User 객체들을 모두 저장하는 배열

    //1.Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    private static Users instance;

    private Users() {}

    public static Users getInstance() {
        if(instance == null) instance = new Users();

        return instance;
    }

    //2.회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성하시오.
    User findByUserId(String userId) {
        for(User user : userList) {
            if(user.getUserId().equals(userId))
                return user;
        }
        return null;
    }

    //3.인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.
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

    //getter&setter
    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }
}
