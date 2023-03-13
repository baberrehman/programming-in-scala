
import scala.io.Source

def main(args: Array[String]): Unit = {
  if (args.length > 0) {
    readFile(args(0))
  }
  else
    Console.err.println("Please enter filename")
}

def readFile(fileName: String): Unit = {
  for (line <- Source.fromFile(fileName).getLines)
    println(line.length +" "+ line)
}

def readFile2(fileName: String): Unit = {
  
}
