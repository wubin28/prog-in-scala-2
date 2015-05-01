import org.scalatest.FunSuite

/**
 * Created by twer on 4/29/15.
 */
class FunctionalClassRational extends FunSuite{
  test("the toString method is overridden correctly") {
    val x = new Rational(1, 3)

    assert("1/3" === x.toString)
  }

  test("the denominator should not be zero") {
    intercept[IllegalArgumentException] {
      val x = new Rational(1, 0)
    }
  }

  test("the rational addition should work") {
    val x = new Rational(1, 2)
    val y = new Rational(2, 3)

    assert("7/6" === (x + y).toString)
  }

  test("the rational less than should work") {
    val x = new Rational(1, 2)
    val y = new Rational(2, 3)

    assert(x < y)
  }

  test("the rational max should work") {
    val x = new Rational(2, 3)
    val y = new Rational(1, 2)

    assert(x === (y max x))
  }

  test("the auxiliary constructor should work") {
    val x = new Rational(3)

    assert("3/1" === x.toString)
  }

  test("the primary constructor should normalize the rational") {
    val x = new Rational(66, 42)

    assert("11/7" === x.toString)
  }

  test("the rational multiplication should work") {
    val x = new Rational(1, 2)
    val y = new Rational(2, 3)

    assert("1/3" === (x * y).toString)
  }

  test("the formula with addition and multiplication should work") {
    val x = new Rational(1, 2)
    val y = new Rational(2, 3)

    assert("5/6" === (x + x * y).toString)
    assert("2/3" === ((x + x) * y).toString)
    assert("5/6" === (x + (x * y)).toString)
  }

  test("multiplying a rational number by an integer should work") {
    val x = new Rational(2, 3)
    assert("4/3" === (x * 2).toString)
  }

  test("adding a rational number by an integer should work") {
    val x = new Rational(2, 3)
    assert("8/3" === (x + 2).toString)
  }

  test("the rational subtraction should work") {
    val x = new Rational(2, 3)
    val y = new Rational(1, 2)
    assert("1/6" === (x - y).toString)
  }

  test("subtracting a rational number by an integer should work") {
    val x = new Rational(8, 3)
    assert("2/3" === (x - 2).toString)
  }

  test("the rational division should work") {
    val x = new Rational(2, 3)
    val y = new Rational(1, 2)
    assert("4/3" === (x / y).toString)
  }
}

class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g
  def this(n: Int) = this(n, 1)
  override def toString = numer + "/" + denom
  def +(that: Rational): Rational = new Rational(
    this.numer * that.denom + this.denom * that.numer, this.denom * that.denom)
  def +(that: Int): Rational = new Rational(
    this.numer + this.denom * that, this.denom)
  def -(that: Rational) = new Rational(
    this.numer * that.denom - that.numer * this.denom, this.denom * that.denom
  )
  def -(that: Int) = new Rational(
    this.numer - that * this.denom, this.denom
  )
  def *(that: Rational): Rational = new Rational(this.numer * that.numer, this.denom * that.denom)
  def *(that: Int): Rational = new Rational(this.numer * that, this.denom)
  def /(that: Rational) = new Rational(this.numer * that.denom, this.denom * that.numer)
  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom
  def max(that: Rational) = if (this < that) that else this
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}