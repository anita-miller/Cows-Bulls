import scala.io.StdIn
import scala.util.Random
import cats.effect._

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {

    val computerPlayersHand = generateRandomNumbers(System.currentTimeMillis())
    val nextUserInput: () => String = () => StdIn.readLine()
    GameLogic.playCowsAndBulls(nextUserInput, computerPlayersHand)

    IO(println(s"You won after ")).map(_ => ExitCode.Success)
  }

  // Luke: Why not 0? Duplicates?
  //create number 0 to 9999 then +10000 to make  5 digits like 10123 or 19001 then cut the first digit out
  def generateRandomNumbers(seed: Long): String = (Random.nextInt(9999) + 10000).toString.substring(1,5)
  // (1 to 4).map(_ => Random.nextInt(10)).mkString("")
}

// Options
// 1 - duplicates not allowed
// 2 - Allowed
// a - 1234 entered 1111 => 1 bull 0 cows
// b - 1234 entered 1111 => 1 bull 3 cows