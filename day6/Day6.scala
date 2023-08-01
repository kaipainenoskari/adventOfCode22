import scala.io.Source

object Day6 extends App {
    var datastream: String = Source.fromFile("day6input.txt").getLines().toList(0)
    // size = 4 for part 1, size = 14 for part 2
    val size = 14
    var i = size
    var ans = 0

    while datastream.length >= size && ans == 0 do
        val four = datastream.take(size)
        if four.toSet.size == size then
            ans = i
        else
            i += 1
            datastream = datastream.drop(1)
    println(ans)
}
