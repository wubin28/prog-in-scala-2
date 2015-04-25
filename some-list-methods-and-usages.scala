val emptyList = List()
println(emptyList) // List()



val nilList= Nil
println(nilList) // List()



val aList = List("Cool", "tools", "rule")
println(aList) // List(Cool, tools, rule)



val thrill = "Will" :: "fill" :: "until" :: Nil
println(thrill) // List(Will, fill, until)



val concat = List("a", "b") ::: List("c", "d")
println(concat) // List(a, b, c, d)



println(thrill(2)) // until



println(thrill.count(s=>s.length==4)) // 2



println(thrill.drop(2)) // Returns the thrill list without its first
                        // 2 elements.
                        // List(until)



println(thrill.dropRight(2)) // List(Will)



println(thrill.exists(s => s == "until")) // true



println(thrill.filter(s => s.length == 4)) // List(Will, fill)



println(thrill.forall(s => s.endsWith("l"))) // true



thrill.foreach(s => print(s)) // Willfilluntil
println
thrill.foreach(print) // Willfilluntil
println



println(thrill.head) // Will



println(thrill.init) // List(Will, fill)



println(thrill.isEmpty) // false



println(thrill.last) // until



println(thrill.length) // 3



println(thrill.map(s => s + "y")) // List(Willy, filly, untily)



println(thrill.mkString(", ")) // Will, fill, until



println(thrill.filter(s => s.length != 4)) // List(until)



println(thrill.reverse) // List(until, fill, Will)



println(thrill.sortWith((s,t) => s.charAt(0).toLower < t.charAt(0).toLower))
// List(fill, until, Will)



println(thrill.tail) // List(fill, until)
