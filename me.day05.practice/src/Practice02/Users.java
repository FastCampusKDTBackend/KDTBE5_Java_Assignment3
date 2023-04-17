package Practice02;

import Practice01.Electronic;
import Practice01.User;
import java.util.Arrays;

public class Users {
    private User[] userList;
    private static Users instance = new Users();
    public static Users getInstance(){
        if(instance == null){
            instance = new Users();
        }
        return instance;
    }

    public User findByUserId(String userId){
        for (User user : userList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

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
