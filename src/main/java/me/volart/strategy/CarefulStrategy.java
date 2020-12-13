package me.volart.strategy;

import me.volart.data.Unit;

public class CarefulStrategy extends AbstractStrategy {
  
  protected CarefulStrategy(Unit unit) {
    super(unit);
  }
  
  @Override
  public int nextBid() {
    // We wait until the opponent has spent money more than we do.
    // In the worst case, we will lose a round and save money(we don't know the opponent's strategy).
    if (lastUpdate.getMuOpposer() >= lastUpdate.getMuOwn()) {
      //Also a strategy when two bidders pay by 0 MU is a Nash Equilibrium
      return 0;
    }
    // When the opponent has spent all his money we will pay by 1 MU for round and
    // because of we both have less money than rounds can be played (QU > 2MU)
    // the Careful Strategy has a place.
    return 1;
  }
}
