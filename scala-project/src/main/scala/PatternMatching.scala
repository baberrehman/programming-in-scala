import scala.util.{Failure, Success, Try}

object PatternMatching extends App {
  val aList : List[Int] = List(1,2,3,4)
  println(whatList(aList))
  //aList = aList.updated(1,5)
  println(aList(1))
  //customPattern()

  /**
   * Exception handling
   * @return
   */

  def methodThrowsException() : String = throw new RuntimeException()
  val aTry = Try(methodThrowsException())
  val catchException = aTry match {
    case Success(value) => "Valid"
    case Failure(ex) => s"Exception $ex"
  }

  println(catchException)

  /**
   * Exception handling ends
   */
}

def whatList(aList: Seq[Int]) : String = {
  return aList match {
    case (1 +: _) : List[Int] => "1 at the head Seq"
    case List(_) => "Empty List"
    case _ +: 3 +: _ => "Contains 2"
    case (1 +: _) => "1 at the head"
    case _ => "Unknown List"
  }
}

 trait Person() {
   //val name: String = ""
 }

case class Student(n: String) extends Person{
  val name : String = n
}

case class Worker() extends Person{
  val name : String = ""
}

def customPattern(): Unit = {
  var s : Person = new Student("Bob")

  s match {
   // case Person() => println("Person")
    case Student("Bob") => println(s"Student " + s.asInstanceOf[Student].name)
    //case Worker() => println("Worker")
  }
}