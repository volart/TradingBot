package me.volart.strategy;

import me.volart.data.Unit;

public final class StrategyFactory {
  
  private StrategyFactory(){}
  
  public static Strategy create(Unit unit) {
    //  If we have only two quantity units it means for the win (or draw in case if the opponent has the same strategy)
    //  we need to pay all we have
    if (unit.getQu() == 2)
      return new AllInStrategy(unit);
    
    //  If we have twice less money to play than quantity units
    //  it means in worse case if both players would be careful(play only 1 and 0 MUs)
    //  they find equilibrium to have a draw.
    if (unit.getQu() >= 2 * unit.getMuOwn())
      return new CarefulStrategy(unit);
    
    // in other cases choose default strategy
    return new DefaultStrategy(unit);
  }
  
}
