
abstract class Element {
  def demo() = {
    println("Element's implementation invoked")
  }
}

class ArrayElement extends Element {
  override def demo() = {
    println("ArrayElement's implementation invoked")
  }
}

class LineElement extends Element {
  override def demo() = {
    println("LineElement's implementation invoked")
  }
}

// UniformElement inherits Elements demo
class UniformElement extends Element

class TestElement extends ArrayElement


// Test Function
def invokeDemo(e: Element) = {
  e.demo()
}


// Main entry point
def main(args: Array[String]): Unit = {

}
