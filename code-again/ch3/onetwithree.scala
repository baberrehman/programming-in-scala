
def main(args: Array[String]): Unit = {
  var oneTwo = List(1, 2)
  var threeFour = List(3, 4)
  var oneTwoThreeFour = oneTwo ::: threeFour

  println("" + oneTwo + " " + threeFour)
  println("Thus, " + oneTwoThreeFour)

  oneTwo = threeFour

  // oneTwo(0) = "six"
  var arr1 = Array(1,2)
  arr1(0) = 0
}
