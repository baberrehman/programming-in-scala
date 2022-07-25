
/*
  Element code from chapter 10
*/


object Element {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElement(line)
}

import Element.elem

abstract class Element {
  def contents: Array[String]
  def width: Int = if (height == 0) 0 else contents(0).length
  
  def height: Int = contents.length
  
  def above(that: Element): Element = 
    elem(this.contents ++ that.contents)

  def beside(that: Element): Element = {
    elem( 
      for (
           (line1, line2) <- this.contents zip that.contents
         ) yield line1 + line2
       )
  }
  
  override def toString = contents.mkString("\n")
}

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}

class UniformElement (ch: Char, 
  override val width: Int, 
  override val height: Int) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
}



/*
 Unit Test
*/

import org.scalatest.Spec

class ElementSpec extends Spec {
  
  "A UniformElement" -- {
    "should have a width equal to the passed value" - {
      val ele = elem('x', 2, 3)
      assert(ele.width === 3)
    }

    "should have a height equal to the passed value" - {
      val ele = elem('x', 2, 3)
      assert(ele.height === 3)
    }

    "should throw an IAE if passed a negative width" - {
        intercept(classOf[IllegalArgumentException]) {
        elem('x', -2, 3)
      }
    }
  }
}
