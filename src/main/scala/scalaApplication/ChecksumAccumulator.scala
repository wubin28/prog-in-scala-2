package scalaApplication

import scala.collection.mutable.Map

/**
 * Created by twer on 4/27/15.
 */
// One difference between Scala and Java is that whereas Java requires you to put a public class
// in a file named after the class—for example, you’d put class SpeedRacer in file
// SpeedRacer.java—in Scala, you can name .scala files anything you want, no matter what Scala classes
// or code you put in them. In general in the case of non-scripts, however, it is recommended style to
// name files after the classes they contain as is done in Java, so that programmers can more easily
// locate classes by looking at file names. This is the approach we’ve taken with the two files in
// this example, Summer.scala and ChecksumAccumulator.scala.
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

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
      cs
    }
}