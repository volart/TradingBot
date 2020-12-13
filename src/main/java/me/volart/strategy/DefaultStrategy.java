package me.volart.strategy;

import me.volart.data.Unit;

public class DefaultStrategy extends AbstractStrategy {
  
  protected DefaultStrategy(Unit unit) {
    super(unit);
  }
  
  @Override
  public int nextBid() {
    //In this game(let's look at the auction as at a game) Nash Equilibrium is when two players play 0.
    return 0;
  }
  
}
