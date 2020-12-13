package me.volart;


import me.volart.data.Unit;
import me.volart.strategy.Strategy;
import me.volart.strategy.StrategyFactory;

public class BidderImpl implements Bidder {
  
  private Strategy strategy;
  
  public BidderImpl() {
  }
  
  protected BidderImpl(Strategy strategy) {
    this.strategy = strategy;
  }
  
  @Override
  public void init(int quantity, int cash) {
    this.strategy = StrategyFactory.create(new Unit(quantity, cash));
  }
  
  @Override
  public int placeBid() {
    return strategy.nextBid();
  }
  
  @Override
  public void bids(int own, int other) {
    strategy.updateState(own, other);
  }
  
  @Override
  public BidderStatus getStatus() {
    if (strategy.isVictory() > 0)
      return BidderStatus.WINNER;
    if (strategy.isVictory() < 0)
      return BidderStatus.LOSER;
    return BidderStatus.DRAW;
  }
}
