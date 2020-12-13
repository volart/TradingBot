package me.volart.strategy;

import me.volart.data.Unit;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrategyFactoryTest {
  
  @Test
  public void testStrategyFactory_twoQu_AllInStrategy(){
    Strategy strategy = StrategyFactory.create(new Unit(2, 1, 1));
    assertTrue(strategy instanceof AllInStrategy);
  }
  
  @Test
  public void testStrategyFactory_QuTwiceMoreThanMu_CarefulStrategy(){
    Strategy strategy = StrategyFactory.create(new Unit(4, 1, 1));
    assertTrue(strategy instanceof CarefulStrategy);
  }
  
  @Test
  public void testStrategyFactory_DefaultStrategy(){
    Strategy strategy = StrategyFactory.create(new Unit(4, 4, 4));
    assertTrue(strategy instanceof DefaultStrategy);
  }
  
}