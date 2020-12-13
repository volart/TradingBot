package me.volart.auction;

import me.volart.Bidder;

public class Auction {
  
  private final Bidder first;
  private final Bidder second;
  
  private int qu;
  
  public Auction(Bidder first, Bidder second) {
    this.first = first;
    this.second = second;
  }
  
  public void init(int quantity, int cash) {
    first.init(quantity, cash);
    second.init(quantity, cash);
  }
  
  public void doBidding() {
    while (qu > 0) {
      int firstBid = first.placeBid();
      int secondBid = second.placeBid();
      
      first.bids(firstBid, secondBid);
      second.bids(secondBid, firstBid);
      
      qu -= 2;
    }
  }
  
  public Bidder getWinner() {
    switch (first.getStatus()) {
      case WINNER:
        return first;
      case LOSER:
        return second;
      default:
        return null;
    }
  }
  
}
