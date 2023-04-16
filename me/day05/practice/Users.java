package day05.practice;

import java.util.Arrays;

public class Users {

    private static Users users;
    private User[] userList;

    public static Users getInstance(){
        if(users == null) users = new Users();
        return users;
    }

    public User findByUserId(String userId) {

        for(int i = 0; i < userList.length; i++) {
            if(userList[i].getUserId().equals(userId)) {
                return userList[i];
            }
        }
        return null;
    }

    public User copy(User user) {
        return new User(
                user.getUserId(),
                user.getUserPassword(),
                user.getUserPhoneNumber(),
                user.getUserEmail(),
                user.getUserBirthDate(),
                user.getElectronicDevices()
        );
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getUserList(), users.getUserList());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getUserList());
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }
}
