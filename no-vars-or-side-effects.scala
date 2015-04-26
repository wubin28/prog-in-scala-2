if (args.length == 0){
  Console.err.println(">>> Usage: scala func-literal-shorthand.scala <some args>.")
  System.exit(1)
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



// You can go even further, though. The refactored printArgs method is
// not purely functional, because it has side effects—in this case, its
// side effect is printing to the standard output stream. The telltale
// sign of a function with side effects is that its result type is Unit.
// If a function isn’t returning any interesting value, which is what
// a result type of Unit means, the only way that function can make a
// difference in the world is through some kind of side effect. A more
// functional approach would be to define a method that formats the passed
// args for printing, but just returns the formatted string, as shown
// in Listing 3.9
// The mkString method, which you can call on any iterable collection
// (includ- ing arrays, lists, sets, and maps), returns a string consisting
// of the result of calling toString on each element, separated by
// the passed string.
def makingString(args: Array[String]) = args.mkString("\n")
println(makingString(args))



// Every useful program is likely to have side effects of some form,
// be- cause otherwise it wouldn’t be able to provide value to the
// outside world. Preferring methods without side effects encourages you
// to design programs where side-effecting code is minimized. One benefit
// of this approach is that it can help make your programs easier to test.
val res = makingString(Array("zero", "one", "two"))
assert(res == "zero\none\ntwo")
