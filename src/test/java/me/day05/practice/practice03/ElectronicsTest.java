package me.day05.practice.practice03;

import me.day05.practice.practice01.AuthMethod;
import me.day05.practice.practice01.Electronic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static me.day05.practice.practice01.AuthMethod.*;
import static me.day05.practice.practice01.CompanyName.APPLE;
import static me.day05.practice.practice01.CompanyName.SAMSUNG;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectronicsTest {
  private static final Electronics sut = Electronics.getInstance();
  private static final Electronic appleWatch = Electronic.createWithDetails(
      "Apple Watch",
      APPLE,
      new AuthMethod[]{PIN});
  
  private static final Electronic galaxyS = Electronic.createWithDetails(
      "Galaxy S",
      SAMSUNG,
      new AuthMethod[]{PATTERN, PIN, FACE}
  );
  
  private static final Electronic iPad = Electronic.createWithDetails(
      "iPad Pro 11 3rd",
      APPLE,
      new AuthMethod[]{PATTERN, PIN, FACE, FINGER_PRINT}
  );
  
  @BeforeAll
  static void init() {
    sut.addElectronic(appleWatch);
    sut.addElectronic(galaxyS);
    sut.addElectronic(iPad);
  }
  
  @Test
  void findByProductNo() {
    // Given
    Electronic sample = Electronic.createWithDetails(
        "iPhone",
        APPLE,
        new AuthMethod[]{PATTERN, PIN, FACE, FINGER_PRINT});
    sut.addElectronic(sample);
    
    // When
    Electronic actual = sut.findByProductNo(sample.getProductNo());
    
    // Then
    assertEquals(actual.getProductNo(), sample.getProductNo());
  }
  
  @Test
  void groupByCompanyName() {
    // When & Then
    Electronic[] actual = sut.groupByCompanyName(APPLE);
    assertArrayEquals(new Electronic[]{appleWatch,iPad}, actual);
  }
  
  @Test
  void groupByAuthMethod() {
    // When & Then
    Electronic[] actual = sut.groupByAuthMethod(FACE);
    assertArrayEquals(new Electronic[]{galaxyS, iPad}, actual);
  }
}