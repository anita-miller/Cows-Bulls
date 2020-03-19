import scala.annotation.tailrec

class cowsAndBulls {
  def playCowsAndBulls(usersHand: String, computerPlayersHand: String): Unit = {
    @tailrec
    def play(round: Int): Int = {
      val bullsAndCowsScore = countScore(usersHand, computerPlayersHand)

      bullsAndCowsScore match {
        case score if score.bulls == 4 => {
          println(s"Congrats oyu guessed it right Answer is ${computerPlayersHand}")
          round
        }
        case score => {
          println(s"Cows : ${score.cows},  Bulls : ${score.bulls}")
          play(round + 1)
        }
      }
    }
    play(0)
  }

  private def countScore(usersHand: String, computerPlayersHand: String): BullsAndCowsScore = {
    val bulls = usersHand.zip(computerPlayersHand)
      .count(turn => turn._1 == turn._2)

    val cows = usersHand.count(turn => computerPlayersHand.contains(turn)) - bulls

    BullsAndCowsScore(bulls, cows)
  }
}
