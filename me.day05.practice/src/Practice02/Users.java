package Practice02;

import Practice01.Electronic;
import Practice01.User;

import java.util.Arrays;

public class Users implements Cloneable{
    private User[] userList;
    //싱글톤
    private static Users instance = new Users();
    public static Users getInstance(){
        if(instance == null){
            instance = new Users();
        }
        return instance;
    }

    //회원 아이디를 통해 주어진 회원번호에 해당하는 회원을 반환
    public User findByUserId(String userId){
        for (User user : userList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    //인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수
    public User copy(User user){
        User userCopy = new User();
        userCopy.setUserId(user.getUserId());
        userCopy.setUserEmail(user.getUserEmail());
        userCopy.setUserPassword(user.getUserPassword());
        userCopy.setUserBirthDate(user.getUserBirthDate());
        userCopy.setUserPhoneNumber(user.getUserPhoneNumber());
        userCopy.setRegisterTime(user.getRegisterTime());
        userCopy.setElectronicDevices(user.getElectronicDevices());
        return userCopy;
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
        return Arrays.hashCode(userList);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }


}
