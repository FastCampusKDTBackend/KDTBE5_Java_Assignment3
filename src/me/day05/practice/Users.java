package me.day05.practice;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {

    private static Users instance;
    private User[] users; //필드 - User[] userList (생성된 User 객체들을 모두 저장) -> user객체는 다른 곳에서 생성되는걸 가정하는 것이고 여기서는 따로 안해도 되는건가요??

    private Users(){}

    public static Users getInstance() {
        if (instance == null)
            instance = new Users();

        return instance;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(users) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Arrays.equals(this.users, users.users);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(users);
    }

    public User[] getUserList() {
        return users;
    }

    public void setUserList(User[] userList) {
        this.users = userList;
    }

    public static void setInstance(Users instance) {
        Users.instance = instance;
    }

    public User findByUserId(String UserId){
        //userid가 중복이 없게 처리 해야 될듯
        //스트림에서 컬렉션으로 집계 후, get(0) 이런식으로 사용을 해도 되나??
        //user를 get으로 바로 얻어 오면 얕은 복사??
        //optional로 해도 어차피 trycatch를 사용해야 되나요??
        User user = Arrays.stream(users).filter(u -> u.getUserId() == UserId).collect(Collectors.toList()).get(0);
        Optional<User> optionalUser = Optional.ofNullable(user);

        if(!optionalUser.isPresent())
            throw new NullPointerException();

        return optionalUser.get();
    }

    public User copy(User user){
        User copyUser = new User();
        copyUser.setUserId(user.getUserId());
        copyUser.setUserPassword(user.getUserPassword());
        copyUser.setUserEmail(user.getUserEmail());
        copyUser.setUserBirthDate(user.getUserBirthDate());
        copyUser.setUserPhoneNumber(user.getUserPhoneNumber());
        copyUser.setElectronicDevices(user.getElectronicDevices());

         return copyUser;
    }

}
