package me.day05.practice;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Users {

    private static final int DEFAULT_CAPACITY = 10; // Default initial capacity
    private static final User[] EMPTY_USER_LIST = {};

    private static User[] userList;
    private static Users usersInstance;

    private int size;
    private int capacity;

    private Users(){
        userList = EMPTY_USER_LIST;
    }

    // TODO: 1. Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    public static Users getInstance() {
        if (usersInstance == null) usersInstance = new Users();
        return usersInstance;
    }

    // TODO: 2. 회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성하시오.
    public Optional<User> findById(String userId){
        for (User user : userList)
            if (userId.equals(user.getUserId()))
                return Optional.of(user);

        return Optional.empty();
    }

    // TODO: 3. 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.
    public User copy(User user) {
        User copyUser = findById(user.getUserId()).orElseThrow(NullPointerException::new); // 예외 처리 추가 구현 필요
        return copyUser.clone();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(userList), size, capacity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(hashCode(), ((Users)obj).hashCode());
    }

    @Override
    public String toString() {
        return "Users { " +
                "size=" + size +
                ", capacity=" + capacity +
                ", userList= " + Arrays.toString(userList) + " }";
    }
}
