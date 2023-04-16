package me.day05.practice;

import java.time.LocalDate;
import java.util.Arrays;

// 싱글톤은 단일 객체라 hashCode(), equals()가 필요 없음
public class Users {

    private static final int DEFAULT_CAPACITY = 10;
    private User[] userList;
    private int size;

    private Users() {
       this.userList = new User[DEFAULT_CAPACITY];
       this.size = 0;
    }

    private static final class InstanceHolder {
        static final Users INSTANCE = new Users();
    }

    public static Users getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private int findIdxByUserId(String userId) {
        for (int i = 0; i < this.size; ++i) {
            User user = this.userList[i];
            if (user.getUserId().equals(userId)) {
                return i;
            }
        }
        return -1;
    }

    public User findByUserId(String userId) {
        int idx = findIdxByUserId(userId);
        if (idx < 0) return null;
        return this.userList[idx];
    }

    public User copy(User user) {
        // 불변 객체들은 그대로 가져온다.
        String id = user.getUserId();
        String password = user.getUserId();
        String phoneNumber = user.getUserPhoneNumber();
        String email = user.getUserEmail();
        LocalDate birthDay = user.getUserBirthDay();

        // 배열을 복사할 때는 내부 객체 하나하나 일일이 복사한다.
        Electronic[] electronics = user.getElectronicDevices();
        Electronic[] copiedElectronics = new Electronic[electronics.length];
        for (int i = 0; i < electronics.length; ++i) {
            copiedElectronics[i] = electronics[i].clone();
        }

        return new User(user.getUserId(),
                        user.getUserPassword(),
                        user.getUserPhoneNumber(),
                        user.getUserEmail(),
                        user.getUserBirthDay(),
                        copiedElectronics);
    }

    public void addUser(User user) {
        if (this.size == this.userList.length) {
            resize(this.size << 1);
        }

        this.userList[size++] = user;
    }

    public User removeUserById(String userId) {
        int idx = findIdxByUserId(userId);
        if (idx < 0) {
            return null;
        }

        User ret = this.userList[idx];
        for (int i = idx + 1; i < this.size; ++i) {
            this.userList[i-1] = this.userList[i];
        }
        this.size--;

        return ret;
    }

    private void resize(int newLength) {
        this.userList = Arrays.copyOf(this.userList, newLength);
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        for (User user : userList) {
            sb.append(user).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }
}
