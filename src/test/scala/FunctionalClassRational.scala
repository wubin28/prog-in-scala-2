import org.scalatest.FunSuite

/**
 * Created by twer on 4/29/15.
 */
class FunctionalClassRational extends FunSuite{
  test("the toString method is overridden correctly") {
    var oneThird = new Rational(1, 3)

    assert("1/3" === oneThird.toString)
  }

  test("the denominator should not be zero") {
    intercept[IllegalArgumentException] {
      var oneZero = new Rational(1, 0)
    }
  }
}

class Rational(n: Int, d: Int) {
  require(d != 0)
  override def toString = n + "/" + d
}