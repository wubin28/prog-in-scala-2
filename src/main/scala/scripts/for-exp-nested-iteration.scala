/**
 * Created by twer on 5/2/15.
 */
val filesHere = (new java.io.File(".")).listFiles

// Iteration through collections in for expressions
println(">>>The files and folders here:")
for (file <- filesHere)
  println(file)

println("\n>>>for 1 to 4:")
for (i <- 1 to 4)
  println("Iteration "+ i)

println("\n>>>for 1 until 4:")
for (i <- 1 until 4)
  println("Iteration "+ i)

// Filtering in for expressions
println("\n>>>for if file name ending with .scala:")
for (file <- filesHere if file.getName.endsWith(".scala"))
  println(file)

println("\n>>>for if file is file and its name ending with .ss:")
for (
  file <- filesHere
  if file.isFile
  if file.getName.endsWith(".ss")
) println(file)

println("\n>>>for if file is directory and its name ending with Folder:")
for (
  file <- filesHere
  if file.isDirectory
  if file.getName.endsWith("Folder")
) println(file)

// Nested iteration
println("\n>>>for if file name ends with .scala and line contains endsWith:")
def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toList
def grep(pattern: String) =
// If you prefer, you can use curly braces instead of parentheses to surround the
// generators and filters. One advantage to using curly braces is that you can leave
// off some of the semicolons that are needed when you use parentheses, because as
// explained in Section 4.2, the Scala compiler will not infer semi- colons while
// inside parentheses.
//  for (
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      if line.trim.matches(pattern)
    } println(file +": "+ line.trim)
//    ) println(file +": "+ line.trim)
grep(".*endsWith.*")

