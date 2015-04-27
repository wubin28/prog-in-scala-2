import scala.collection.mutable.Map
/**
 * Created by twer on 4/27/15.
 */

class ChecksumAccumulator {
  private var sum = 0
  // Another way to express such methods is to leave off the result type and the equals sign, and
  // enclose the body of the method in curly braces. In this form, the method looks like a procedure,
  // a method that is executed only for its side effects.
  //def add(b: Byte): Unit = sum += b
  def add(b: Byte) { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

// As mentioned in Chapter 1, one way in which Scala is more object-oriented than Java is that
// classes in Scala cannot have static members. Instead, Scala has singleton objects. A singleton object
// definition looks like a class defi- nition, except instead of the keyword class you use the
// keyword object.
//
// When a singleton object shares the same name with a class, it is called that class’s companion
// object. You must define both the class and its companion object in the same source file.
// The class is called the companion class of the singleton object. A class and its companion
// object can access each other’s private members.
//
// We used a cache here to show a singleton object with a field. A cache such as this is a
// performance optimization that trades off memory for computation time. In general, you would
// likely use such a cache only if you encountered a performance problem that the cache solves,
// and might use a weak map, such as WeakHashMap in scala.collection.jcl, so that entries in the
// cache could be garbage collected if memory becomes scarce.
object ChecksumAccumulator {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      // The last expression of the method, cs, ensures the checksum is the result of the method.
      cs
    }
}

// If you are a Java programmer, one way to think of singleton objects is as the home for any
// static methods you might have written in Java. You can invoke methods on singleton objects
// using a similar syntax: the name of the singleton object, a dot, and the name of the method.
// A singleton object is more than a holder of static methods, however. It is a first-class
// object. You can think of a singleton object’s name, therefore, as a “name tag” attached to the object.
println("The checksum is " + ChecksumAccumulator.calculate("Ben wu"))
// Defining a singleton object doesn’t define a type (at the Scala level of abstraction). Given
// just a definition of object ChecksumAccumulator, you can’t make a variable of type
// ChecksumAccumulator. Rather, the type named ChecksumAccumulator is defined by the
// singleton object’s com- panion class. However, singleton objects extend a superclass and can
// mix in traits. Given each singleton object is an instance of its superclasses and mixed-in
// traits, you can invoke its methods via these types, refer to it from variables of these types,
// and pass it to methods expecting these types. We’ll show some examples of singleton objects
// inheriting from classes and traits in Chapter 13.
//
// One difference between classes and singleton objects is that singleton objects cannot take
// parameters, whereas classes can. Because you can’t in- stantiate a singleton object with the
// new keyword, you have no way to pass parameters to it. Each singleton object is implemented
// as an instance of a synthetic class referenced from a static variable, so they have the
// same initialization semantics as Java statics.4 In particular, a singleton object is initialized
// the first time some code accesses it.
//
// A singleton object that does not share the same name with a companion class is called a
// standalone object. You can use standalone objects for many purposes, including collecting related
// utility methods together, or defining an entry point to a Scala application. This use case is
// shown in the next section.
