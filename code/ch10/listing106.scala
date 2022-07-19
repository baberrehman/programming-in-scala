
abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
}

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def heigth = 1
}

def main(args: Array[String]): Unit = {
  
}
