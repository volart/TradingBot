package me.volart.strategy;

import me.volart.data.Unit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarefulStrategyTest {
  
  private CarefulStrategy strategy;
  
  @Test
  public void testNextBid_ownMuEqualThanOther_zero() {
    strategy = new CarefulStrategy(new Unit(4, 4, 4));
    assertEquals(1, strategy.nextBid());
  }
  
  @Test
  public void testNextBid_ownMuLessThanOther_zero() {
    strategy = new CarefulStrategy(new Unit(4, 2, 4));
    assertEquals(0, strategy.nextBid());
  }
  
  @Test
  public void testNextBid_ownMuMoreThanOther_one() {
    strategy = new CarefulStrategy(new Unit(4, 3, 2));
    assertEquals(1, strategy.nextBid());
  }
  
  @Test
  public void testNextBid_ownMuMoreThanOtherThenUpdateData_oneThenZero() {
    strategy = new CarefulStrategy(new Unit(4, 3, 2));
    assertEquals(1, strategy.nextBid());
  
    strategy.updateState(2, 0);
    assertEquals(0, strategy.nextBid());
  }
  
}