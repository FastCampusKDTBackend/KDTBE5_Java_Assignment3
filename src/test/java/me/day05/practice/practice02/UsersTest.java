package me.day05.practice.practice02;

import me.day05.practice.practice01.AuthMethod;
import me.day05.practice.practice01.Electronic;
import me.day05.practice.practice01.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static me.day05.practice.practice01.AuthMethod.*;
import static me.day05.practice.practice01.CompanyName.APPLE;
import static me.day05.practice.practice01.CompanyName.SAMSUNG;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersTest {
  private static final Users sut = Users.getInstance();
  private static final User user1 = User.createWithIdAndPassword("user1id", "user1password");
  private static final User user2 = User.createWithIdAndPassword("user2id", "user2password");
  
  private static final Electronic galaxyS = Electronic.createWithDetails("Galaxy S", SAMSUNG, new AuthMethod[]{PIN, FACE, PATTERN});
  private static final Electronic iPad = Electronic.createWithDetails("iPad Pro 11", APPLE, new AuthMethod[]{PIN, FACE, PATTERN,});
  
  @BeforeAll
  static void init() {
    user1.setElectronicDevices(galaxyS);
    user2.setElectronicDevices(galaxyS, iPad);
    sut.addUser(user1);
    sut.addUser(user2);
  }
  
  @Test
  void findByUserIdTest() {
    User actual = sut.findByUserId("user1id");
    assertEquals(user1, actual);
  }
  
  @Test
  void copyTest() {
    User actual = sut.findByUserId("user1id");
    User copied = sut.copy(actual);
    assertEquals(actual.getUserId(), copied.getUserId());
    assertEquals(actual.getUserPassword(), copied.getUserPassword());
    assertEquals(actual.getUserEmail(), copied.getUserEmail());
    assertArrayEquals(actual.getElectronicDevices(), copied.getElectronicDevices());
    assertEquals(actual.getRegisterTime(), copied.getRegisterTime());
  }
}