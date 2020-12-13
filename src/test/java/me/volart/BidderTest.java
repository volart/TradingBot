package me.volart;

import me.volart.strategy.Strategy;
import org.junit.Test;
import org.mockito.Mockito;

import static me.volart.BidderStatus.DRAW;
import static me.volart.BidderStatus.LOSER;
import static me.volart.BidderStatus.WINNER;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BidderTest {
  
  private Bidder bidder;
  
  private Strategy strategy = Mockito.mock(Strategy.class);
  
  @Test
  public void testStatus() {
    bidder = new BidderImpl(strategy);
    
    when(strategy.isVictory()).thenReturn(-1);
    assertEquals(LOSER, bidder.getStatus());
    
    when(strategy.isVictory()).thenReturn(0);
    assertEquals(DRAW, bidder.getStatus());
    
    when(strategy.isVictory()).thenReturn(1);
    assertEquals(WINNER, bidder.getStatus());
  }
}