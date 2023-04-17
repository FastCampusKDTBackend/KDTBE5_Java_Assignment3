package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.util.Arrays;
import java.util.Objects;

public class Users {

    User[] userList;        //User ��ü���� ��� �����ϴ� �迭

    //1.Users Ŭ������ ��ü�� �̱������� �����ϴ� �Լ��� �ۼ��Ͻÿ�.
    private static Users instance;

    private Users() {}

    public static Users getInstance() {
        if(instance == null) instance = new Users();

        return instance;
    }

    //2.ȸ�� ���̵� userId�� ���� ���ڷ� �־��� ȸ����ȣ�� �ش��ϴ� ȸ���� ��ȯ�ϴ� �Լ��� �ۼ��Ͻÿ�.
    User findByUserId(String userId) {
        for(User user : userList) {
            if(user.getUserId().equals(userId))
                return user;
        }
        return null;
    }

    //3.���ڷ� �־��� ȸ�� ������ ���� ���� (deepCopy) �ϴ� �Լ��� �ۼ��Ͻÿ�.
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
