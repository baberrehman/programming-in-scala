
import scala.io.Source

def main(args: Array[String]) : Unit = {
  if (args.length > 0) {
    for (line <- Source.fromFile(args(0)).getLines)
      print(line.length + " " + line)
  }
  else
    Console.err.println("Please enter filename")
}
