package me.day05.practice02;

import me.day05.practice01.User;

import java.util.Arrays;

public class Users {
    private static final int DEFAULT_CAPACITY = 10;
    private static Users instacne;
    private User[] userList;

    private int size, capacity;

    private Users() {
        this.userList = new User[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    //실습2-1. Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    public static Users getInstance() {
        if (instacne == null) {
            instacne = new Users();
        }

        return instacne;
    }
    //

    //region Getter / Setter
    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }
    //endregion

    //region hashCode & equals / toString
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
        String toStr = "";
        for (int i = 0; i < size; i++) {
            toStr += userList[i];
        }

        return toStr;
    }
    //endregion

    //실습2-2. 회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성하시오.
    public User findByUserId(String userId) {
        for (User user : userList) {
            if (user == null) continue;

            if (user.getUserId() == userId) return user;
        }

        return null;
    }
    //

    //실습2-3. 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.
    public User copy(User user) {
        User copyUser = new User();
        copyUser.setUserId(user.getUserId());
        copyUser.setUserPassword(user.getUserPassword());
        copyUser.setUserEmail(user.getUserEmail());
        copyUser.setUserBirthDate(user.getUserBirthDate());
        copyUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copyUser.setElectronicDevices(user.getElectronicDevices());
        copyUser.setRegisterTime(user.getRegisterTime());

        return copyUser;
    }
    //

    public void add(User user) {
        if (size < capacity) {
            userList[size] = user;
            size++;
        } else {
            grow();
            add(user);
        }
    }

    private void grow() {
        capacity *= 2;
        userList = Arrays.copyOf(userList, capacity);
    }
}
