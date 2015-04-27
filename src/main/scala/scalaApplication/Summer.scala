package scalaApplication

// The first statement in the file is an import of the calculate method defined in the
// ChecksumAccumulator object in the previous example. This import state- ment allows you
// to use the method’s simple name in the rest of the file.
//
// If you’re a Java programmer, you can think of this import as similar to the static
// im- port feature introduced in Java 5. One difference in Scala, however, is that you
// can import members from any object, not just singleton objects.
//
// Scala implicitly imports members of packages java.lang and scala, as well as the members
// of a singleton object named Predef, into every Scala source file. Predef, which resides
// in package scala, contains many useful methods. For example, when you say println in a
// Scala source file, you’re actually invoking println on Predef. (Predef.println turns around
// and invokes Console.println, which does the real work.) When you say assert, you’re
// invoking Predef.assert.
import ChecksumAccumulator.calculate

/**
 * Created by twer on 4/27/15.
 */
// To run a Scala program, you must supply the name of a standalone singleton object with a
// main method that takes one parameter, an Array[String], and has a result type of Unit.
// Any standalone object with a main method of the proper signature can be used as the entry
// point into an application.
object Summer {

  def main(args: Array[String]) {
    for (arg <- args)
      println(arg +": "+ calculate(arg))
  }
}
// Neither ChecksumAccumulator.scala nor Summer.scala are scripts, because they end in a definition.
// A script, by contrast, must end in a re- sult expression. Thus if you try to run Summer.scala
// as a script, the Scala interpreter will complain that Summer.scala does not end in a result
// expres- sion (assuming of course you didn’t add any expression of your own after
// the Summer object definition). Instead, you’ll need to actually compile these files with the
// Scala compiler, then run the resulting class files. One way to do this is to use scalac,
// which is the basic Scala compiler, like this:
//   $ scalac ChecksumAccumulator.scala Summer.scala
// This compiles your source files, but there may be a perceptible delay before the compilation
// finishes. The reason is that every time the compiler starts up, it spends time scanning the
// contents of jar files and doing other initial work before it even looks at the fresh source
// files you submit to it. For this reason, the Scala distribution also includes a Scala compiler
// daemon called fsc (for fast Scala compiler). You use it like this:
//   $ fsc ChecksumAccumulator.scala Summer.scala
// The first time you run fsc, it will create a local server daemon attached to a port on your
// computer. It will then send the list of files to compile to the daemon via the port, and
// the daemon will compile the files. The next time you run fsc, the daemon will already be running,
// so fsc will simply send the file list to the daemon, which will immediately compile the files.
// Using fsc, you only need to wait for the Java runtime to startup the first time. If you ever
// want to stop the fsc daemon, you can do so with fsc -shutdown.
//
// Running either of these scalac or fsc commands will produce Java class files that you can then
// run via the scala command, the same command you used to invoke the interpreter in previous
// examples. However, instead of giving it a filename with a .scala extension containing Scala code
// to interpret as you did in every previous example,6 in this case you’ll give it the name of a
// standalone object containing a main method of the proper signature. You can run the Summer
// application, therefore, by typing:
//   $ scala Summer of love
//
// The actual mechanism that the scala program uses to “interpret” a Scala source file is that it
// compiles the Scala source code to Java bytecodes, loads them immediately via a class loader,
// and executes them.