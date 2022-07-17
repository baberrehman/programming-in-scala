
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

def testException() = {
  try {
    val f = new FileReader("input.txt")
  } catch {
    case ex: FileNotFoundException => "File not found"
    case ex: IOException => "Other IO exception"
  }
}

def main(args: Array[String]): Unit = {

}
