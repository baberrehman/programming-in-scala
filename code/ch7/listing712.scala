
import java.io.FileReader

def testException() = {
  val file = new FileReader("input.txt")
  try {
    // Use the file
  } finally {
    file.close() // Be sure to close the file
  }
}

def main(args: Array[String]): Unit = {

}
