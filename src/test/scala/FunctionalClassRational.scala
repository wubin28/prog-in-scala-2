import org.scalatest.FunSuite

/**
 * Created by twer on 4/29/15.
 */
class FunctionalClassRational extends FunSuite{
  test("the toString method is overridden correctly")

  var oneThird = new Rational(1, 3)

  assert("1/3" === oneThird)
}
