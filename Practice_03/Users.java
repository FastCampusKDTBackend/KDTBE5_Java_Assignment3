package Practice_03;

import java.util.*;

public class Users {
    private static Users instance;
    private User[] userList;

    private Users() {
    }

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

    public User findByUserId(String userId) {
        if (userList == null) {
            return null;
        }
        for (User userInfo : userList) {
            if (userInfo.getUserId().equals(userId)) {
                return userInfo;
            }
        }
        return null;
    }

    public User copy(User user) {
        User copiedUser = new User();
        copiedUser.setUserId(user.getUserId());
        copiedUser.setUserEmail(user.getUserEmail());
        copiedUser.setUserPassword(user.getUserPassword());
        copiedUser.setUserBirthDate(user.getUserBirthDate());
        copiedUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copiedUser.setElectronicDevices(Arrays.copyOf(user.getElectronicDevices(), user.getElectronicDevices().length));
        return copiedUser;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Users users = (Users) object;
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
