package me.day05;

import java.util.Arrays;

public enum Users {

    INSTANCE;

    private User[] userList;

    public User findByUserId(String userId) {
        for(int i = 0; i < userList.length; i++) {
            if (userId.equals(userList[i].getUserId())) {
                return userList[i];
            }
        }
        return null;
    }

    public User Copy(User user) {
        User copyUser = new User();
        copyUser.setUserId(user.getUserId());
        copyUser.setUserEmail(user.getUserEmail());
        copyUser.setUserPassword(user.getUserPassword());
        copyUser.setUserBirthDate(user.getUserBirthDate());
        copyUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copyUser.setElectronicDevices(Arrays.copyOf(user.getElectronicDevices(), user.getElectronicDevices().length));
        return copyUser;
    }

}
