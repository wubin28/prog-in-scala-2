val oneTwo = List(1, 2)
val threeFour = List(3, 4)
// Be- cause Lists are immutable, they behave a bit like Java
// strings: when you call a method on a list that might seem by
// its name to imply the list will mutate, it instead creates and
// returns a new list with the new value. For example, List has
// a method named ‘:::’ for list concatenation.
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo +" and "+ threeFour +" were not mutated.")
println("Thus, "+ oneTwoThreeFour +" is a new list.")



// Perhaps the most common operator you’ll use with lists is ‘::’,
// which is pronounced “cons.” Cons prepends a new element to the
// beginning of an existing list, and returns the resulting list.
// For example, if you run this script:
val twoThree = List(2, 3)
val oneTwoThree = 1 :: twoThree
println(oneTwoThree)



// In the expression “1 :: twoThree”, :: is a method of its right
// operand, the list, twoThree. You might suspect there’s something
// amiss with the associativity of the :: method, but it is actually a
// simple rule to remember: If a method is used in operator notation,
// such as a * b, the method is invoked on the left operand, as in
// a.*(b)—unless the method name ends in a colon. If the method name
// ends in a colon, the method is invoked on the right operand. Therefore,
// in 1 :: twoThree, the :: method is invoked on twoThree, passing in 1,
// like this: twoThree.::(1). Operator associativity will be described
// in more detail in Section 5.8.
val anotherOneTwoThree = twoThree.::(1)
println(anotherOneTwoThree)



// Given that a shorthand way to specify an empty list is Nil, one
// way to initialize new lists is to string together elements with
// the cons operator, with Nil as the last element.4 For example,
// the following script will produce the same output as the
// previous one, “List(1, 2, 3)”:
val anotherOneTwoThreeWithNil = 1 :: 2 :: 3 :: Nil
println(anotherOneTwoThreeWithNil)
// The reason you need Nil at the end is that :: is defined on class List.
// If you try to just say 1 :: 2 :: 3, it won’t compile because 3 is an
// Int, which doesn’t have a :: method.
