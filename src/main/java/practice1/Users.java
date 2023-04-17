package practice1;

import java.util.Arrays;

public class Users {
    private static Users users;
    private User[] userList;

    private static final int DEFAULT_CAPACITY = 50;

    private Users() {
        userList = new User[DEFAULT_CAPACITY];
    }

    public Users getInstance() {
        if (users == null) {
            users = new Users();
        }
        return users;
    }

    public User findByUserId(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        throw new IllegalArgumentException(userId + "를 가진 user를 찾을 수 없습니다.");
    }

    public User copy(User user) {
        User copiedUser = new User(user.getUserId(), user.getUserPassword(), user.getUserPhoneNumber(),
                user.getUserEmail(), user.getUserBirthDate());

        copiedUser.setRegisterTime(user.getRegisterTime());

        return copiedUser;
    }

    public static Users getUsers() {
        return users;
    }

    public static void setUsers(Users users) {
        Users.users = users;
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
