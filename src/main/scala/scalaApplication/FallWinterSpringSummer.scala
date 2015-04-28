package scalaApplication
import ChecksumAccumulator.calculate
/**
 * Created by twer on 4/27/15.
 */
// To use the trait, you first write “extends Application” after the name of your singleton object.
// Then instead of writing a main method, you place the code you would have put in the main method
// directly between the curly braces of the singleton object. That’s it. You can compile and run this
// appli- cation just like any other.
//
// The way this works is that trait Application declares a main method of the appropriate signature,
// which your singleton object inherits, making it usable as a Scala application. The code between
// the curly braces is collected into a primary constructor of the singleton object, and is executed
// when the class is initialized.
object FallWinterSpringSummer extends App{
  for (season <- List("fall", "winter", "spring"))
    println(season +": "+ calculate(season))
}
// Inheriting from Application is shorter than writing an explicit main method, but it also has
// some shortcomings. First, you can’t use this trait if you need to access command-line arguments,
// because the args array isn’t available. For example, because the Summer application uses
// command-line arguments, it must be written with an explicit main method, as shown in
// List- ing 4.3. Second, because of some restrictions in the JVM threading model, you need an
// explicit main method if your program is multi-threaded. Finally, some implementations of the
// JVM do not optimize the initialization code of an object which is executed by the Application
// trait. So you should in- herit from Application only when your program is relatively simple and
// single-threaded.