val greetStrings = new Array[String](3)
//val greetStrings: Array[String] = new Array[String](3)
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"
for (i <- 0 to 2) // if a method takes only one parameter, you can call
                  // it without a dot or parentheses.
// This to method actually returns not an array but a different
// kind of sequence, containing the values 0, 1, and 2,
// which the for expression iterates over.
print(greetStrings(i))


// These three lines of code illustrate an important concept to
// understand about Scala concerning the meaning of val. When you
// define a variable with val, the variable can’t be reassigned,
// but the object to which it refers could potentially still be changed.
// So in this case, you couldn’t reassign greetStrings to a different
// array; greetStrings will always point to the same Array[String]
// instance with which it was initialized. But you can change the
// elements of that Array[String] over time, so the array itself is mutable.
//val greetStrings = new Array[String](3)
greetStrings.update(0, "Hi") // transform that into an invocation of
                             // an update method
greetStrings.update(1, ", ")
greetStrings.update(2, "Scala!\n")
for (i <- 0.to(2))
// Another important idea illustrated by this example will
// give you insight into why arrays are accessed with
// parentheses in Scala. Scala has fewer special cases than
// Java. Arrays are simply instances of classes like any
// other class in Scala. When you apply parentheses surrounding
// one or more values to a variable, Scala will transform the
// code into an invocation of a method named apply on that
// variable. So greetStrings(i) gets transformed into
// greetStrings.apply(i). Thus accessing an element of
// an array in Scala is simply a method call like any other.
// This principle is not restricted to arrays: any application of
// an object to some arguments in parentheses will be transformed to
// an apply method call. Of course this will compile only if that
// type of object actually defines an apply method. So
// it’s not a special case; it’s a general rule.
  print(greetStrings.apply(i))



// Note that this syntax only works if you explicitly specify the
// receiver of the method call. You cannot write “println 10”,
// but you can write “Console println 10”.
Console println 10
// println 10



// Scala doesn’t technically have operator overloading,
// because it doesn’t actually have operators in the
// traditional sense. Instead, characters such as +,
// -, *, and / can be used in method names.
Console println 1+2
Console println (1).+(2)



val otherGreetingStrings = Array("Hello", ", ", "world!\n")
//val otherGreetingStrings = Array.apply("Hello", ", ", "world!\n")
// What you’re actually doing in Listing 3.2 is calling a factory
// method, named apply, which creates and returns the new array.
// This apply method takes a variable number of arguments2 and is
// defined on the Array compan- ion object. You’ll learn more about
// companion objects in Section 4.3. If you’re a Java programmer,
// you can think of this as calling a static method named apply on class Array.
// Variable-length argument lists, or repeated parameters, are described
// in Section 8.8.
otherGreetingStrings.foreach(print)
