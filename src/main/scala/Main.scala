import scala.util.Random
import scala.io.StdIn.readLine

object Main {
  def main(args: Array[String]): Unit = {

    val computerPlayersHand = computerGenerateRandomNumbers(System.currentTimeMillis())
    val usersHand = readLine()

    val app = new cowsAndBulls().play(usersHand, computerPlayersHand)

    println(s"You won after $usersHand, $computerPlayersHand")
  }

  def computerGenerateRandomNumbers(seed: Long): String = new Random().between(1111,9999).toString

}
