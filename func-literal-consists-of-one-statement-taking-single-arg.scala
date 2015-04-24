var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}
println()



args.foreach(arg => println(arg))
println()



// If a function literal consists of one statement that takes a
// single argument, you need not explicitly name and specify the argument.
// This shorthand, called a partially applied function.
args.foreach(println)
println()



// You can say “in” for the <- symbol. You’d read for (arg <- args),
// therefore, as “for arg in args.”
for (arg <- args) println(arg)
