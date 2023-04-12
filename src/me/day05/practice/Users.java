package me.day05.practice;

import java.util.Arrays;

public class Users {

    private User[] userList; //필드 - User[] userList (생성된 User 객체들을 모두 저장) -> user객체는 다른 곳에서 생성되는걸 가정하는 것이고 여기서는 따로 안해도 되는건가요??

    private Users(){}

    public static Users getInstance() {
        if (instance == null)
            instance = new Users();
        return instance;
    } private static Users instance;

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
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

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public static void setInstance(Users instance) {
        Users.instance = instance;
    }

    public User findByUserId(String UserId){
        for(int i =0; i < userList.length; i++) {
            if(userList[i].getUserId() == UserId)
                return userList[i];
        }
        return null;
    }

    public User copy(User user){
        User copyUser = new User();
        copyUser.setUserId(user.getUserId());
        copyUser.setUserPassword(user.getUserPassword());
        copyUser.setUserEmail(user.getUserEmail());
        copyUser.setUserBirthDate(user.getUserBirthDate());
        copyUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copyUser.setElectronicDevices(user.getElectronicDevices());

         return copyUser;
    }

}
