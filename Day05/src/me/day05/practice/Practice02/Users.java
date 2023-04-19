package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Users {

    private static Users allUsers;
    // 싱글톤
    public Users getInstance() {
        if (allUsers == null) {
            allUsers = new Users();
        }
        return allUsers;
    }
    private User[] userList;
    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private Users() {
        allUsers.userList = new User[DEFAULT];
        this.capacity = DEFAULT;
        this.size = 0;
    }

    private Users(int initial){
        allUsers.userList = new User[initial];
        this.capacity = initial;
        this.size =0;
    }

    private Users(User[] userList){
        this.userList = userList;
        this.capacity = userList.length;
        this.size = userList.length;
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    // add, set, get, pop, indexOf,size, capcity(for dynamic- size array)
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

    public User get(int index){
        if(index<0||index>=this.size){
            System.out.println("index의 범위가 올바르지 않습니다.");
            return null;
        }
        return userList[index];
    }

    public void set(int index, User user){
        if(index<0||index>=this.size){
            System.out.println("index의 범위가 올바르지 않습니다.");
            return;
        }
        if(user == null) {
            System.out.println("저장이 불가합니다.");
            return;
        }
        userList[index] = user;
    }

    public int indexOf(User user){
        if(user == null) {
            System.out.println("not found .");
            return -1;
        }

        for(int i=0;i<this.size;i++){
            if(userList[i] == null) continue;
            if(userList[i].equals(user))return i;
        }
        return -1;
    }

    public void grow(){
        capacity*=2;// 용량이 다 차면 2배씩 증가
        // 방법 1.
        userList = Arrays.copyOf(userList, capacity);
        // 방법 2.

    }
    public void add(User user){
        if(user == null) return ;// null에 add를 할 수 없음.
        if(size<capacity){
            userList[size]= user;
            size++;
        }else{
            grow();// capcity배열의 크기를 늘림.
            add(user);
        }
    }

    public User pop(int idx){

        if(size == 0) return null;
        if(idx < 0 || idx >= size) return null;

        User popElement = userList[idx];
        userList[idx]= null;

        for(int i = idx+1;i<size;i++){
            userList[i-1] = userList[i];
        }
        userList[size-1]= null;
        size--;
        return popElement;


    }



    /// CRUD
    // CREATE, READ, UPDATE, DELETE

    public User select(String userId) {
        if (userId == null) {
            System.out.println("userId가 비어있습니다. 다시 입력해주세요!");
            return null;
        }

        for(int i=0;i<this.size;i++){
            if(allUsers.userList[i].getUserId().equals(userId)){
                return allUsers.userList[i];
            }
        }
        return null;
    }

    public boolean insert(User user){
        if(user== null|| user.getUserId()==null) return false;

        for(int i=0;i<allUsers.size;i++){
            if(allUsers.userList[i].equals(user))return false;
        }
        allUsers.add(user);
        return true;
    }

    public boolean update(User user){//
        if(user== null|| user.getUserId()==null) return false;

        for(int i=0;i<allUsers.size;i++){
            if(allUsers.userList[i].equals(user))return false;
        }
        int idx = indexOf(user);
        if(idx == -1) return false;

        allUsers.set(idx, user);
        return true;
    }

    public boolean delete (String userId){
        if(userId == null) return false;

        int idx = indexOf(new User(userId));
        if(idx == -1 )return false;

        allUsers.pop(idx);
        return true;

    }

    public User findByUserId(String userId) {

        for (User user : userList) {
            if (user.equals(userId)) {
                return user;
            }
        }
        System.out.println("Not Found User");
        return null;
    }

    public User copy(User user) {// Deep copy
        User newUser = new User();
        newUser.setUserId(user.getUserId());
        newUser.setUserPassword(user.getUserPassword());
        newUser.setUserPhoneNumber(user.getUserPhoneNumber());
        newUser.setUserEmail(user.getUserEmail());
        newUser.setUserBirthDate(user.getUserBirthDate());
        newUser.setElectronicDevices(user.getElectronicDevices());

        return newUser;
    }


}
