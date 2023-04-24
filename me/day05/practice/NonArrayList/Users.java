package me.day05.practice.NonArrayList;
import java.util.Arrays;

public class Users {
    private static Users usersInstance;

    public static Users getInstance() {
        if (usersInstance == null) {
            usersInstance = new Users();
        }
        return usersInstance;
    }

//    private Users() {
//    }

    //SINGLETON
    private User[] userList;
    private int index = 0;
    //기본10명으로 설정
    private static int listSize = 10;

    private Users() {
        userList = new User[listSize];
    }

    public User[] getUserList() {
        return userList;
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

    public void addUser(User user) {
        userList[index] = user;
        index++;
        System.out.println(user.getUserId() + "Added");
    }

    public void showUserList() {
        for(int i = 0; i < userList.length; i++) {
            if(userList[i] == null) return;
            System.out.println(userList[i]);
        }
    }

    public User findByUserId(String userId) {
        for(int i = 0; i < listSize; i++) {
            if(userList[i].getUserId() == userId) return  userList[i];
        }
        System.out.println("Found Nothing");
        return null;
    }
}