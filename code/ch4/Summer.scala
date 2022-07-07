
import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]) : Unit = {
    for(arg <- args)
      println(arg +":"+calculate(arg))
  }
}

//we cannot have two main methods in one Scala application
/*
object Summer2 {
  def main(args: Array[String]) : Unit = {
    println("SUMMER 2")
  }
}
*/
