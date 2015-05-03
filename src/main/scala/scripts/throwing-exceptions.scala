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

val filename = "list1.ss"
try {
  val file = new FileReader(filename)
  try {
    // Use the file
  } finally {
    file.close()  // Be sure to close the file
    println("closed file: " + filename)
  }
} catch {
  // The behavior of this try-catch expression is the same as in other languages with
  // exceptions. The body is executed, and if it throws an exception, each catch
  // clause is tried in turn. In this example, if the exception is of type
  // FileNotFoundException, the first clause will execute. If it is of type
  // IOException, the second clause will execute. If the exception is of neither type,
  // the try-catch will terminate and the exception will propagate further.
  case ex: FileNotFoundException => // Handle missing file
    println("File '" + filename + "' not found")
  case ex: IOException => // Handle other I/O error
    println("io exception when opening file " + filename)
}
