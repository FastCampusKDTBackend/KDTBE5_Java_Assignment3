package ForSubmission.me.day05.practice.Practice03;

import java.util.ArrayList;
import java.util.Objects;

public class Users {
    private static Users usersInstance;
    private ArrayList<User> userList = new ArrayList<>();

    private Users(){}

    public static Users getInstance(){
        if (usersInstance == null) {
            usersInstance = new Users();
        }
        return usersInstance;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + userList +
                '}';
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User findByUserId(String userId) throws NullPointerException{

        for(int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getUserId() == userId) {
                return userList.get(i);
            }
        }
        System.out.println("Found Nothing");
        return null;
        //return null 수정하기
    }

    public User copy(User user) {
        User copiedUser = new User(
                user.getUserId(),
                user.getUserPassword(),
                user.getUserPhoneNumber(),
                user.getUserEmail(),
                user.getUserBirthDay()
        );
        copiedUser.setElectronicDevices(user.getElectronicDevices());
        copiedUser.setRegisterTime(user.getRegisterTime());

        return copiedUser;
    }
}
