package me.volart.strategy;

import me.volart.data.Unit;

public abstract class AbstractStrategy implements Strategy {
  
  protected Unit lastUpdate;
  protected int initQu;
  protected int wonQuantity = 0;
  
  protected AbstractStrategy(Unit unit) {
    initQu = unit.getQu();
    this.lastUpdate = unit;
  }
  
  @Override
  public void updateState(int own, int other) {
    wonQuantity += getWonQuantity(own, other);
    lastUpdate = new Unit(lastUpdate.getQu() - 2, lastUpdate.getMuOwn() - own, lastUpdate.getMuOpposer() - other);
  }
  
  @Override
  public int isVictory() {
    return wonQuantity - initQu / 2;
  }
  
  /**
   * @param own own money units
   * @param other opponent money units
   * @return 2 if win, 1 if draw and 0 if lose
   */
  protected int getWonQuantity(int own, int other) {
    if (own > other)
      return 2;
    if (own < other)
      return 0;
    return 1;
  }
}
