import scala.collection.mutable
import scala.collection.mutable.Stack

def Hello(): Unit = {
  println("Hello from other side")
}

def CountApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array[Int], oranges: Array[Int]) = {
  val applesCount = apples.map((i: Int) => i + a).count((i: Int) => i <= t && i >= s)
  val orangesCount = oranges.map((i: Int) => i + b).count((i: Int) => i <= t && i >= s)
  Array(applesCount, orangesCount)
  println()
}

def getTotalX(a: Array[Int], b: Array[Int]): Int = {
  val fac = (1 to b.min).filter { x => b.forall{ z => z%x == 0} }
  val result = fac.count { x => a.forall{ z => x%z == 0 } }
  return result
}

def breakingRecords(scores: Array[Int]): Array[Int] = {
  var min = scores(0)
  var minCount = 0
  var max =scores(0)
  var maxCount = 0
  for (a <- scores) {
    if (a < min){
      min = a
      minCount = minCount + 1
    }
    if (a > max){
      max = a
      maxCount = maxCount + 1
    }
  }
  return Array[Int](maxCount, minCount)
}

def birthday(s: Array[Int], d: Int, m: Int): Int = {
  var i : Int = 0
  var count : Int = 0

  while (i+m <= s.length) {
      if (s.slice(i, i + m).sum == d){
        count = count + 1
      }
    i = i+1
  }
  return count
}