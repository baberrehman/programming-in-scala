
type Elem[X] = X match {
  case String => Char
  case List[t] => Elem[t]
  case Any => X
}

def elem[X](x: X): Elem[X] = x match {
  case x: String => x.charAt(0)
  case x: List[t] => elem(x.head)
  case x: Any => x
}

def main(args: Array[String]): Unit = {
    /*
      following expression shows weird behavior
      List <: Seq and Seq <:! List in Scala hierarchy
      Following program should get stuck and should not return 1
    */

    println(elem[Seq[Int]](Seq(1,2,3)))
}
