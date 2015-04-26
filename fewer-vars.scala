if (args.length == 0){
  println(">>> Usage: scala func-literal-shorthand.scala <some args>.")
}

def printArgs(args: Array[String]): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}
printArgs(args)
println()



def printArgsUsingIn(args: Array[String]): Unit = {
  // You can say “in” for the <- symbol. You’d read for (arg <- args),
  // therefore, as “for arg in args.”
  for (arg <- args) println(arg)
}
printArgsUsingIn(args)
println()



def printArgsUsingForeach(args: Array[String]): Unit = {
  args.foreach(arg => println(arg))
}
printArgsUsingForeach(args)
println()



def printArgsUsingFuncLiteralShorthand(args: Array[String]): Unit = {
  // If a function literal consists of one statement that takes a
  // single argument, you need not explicitly name and specify the argument.
  // This shorthand, called a partially applied function.
  args.foreach(println)
}
printArgsUsingFuncLiteralShorthand(args)
println()
