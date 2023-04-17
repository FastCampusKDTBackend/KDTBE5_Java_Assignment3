package me.day05.practice.Practice02;

import me.day05.practice.Practice01.Electronic;
import me.day05.practice.Practice01.User;

import java.util.Arrays;

public class Users {

    private static Users usersInstance;

    private Users(){
    }

    //1.싱글톤

    public static Users getInstance() {
        if(usersInstance==null) {
            usersInstance = new Users();
        }
        return usersInstance;
    }

    public static Users getUsersInstance() {
        return usersInstance;
    }

    public static void setUsersInstance(Users usersInstance) {
        Users.usersInstance = usersInstance;
    }

    private User[] userList;

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }


    //2. 함수 반환
    public User findByUserId(String userId) {
        for(User user : userList) {
            if(user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    //3. deep copy?

    public User copy(User user) {
        User copyUser = new User(user.getUserId(),
                user.getUserPassword(),
                user.getUserEmail(),
                user.getUserPhoneNumber(),
                user.getUserBirthDate(),
                user.getElectronicDevices().get(1));
        return copyUser;
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
