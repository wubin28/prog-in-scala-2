/**
 * Created by twer on 5/3/15.
 */

val n = 4
val half =
  if (n % 2 == 0)
    n/2 else
    throw new RuntimeException("n must be even")
println("half: " + half)

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

val filename = "list.ss"
try {
  val f = new FileReader(filename)
  // Use and close file
  println("found file: " + filename)
} catch {
  case ex: FileNotFoundException => // Handle missing file
    println("File '" + filename + "' not found")
  case ex: IOException => // Handle other I/O error
    println("io exception when opening file " + filename)
}
