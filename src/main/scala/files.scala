import scala.io.Source

/**
 * Created by twer on 4/26/15.
 */
if (args.length <= 0) {
  Console.err.println("Please enter filename");
  System.exit(1);
};

//for (line <- Source.fromFile(args(0)).getLines()) {
//  println(line.length +" "+ line);
//}



// The final toList is required because the getLines method returns
// an itera- tor. Once you’ve iterated through an iterator, it is
// spent. By transforming it into a list via the toList call, you
// gain the ability to iterate as many times as you wish, at the cost
// of storing all lines from the file in memory at once.
val lines = Source.fromFile(args(0)).getLines().toList

// The reduceLeft method applies the passed function to the first
// two elements in lines, then applies it to the result of the first
// application and the next element in lines, and so on, all the
// way through the list.
val longestLine = lines.reduceLeft((a,b) => if (a.length > b.length) a else b)

def widthOfLength(s: String) = s.length.toString.length

val maxWidth = widthOfLength(longestLine);

for (line <- lines) {
  val numSpaces = maxWidth - widthOfLength(line);
  val padding = " " * numSpaces;
  println(padding + line.length + " | " + line);
};
