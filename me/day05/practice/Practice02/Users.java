package me.day05.practice.Practice02;

import me.day05.practice.Practice01.Electronic;
import me.day05.practice.Practice01.User;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * - 객체 배열 `User[] userList`를 필드로 있는 `Users` 클래스를 작성하시오.
 *     - 필드 - User[] userList (생성된 User 객체들을 모두 저장)
 *     - 메소드 - 생성자, getter(), setter(), hashCode(), equals(), toString()
 * - `Users` 클래스를 통해 아래의 문제를 해결해보세요.
 *     1. `Users` 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
 *     -> Users getInstance();
 *     2. 회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성하시오.
 *     -> User findByUserId(String userId);
 *     3. 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.
 *     -> User findByUserId(String userId);
 */
public class Users {
    private User [] userList; //생성된 User 객체들을 모두 저장
    private static Users instance;


    private Users () {}

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }
     //2. 회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성.
    public User findByUserId(String userId) {
        if (userId == null) return null;

        for (User user : userList) {
            if (user == null) continue;
            if (user.getUserId().equals(userId)) return user;
        }
        return null;
    }

    public User copy(User user) {
        if (user == null) return null;
        int userListsize = user.getElectronicDevices().size();

        User copyUser = new User(user.getUserId(), user.getUserPassword(), user.getUserPhoneNumber(), user.getUserEmail(), user.getUserBirthDate());

        ArrayList<Electronic> usingDevices = new ArrayList<Electronic>();

        for (int i = 0; i < userListsize; i++) {
            usingDevices.add(user.getElectronicDevices().get(i));
        }
        copyUser.setElectronicDevices(usingDevices);

        return copyUser;
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
