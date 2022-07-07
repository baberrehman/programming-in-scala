
import scala.collection.mutable.Map

class ChecksumAccumulator {
  
  private var sum = 0

  def add(b: Byte): Unit = sum += b

  def checksum(): Int = return ~(sum & 0xFF) + 1
}

// In file ChecksumAccumulator.scala

object ChecksumAccumulator {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}


def main(args: Array[String]) : Unit = {
  val acc = new ChecksumAccumulator
  //acc.sum = 5
  
  ChecksumAccumulator.calculate("Every value is an object.")
}
