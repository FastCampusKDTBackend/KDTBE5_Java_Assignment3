package me.day05.practice.NonArrayList;

import java.util.Arrays;

public class Users implements ObjectList<User> {
    private static Users usersInstance;

    public static Users getInstance() {
        if (usersInstance == null) {
            usersInstance = new Users();
        }
        return usersInstance;
    }

    //SINGLETON
    private static int listSize = 10;
    private User[] userList;
    private int index = 0;

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
        return "pratice.NonArrayList.Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }

    public void showUserList() {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i] == null) return;
            System.out.println(userList[i]);
        }
    }

    public User findByUserId(String userId) {
        User target = Arrays.stream(userList)
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);

        if (target == null) {
            throw new NullPointerException(userId + "Not Found");
        }

        return target;
    }

    public User copy(User user) {
        User copiedUser = new User(
                user.getUserId(),
                user.getUserPassword(),
                user.getUserPhoneNumber(),
                user.getUserEmail(),
                user.getUserBirthDate(),
                user.getRegisterTime()
        );
        if (user.getElectronicDevices() == null) {
            copiedUser.setElectronicDevices(null);
        } else {
            Electronic[] copiedList = new Electronic[user.getElectronicDevices().length];
            for (int i = 0; i < user.getElectronicDevices().length; i++) {
                copiedList[i] = user.getElectronicDevices()[i];
            }
            copiedUser.setElectronicDevices(copiedList);
        }
        return copiedUser;
    }

    @Override
    public void add(User user) {
        userList[index] = user;
        index++;
        System.out.println(user.getUserId() + "Added");
    }

    @Override
    public void grow() {
        if (index == listSize) {
            userList = Arrays.copyOf(userList, listSize * 2);
        }
    }

    @Override
    public int size() {
        return index;
    }

}
