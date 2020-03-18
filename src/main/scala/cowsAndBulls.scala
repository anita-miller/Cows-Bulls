class cowsAndBulls {
  def play(usersHand: String, computerPlayersHand: String): Unit = {

  }

  private def countScore(usersHand: String, computerPlayersHand: String): BullsAndCowsScore = {
    val bulls = usersHand.zip(computerPlayersHand)
      .count(turn => turn._1 == turn._2)

    val cows = usersHand.count(turn => computerPlayersHand.contains(turn)) - bulls

    BullsAndCowsScore(bulls, cows)
  }
}
