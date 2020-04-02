import scala.annotation.tailrec
object GameLogic {
  def playCowsAndBulls(userInput: () => String, computerPlayersHand: String): Boolean = {
    @tailrec
    def play(acc: Int): Boolean = GamePresentation.readInput(userInput) match {
      case Some(input) => {
        val score = countScore(input, computerPlayersHand)
        if (score.correctPlaceAndVal != 4) GamePresentation.printValues(score)

        if (score.correctPlaceAndVal == 4) true
        else play(acc + 1)
      }
      case None => play(0)
    }

    play(0)
  }

  def countScore(usersHand: Int, computerPlayersHand: String): GameScore = {
    val corerctValAndPlace = findCorrectPlace(usersHand.toString.toList, computerPlayersHand.toList)._1

    val correctValWrongPlace = findCorrectvalWrongPlace(findCorrectPlace(usersHand.toString.toList, computerPlayersHand.toList)._2,
      findCorrectPlace(usersHand.toString.toList, computerPlayersHand.toList)._3)

    GameScore(corerctValAndPlace, correctValWrongPlace)

  }

  def findCorrectPlace(secret: List[Char], guess: List[Char]): (Int, List[Char], List[Char]) = {
    val correctPlaceAndVal = (guess.toString).zip(secret)
        .count(turn => turn._1 == turn._2)

    val secretPlaceOrValWrong = secret.zip(guess).filterNot(turn => turn._1 == turn._2).unzip._1

    val guessPlaceOrValWrong = guess.zip(secret).filterNot(turn => turn._1 == turn._2).unzip._1

    (correctPlaceAndVal, secretPlaceOrValWrong, guessPlaceOrValWrong)
  }

  def findCorrectvalWrongPlace(secret: List[Char], guess: List[Char])={
    secret.count(turn => guess.contains(turn))
  }
}