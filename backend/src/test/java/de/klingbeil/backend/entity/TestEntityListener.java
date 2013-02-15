package de.klingbeil.backend.entity;

import javax.persistence.PrePersist;

public class TestEntityListener {
  
  private static boolean prePersist;
  private static Object lastPassedEntity;

  @PrePersist
  public void prePersist( Object entity ) {
    prePersist = true;
    lastPassedEntity = entity;
  }

  public static boolean isPrePersist() {
    return prePersist;
  }

  public static Object getLastPassedEntity() {
    return lastPassedEntity;
  }
}
