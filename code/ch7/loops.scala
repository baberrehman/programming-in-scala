
def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b
}

/*
 *
 * do-while dropped in Scala 3
 *
def doWhileLoop() = {
  var line = "";
  do {
    line = readLine()
    println("Read: "+ line)
  } while (line != "")
}
*/

def gcd(x: Long, y: Long): Long = {
  if (y == 0) x else gcd(y, x % y)
}


def main(args: Array[String]): Unit = {
  
}
