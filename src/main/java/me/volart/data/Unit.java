package me.volart.data;

/**
 * Unit is a data structure to store a rest number of quantity units and count money units for opponents.
 * Unit is a immutable class. It can describe a turn state of the game.
 */
public class Unit {
  private final int qu;
  private final int muOwn;
  private final int muOpposer;
  
  public Unit(int qu, int mu) {
    this.qu = qu;
    this.muOwn = mu;
    this.muOpposer = mu;
  }
  
  public Unit(int qu, int muOwn, int muOpposer) {
    this.qu = qu;
    this.muOwn = muOwn;
    this.muOpposer = muOpposer;
  }
  
  public int getQu() {
    return qu;
  }
  
  public int getMuOwn() {
    return muOwn;
  }
  
  public int getMuOpposer() {
    return muOpposer;
  }
}
