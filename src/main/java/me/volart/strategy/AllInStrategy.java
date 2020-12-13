package me.volart.strategy;

import me.volart.data.Unit;

/**
 * AllInStrategy is useful if there is only one round.
 */
public class AllInStrategy extends AbstractStrategy {
  
  protected AllInStrategy(Unit unit) {
    super(unit);
  }
  
  @Override
  public int nextBid() {
    return lastUpdate.getMuOwn();
  }
  
}
