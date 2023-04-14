package me.day05.practice.Practice02;

import java.util.Arrays;
import java.util.Optional;

public class Users {
    private static Users instance;
    private static User[] userList;

    private Users() {
    }
    public static Users getInstance() {
        if(instance==null) {
            instance = new Users();
        }
        return instance;
    }

    public Optional<User> findByUserId(String userId){
        return Arrays.stream(userList).filter(x->x.getUserId()==userId).findFirst();
    }

    // User 클래스에 Object.clone() override함
    public User copy(User user) throws CloneNotSupportedException {
        User newUser= (User) user.clone();
        return newUser;
    }

    public static User[] getUserList() {
        return userList;
    }

    public static void setUserList(User[] userList) {
        Users.userList = userList;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Users{}";
    }
}
