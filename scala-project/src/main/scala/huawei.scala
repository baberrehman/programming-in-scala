import scala.collection.mutable
import scala.collection.mutable.Stack

def solveExpr(expr: String) : String = {
  //break expression from =
  val exprs = expr.split("=")

  // buildStacks returns two stacks
  // first stack for x values
  // second stack for constants
  val (stackX, stackNum) = buildStacksEff(exprs)

  // solve stacks
  var ansX = solveInfix(stackX)
  var ansNum = solveInfix(stackNum) * -1

  println(ansX.toString ++ "x" ++ "=" ++ ansNum.toString)

  if (ansX > 1) {
    return "x" ++ "=" ++ ansNum.toString ++ "/" ++ ansX.toString
  } else if (ansX <= -1) {
    return "x" ++ "=" ++ (ansNum*(-1)).toString ++ "/" ++ (ansX*(-1)).toString
  }
  else if (ansX == 1) {
    return "x" ++ "=" ++ ansNum.toString
  } else {
    return "No Solution"
  }
}

def buildStacks(exprs: Array[String]) : (mutable.Stack[String], mutable.Stack[String]) = {
  //stackX for x values
  val stackX: Stack[String] = new mutable.Stack[String]()
  //stackNum for constant numbers
  val stackNum: Stack[String] = new mutable.Stack[String]()

  //Populate two stacks with x values and constants
  var lastOp = ""
  var currentOp = ""
  while (exprs(0).contains("+") || exprs(0).contains("-")) {
    for (a <- exprs(0)) {
      if (a.equals('+') || a.equals('-')) {
        if (a.equals('+')) {
          currentOp = "+"
        } else if (a.equals('-')) {
          currentOp = "-"
        }
        val r = exprs(0).split("-|\\+", 2)
        if (r(0).nonEmpty) {
          if (r(0).contains("x")) {
            if (lastOp.isEmpty) {
              stackX.push("+")
              stackX.push(r(0).dropRight(1))
            } else {
              stackX.push(lastOp)
              stackX.push(r(0).dropRight(1))
            }
          } else {
            if (lastOp.isEmpty) {
              stackNum.push("+")
              stackNum.push(r(0))
            } else {
              stackNum.push(lastOp)
              stackNum.push(r(0))
            }
          }
        }
        exprs(0) = r(1)
        //println("Hello")
        lastOp = currentOp
        println(a)
        println(stackX)
        println(stackNum)
        println("")
      }
    }
  }

  if (exprs(0).nonEmpty) {
    if (lastOp.isEmpty) {
      if (exprs(0).contains("x")) {
        stackX.push("+")
        stackX.push(exprs(0).dropRight(1))
      } else {
        stackNum.push("+")
        stackNum.push(exprs(0))
      }
    }  else {
      if (exprs(0).contains("x")) {
        stackX.push(lastOp)
        stackX.push(exprs(0).dropRight(1))
      } else {
        stackNum.push(lastOp)
        stackNum.push(exprs(0))
      }
    }
  }

  println("First auxiliary")
  println(stackX)
  println(stackNum)
  println("")

  println("Printint 2nd expr...")

  lastOp = ""
  currentOp = ""
  while (exprs(1).contains("+") || exprs(1).contains("-")) {
    for (a <- exprs(1)) {
      if (a.equals('+')) {
        currentOp = "-"
      } else if (a.equals('-')) {
        currentOp = "+"
      }
      if (a.equals('+') || a.equals('-')) {
        var r = exprs(1).split("-|\\+", 2)
        if (r(0).nonEmpty){
          if (r(0).contains("x")) {
            if (lastOp.isEmpty) {
              stackX.push("-")
              stackX.push(r(0).dropRight(1))
            } else {
              stackX.push(lastOp)
              stackX.push(r(0).dropRight(1))
            }
          } else {
            if (lastOp.isEmpty) {
              stackNum.push("-")
              stackNum.push(r(0))
            } else {
              stackNum.push(lastOp)
              stackNum.push(r(0))
            }
          }
        }
        exprs(1) = r(1)
        lastOp = currentOp
        println(a)
        println(stackX)
        println(stackNum)
        println("")
      }
    }
  }

  if (exprs(1).nonEmpty) {
    if (lastOp.isEmpty) {
      if (exprs(1).contains("x")) {
        stackX.push("-")
        stackX.push(exprs(1).dropRight(1))
      } else {
        stackNum.push("-")
        stackNum.push(exprs(1))
      }
    }  else {
      if (exprs(1).contains("x")) {
        stackX.push(lastOp)
        stackX.push(exprs(1).dropRight(1))
      } else {
        stackNum.push(lastOp)
        stackNum.push(exprs(1))
      }
    }
  }

  println("Second auxiliary")
  println(stackX)
  println(stackNum)
  println("")

  return (stackX, stackNum)
}

def solveInfix(s: mutable.Stack[String]) : Int = {
  println("------ In solve ------")
  println(s)

  var sum : Int = 0
  while (s.nonEmpty) {
    val n1 = s.pop().toInt
    val op = s.pop()
    //val n2 = s.pop().toInt

    sum = op match {
      case "+" => sum + n1
      case "-" => sum - n1
    }
  }

  println(sum)
  return sum
}


/*
  Efficient implementation
*/

def buildStacksEff(exprs: Array[String]) : (mutable.Stack[String], mutable.Stack[String]) = {
  //stackX for x values
  val stackX: Stack[String] = new mutable.Stack[String]()
  //stackNum for constant numbers
  val stackNum: Stack[String] = new mutable.Stack[String]()

  //Populate two stacks with x values and constants
  var lastOp = "+"
  while (exprs(0).contains("+") || exprs(0).contains("-")) {
    for (a <- exprs(0)) {
      if (a.equals('+') || a.equals('-')) {
        val r = exprs(0).split("-|\\+", 2)
        if (r(0).nonEmpty) {
          if (r(0).contains("x")) {
            stackX.push(lastOp)
            stackX.push(r(0).dropRight(1))
          } else {
            stackNum.push(lastOp)
            stackNum.push(r(0))
          }
        }
        exprs(0) = r(1)
        //println("Hello")
        if (a.equals('+')) {
          lastOp = "+"
        } else if (a.equals('-')) {
          lastOp = "-"
        }

        println(a)
        println(stackX)
        println(stackNum)
        println("")
      }
    }
  }

  if (exprs(0).nonEmpty) {
    if (exprs(0).contains("x")) {
      stackX.push(lastOp)
      stackX.push(
        exprs(0).dropRight(1) match {
          case "" => "1"
          case _      => exprs(0).dropRight(1)
        }
      )
    } else {
      stackNum.push(lastOp)
      stackNum.push(exprs(0))
    }
  }

  println("First auxiliary")
  println(stackX)
  println(stackNum)
  println("")

  println("Printint 2nd expr...")

  lastOp = "-"
  while (exprs(1).contains("+") || exprs(1).contains("-")) {
    for (a <- exprs(1)) {
      if (a.equals('+') || a.equals('-')) {
        var r = exprs(1).split("-|\\+", 2)
        if (r(0).nonEmpty){
          if (r(0).contains("x")) {
            stackX.push(lastOp)
            stackX.push(r(0).dropRight(1))
          } else {
            stackNum.push(lastOp)
            stackNum.push(r(0))
          }
        }
        exprs(1) = r(1)
        if (a.equals('+')) {
          lastOp = "-"
        } else if (a.equals('-')) {
          lastOp = "+"
        }

        println(a)
        println(stackX)
        println(stackNum)
        println("")
      }
    }
  }

  if (exprs(1).nonEmpty) {
    if (exprs(1).contains("x")) {
      stackX.push(lastOp)
      stackX.push(
        exprs(1).dropRight(1) match {
          case "" => "1"
          case _      => exprs(1).dropRight(1)
        }
      )
    } else {
      stackNum.push(lastOp)
      stackNum.push(exprs(1))
    }
  }

  println("Second auxiliary")
  println(stackX)
  println(stackNum)
  println("")

  return (stackX, stackNum)
}