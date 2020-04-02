import scala.util.{Failure, Success, Try}

object GamePresentation{
  def printValues(score: GameScore): Unit ={
    println(s"Correct Place and Value : ${score.correctPlaceAndVal},  Correct Value at the wrong place : ${score.CorrectVal}")
  }
  def requestInput():Unit = print("Enter a 4 digit number :  ")
  def youWon():Unit = println("Congrats you won")

  def readInput(userInput : () => String): Option[Int] ={
    requestInput()
    val input = Try(userInput.apply().toInt)
// leave broken - lets play with PBT (to detect 0 at start of string)
    input match {
      case Success(inputInt: Int) => {
        if (inputInt.toString.size !=4 ) {
          println("Wrong Input")
          None
        } else {
          Some(inputInt)
        }
      }
      case Failure(_) => None
    }
  }
}
