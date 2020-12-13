package me.volart.strategy;


/**
 * The Strategy interface describes a basic functionality to interact with the game.
 */
public interface Strategy {
  
  /**
   * Get the next bid
   *
   * @return the next bid according strategy realisation
   */
  int nextBid();
  
  /** Update the state of bidder wallet
   *
   * @param own own money units
   * @param other opponent money units
   */
  void updateState(int own, int other);
  
  /**
   * Check of bidding status
   *
   * @return less than 0 means loss
   *         0 means draw
   *         more than 0 means win
   */
  int isVictory();
}
