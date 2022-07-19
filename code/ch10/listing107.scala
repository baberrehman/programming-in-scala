
abstract class Element {
  def demo() = {
    println("Element's implementation invoked")
  }
}

class ArrayElement extends Element {
  final override def demo() = {
    println("ArrayElement's implementation invoked")
  }
}

// this will not compile
// demo is final in ArrayElement
class LineElement extends ArrayElement {
  override def demo() = {
    println("LineElement's implementation invoked")
  }
}

// Test Function
def invokeDemo(e: Element) = {
  e.demo()
}


// Main entry point
def main(args: Array[String]): Unit = {

}
