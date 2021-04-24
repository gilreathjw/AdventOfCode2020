object Problem01 {
  // Find the two numbers that sum to 2020 then multiply them together
  def findProductOfTwoSummedNumbers(desiredSum: Int, numbers: Vector[Int]): Option[Int] = {
    def go(desiredSum: Int, augend: Int, addendsToCheck: Vector[Int]): Option[Int] = { // TODO make tail-recursive
      addendsToCheck
        .find(_ + augend == desiredSum)
        .map(_ * augend)
        .orElse {
          if (addendsToCheck.size < 2) None // no remaining numbers to check
          else go(desiredSum, addendsToCheck.head, addendsToCheck.tail)
        }
    }
    if (numbers.size < 2) None // need at least two numbers to sum
    else go(desiredSum, numbers.head, numbers.tail)
  }

  def main(args: Array[String]): Unit = {
    FileUtil.readResource("Problem01.txt") match {
      case Left(exception) => throw exception
      case Right(lines) =>
        val numbers = lines.map(_.toInt)
        val answer = findProductOfTwoSummedNumbers(2020, numbers)
        System.out.println(answer)
    }
  }
}
