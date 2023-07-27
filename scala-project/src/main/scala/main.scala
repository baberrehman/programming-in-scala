//package main

//import learn.*

@main
def main(): Unit = {
//  Hello()
//
//  var r = ("x-2-3+4").split("-|\\+",2)
//  for (a <- r){
//    println(a)
//  }
//
//  println("27x".dropRight(1))
 // println('+'.equals('+'))

  //println(solveExpr("4x+2=2x+3"))
  //println(solveExpr("4x+5=2x+3"))
  //println(solveExpr("-4x+6=4x+3"))
  println(solveExpr("x=1"))

  breakingRecords(Array[Int](1,2,3,4,5)).foreach{ a => println(a) }
}