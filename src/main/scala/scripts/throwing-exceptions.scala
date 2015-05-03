/**
 * Created by twer on 5/3/15.
 */

val n = 5
val half =
  if (n % 2 == 0)
    n/2 else
    throw new RuntimeException("n must be even")
println("half: " + half)
