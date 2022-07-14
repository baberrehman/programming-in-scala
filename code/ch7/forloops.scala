
def listing75() = {
  val filesHere = (new java.io.File(".")).listFiles

  for (file <- filesHere)
    println(file)
}

def listing76() = {
  val filesHere = (new java.io.File(".")).listFiles

    for (file <- filesHere if file.getName.endsWith(".scala"))
      println(file)
}

def listing77() = {
  val filesHere = (new java.io.File(".")).listFiles

    for (
      file <- filesHere 
      if file.isFile;
      if file.getName.endsWith(".scala")
    ) println(file)
}

def main(args: Array[String]): Unit = {
  listing75()
}
