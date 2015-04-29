import org.scalatest.FunSuite

/**
 * Created by twer on 4/29/15.
 */
class FunctionalClassRational extends FunSuite{
  test("the toString method is overridden correctly") {
    val oneThird = new Rational(1, 3)

    assert("1/3" === oneThird.toString)
  }

  test("the denominator should not be zero") {
    intercept[IllegalArgumentException] {
      val oneZero = new Rational(1, 0)
    }
  }

  test("the rational addition should work") {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)

    val sum = oneHalf add twoThirds

    assert("7/6" === sum.toString)
  }


  test("the rational less than should work") {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    assert(oneHalf lessThan twoThirds)
  }
}

class Rational(n: Int, d: Int) {

  require(d != 0)
  val numer = n
  val denom = d
  override def toString = n + "/" + d
  def add(that: Rational) = new Rational(this.numer * that.denom + this.denom * that.numer
    , this.denom * that.denom)
}