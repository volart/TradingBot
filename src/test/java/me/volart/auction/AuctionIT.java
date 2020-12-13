package me.volart.auction;

import me.volart.Bidder;
import me.volart.BidderImpl;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AuctionIT {
  
  private Bidder player;
  private Bidder mock = Mockito.mock(Bidder.class);
  
  private Auction auction;
  
  @Test
  public void testAuction_QuMoreThanMu_PlayerWin(){
    player = new BidderImpl();
    when(mock.placeBid()).thenReturn(0);
    
    auction = new Auction(player, mock);
    
    auction.init(10, 2);
    
    auction.doBidding();
  
    assertEquals(player, auction.getWinner());
  }
  
  @Test
  public void testAuction_QuEqualsMu_Draw(){
    player = new BidderImpl();
    when(mock.placeBid()).thenReturn(0);
    
    auction = new Auction(player, mock);
    
    auction.init(4, 4);
    
    auction.doBidding();
    
    assertNull(auction.getWinner());
  }
  
  @Test
  public void testAuction_Lose(){
    player = new BidderImpl();
    when(mock.placeBid()).thenReturn(1);
    
    auction = new Auction(player, mock);
    
    auction.init(4, 10);
    
    auction.doBidding();
  
    assertEquals(mock, auction.getWinner());
  }
  
}