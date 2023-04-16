package practice02;

import Practice01.Electronic;
import Practice01.User;

import java.util.Arrays;

public class Users {

    private static Users users;
    private User[] userList; //생성된 User 객체들을 모두 저장
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;

    public static Users getInstance() {
        if (users == null) {
            users = new Users();
        }
        return users;
    }


    public Users() {
        userList = new User[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public User findByUserId(String userId) {
        if (userId == null) return null;

        //생성된 User 객체 배열에서 인자로 받은 userId를 검색하여 일치하면 반환
        for (User user : userList) {
            if (user == null) continue;
            if (user.getUserId().equals(userId)) return user;
        }
        return null;
    }

    public User copy(User user) { //User 객체 복사
        if (user == null) return null;
        int size = user.getElectronicDevices().length;

        //String과 LocalDate는 셍성자를 이용해서 복사
        User copyUser = new User(user.getUserId(), user.getUserPassword(), user.getUserPhoneNumber(),
                user.getUserEmail(), user.getUserBirthDate());

        //user가 사용중인 전자제품의 배열을 깊은 복사로 넘겨주기 위한 작업
        Electronic[] usingDevices = new Electronic[size];

        for (int i = 0; i < size; i++) {
            usingDevices[i] = user.getElectronicDevices()[i];
        }
        copyUser.setElectronicDevices(usingDevices);

        return copyUser;
    }

    public void add(User user) {
        if (size < capacity) {
            userList[size] = user;
            size++;
        } else {
            extendArray();
            add(user);
        }
    }

    private void extendArray() {
        capacity *= 2;
        userList = Arrays.copyOf(userList, capacity);
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
