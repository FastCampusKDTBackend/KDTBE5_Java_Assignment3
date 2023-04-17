package KDTBE5_Java_Assignment3.me.practice.Practice02;

import KDTBE5_Java_Assignment3.me.practice.Practice01.User;

import java.util.Arrays;

public class Users {
    private static final Users INSTANCE = new Users();
    public Users() {
    }

    public static Users getINSTANCE() {
        return INSTANCE;
    }

    private User[]  users;


    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Arrays.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(users);
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + Arrays.toString(users) +
                '}';
    }

    public User findUserId(String userId) throws Exception {
        for (User user: this.users) {
            if(user.getUserId().equals(userId))return user;
        }
        throw new Exception("해당 유저 아이디를 가진 유저는 존재하지 않습니다.");
    }


    public User copy(User user){
        User clone = new User();
        String userId = new String(user.getUserId());
        clone.setUserId(userId);
        clone.setUserPassword(user.getUserPassword());
        clone.setUserEmail(user.getUserEmail());
        clone.setUserBirthDate(user.getUserBirthDate());
        clone.setElectronicDevices(user.getElectronicDevices());
        return clone;
    }
}
