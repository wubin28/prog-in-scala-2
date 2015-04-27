package scalaApplication
import ChecksumAccumulator.calculate
/**
 * Created by twer on 4/27/15.
 */
object FallWinterSpringSummer extends App{
  for (season <- List("fall", "winter", "spring"))
    println(season +": "+ calculate(season))
}
