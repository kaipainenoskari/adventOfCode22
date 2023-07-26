import scala.io.Source

object Day1 extends App {
    val lines = Source.fromFile("input1.txt").mkString
        
    val elves = lines.split("\n\n")
    .map(e => e.split("\n"))
    .map(l => l.map(_.toInt))
    .map(_.sum).sorted.reverse

    // Part 1
    println(elves.max)
    // Part 2
    println(elves.take(3).sum)
}