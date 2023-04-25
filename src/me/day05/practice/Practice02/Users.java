package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Users{

    /*
     * Q. Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
     * */
    final int arrSize = 10;
    private User[] userList = new User[arrSize];
    private static Users instance; // 정적 참조 변수

    private Users() {
        // private 생성자
    }

    // 객체 변환 정적 메서드
    public static Users getInstance() {
        if(instance == null){
            instance = new Users();
        }
        return instance;
    }

    public User createUser(String userId, String userPassword){
        User user = new User(userId, userPassword);
        for (int i = 0; i < userList.length; i++){
            if (userList[i] == null){
                userList[i] = user;
                break;
            }
        }
        return user;
    }

    public User createUser(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate, String[] electronicDevices){
        User user = new User(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, electronicDevices);
        for (int i = 0; i < userList.length; i++){
            if (userList[i] == null){
                userList[i] = user;
                break;
            }
        }
        return user;
    }

    /*
    * Q. 회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성하시오.
    * */
    public User findByUserId(String userId){
        User newUser = new User(userId);
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                newUser = user;
                System.out.println(user);
                break;
            }
        }
        return newUser;
    }

    /*
    * Q. 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.*/

    public static User copy(User user) {
        User copiedUser = new User();

        copiedUser.setUserId(user.getUserId());
        copiedUser.setUserPassword(user.getUserPassword());
        copiedUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copiedUser.setUserEmail(user.getUserEmail());
        copiedUser.setUserBirthDate(user.getUserBirthDate());
        copiedUser.setElectronicDevices(user.getElectronicDevices());

        return copiedUser;
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
        return Arrays.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(arrSize);
        result = 31 * result + Arrays.hashCode(userList);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "arrSize=" + arrSize +
                ", userList=" + Arrays.toString(userList) +
                '}';
    }
}
