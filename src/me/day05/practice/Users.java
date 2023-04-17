package me.day05.practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Users {
    private List<User> userList = new ArrayList<>();
    static Users instance;

    //set constructor as private for SingleTon
    private Users(){

    }
    /*
        assignment 2-1
        getInstance method
    */
    public static Users getInstance(){
        if(instance == null){
            instance = new Users();
        }
        return instance;
    }


    /*
        assignment 2-2
        find user by user's id
    */
    public User findByUserId(String userId){
        Optional<User> userOpt = userList
                .stream().filter(user -> userId.equals(user.getUserId()))
                .findFirst();
        if (userOpt.isPresent()) {
            return userOpt.get();
        }
        System.out.printf("'%s' Not Found\n",userId);
        return null;
    }

    //Todo : add validation check of userId, userPassword, userPhoneNumber, userEmail, userBirthDate
    public boolean addUser(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate){
        //duplication check
        if(findByUserId(userId) != null){
            System.out.printf("'%s' Already Exists\n",userId);
            return false;
        }

        userList.add(new User.Builder()
                .userId(userId)
                .userPassword(userPassword)
                .userPhoneNumber(userPhoneNumber)
                .userEmail(userEmail)
                .userBirthDate(userBirthDate)
                .build());

        return true;
    }

    public void initUsers(){
        String[] userId = {"tester01","tester02","tester03","tester01"};
        String[] userPassword = {"tester01PW","tester02PW","tester03PW","tester01PW"};
        String[] userPhoneNumber = {"010-0000-0001", "010-0000-0002", "010-0000-0003", "010-0000-0001",};
        String[] userEmail = {"tester01@gmail.com", "tester02@gmail.com", "tester03@gmail.com", "tester01@gmail.com"};
        LocalDate[] userBirthDate = {LocalDate.parse("1965-12-14"),LocalDate.parse("1982-07-31"), LocalDate.parse("2019-10-10"), LocalDate.parse("2000-01-01")};
        for(int i = 0 ; i < userId.length ; i++){
            addUser(userId[i], userPassword[i],userPhoneNumber[i], userEmail[i], userBirthDate[i]);
        }
        //System.out.println(userList.toString());
    }

    /*
        assignment 2
        getter(), setter(), hashcode(), equals(), toString()
    */
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public static void setInstance(Users instance) {
        Users.instance = instance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users users)) return false;
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
}
