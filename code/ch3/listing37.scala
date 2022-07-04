

import scala.collection.mutable.Map

def main(args: Array[String]) : Unit = {
  val treasureMap = Map[Int, String]()
  treasureMap += (1 -> "Go to Island.")
  treasureMap += (2 -> "Find big X on ground.")
  treasureMap += (3 -> "Dig.")
  println(treasureMap(2))
}
