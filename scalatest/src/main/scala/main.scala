import java.awt.Robot

//def printName(n: Int): Unit = {
//  if (n <= 0) {
//    return
//  }
//  printName(n-1)
//  print(n)
//  println(") Baber")
//}
//
//def myLength[T](array: Array[T]): Int = {
//  if (array.length == 0) {
//    return 0
//  }
//  return 1 + myLength(array.tail)
//}
//
//def myLength2[T] (array: Array[T]): Int = {
//  array.map((_)=> 1).sum
//}

//class MyStack() {
//  var stack = List[Int](1, 2, 3);
//
//  def isEmpty(): Boolean = {
//    return stack.isEmpty
//  }
//
//  def push(elem: Int) = {
//
//  }
//}

def printHello1(n: Int): Unit = {
  if (n <= 0) {
    return
  }
  print(n)
  println(") Hello")
  printHello1(n-1)
}

def printHello2(n: Int): Unit = {
  if (n <= 0) {
    return
  }
  printHello2(n-1)
  print(n)
  println(") Hello")
}

def myLength[T](l : Array[T]): Int = {
  if (l.isEmpty) {
    return 0
  }
  return (1 + myLength(l.tail))
}

def factorial1(n: Int): Int = {
  if (n == 0) {
    return 1
  }
  n * factorial1(n-1)
}

def factorial2(n: Int): Int = {
  if (n == 0) {
    return 1
  }

  var fact = 1
  var temp = n
  while (temp > 1) {
    // val temp = n * (n-1)
    fact = fact * temp
    temp = temp - 1
  }
  return fact
}

trait Person () {}
trait Robot () {}

def speak(x: Person | Robot): String = {
  x match
    case p: Person => "I am person"
    case r: Robot  => "I am robot"
}

class Hybrid () extends Person with Robot {}

def filterNull(p: String | Null): Unit = {

  var str: String | Null = null

  str match
    case s: String => s.length
    //case n: Null   => -1
}

@main
def main(): Unit = {
  //println("Hello world!")
  //printName(3)

//  println(myLength(Array[Int](1,2,3)))
//  println(myLength2(Array[Int](1,2,3,4)))

//  println("Print Hello 1")
//  printHello1(4)
//  println()
//  println("Print Hello 2")
//  printHello2(4)

//println(myLength[Int](Array(1,2,3,4,5,6,7,8,9,10)))
  println(factorial1(5))
  println(factorial2(5))
}