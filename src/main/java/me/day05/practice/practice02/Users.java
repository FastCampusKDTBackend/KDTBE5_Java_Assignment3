package me.day05.practice.practice02;

import me.day05.practice.practice01.User;

import java.util.Arrays;
import java.util.Objects;


/**
 * User 객체 저장, 관리를 위한 클래스
 *
 * @author YongHo Shin
 * @version 0.1
 * @see User
 * @since 2023-04-12
 */
public class Users {
  
  /**
   * 최초 생성시 10명의 사용자 관리가 가능
   */
  private static final int DEFAULT_CAPACITY = 10;
  
  /**
   * 관리 인원이 늘어날 경우 더블링 적용
   */
  private static int currentCapacity = DEFAULT_CAPACITY;
  
  /**
   * 현재 관리중인 사용자 수
   */
  private static int currentSize = 0;
  
  private static final Users users = new Users();
  
  private User[] userList;
  
  public Users() {
    userList = new User[DEFAULT_CAPACITY];
  }
  
  public static Users getInstance() {
    return users;
  }
  
  /**
   * 관리 유저 추가. 기존 수용 가능 인원을 초과할 경우 사이즈를 2배로 늘린다.
   *
   * @param newUser 추가할 유저
   */
  public synchronized void addUser(User newUser) {
    if (currentSize < currentCapacity) {
      userList[currentSize++] = newUser;
    } else {
      currentCapacity += currentCapacity;
      userList = Arrays.copyOf(userList, currentCapacity);
      userList[currentSize++] = newUser;
    }
  }
  
  /**
   * @param userId 유저 ID
   * @return 유저 ID와 일치하는 객체
   */
  public User findByUserId(String userId) {
    return Arrays.stream(userList)
        .filter(Objects::nonNull)
        .filter(user -> user.getUserId().equals(userId))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
  
  /**
   * @return User 객체의 복사본
   */
  public User copy(User user) {
    if (user == null) {
      throw new IllegalArgumentException();
    }
    return User.copyOf(user);
  }
}
