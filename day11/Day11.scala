import scala.io.Source

object Day11 extends App {
    val lines = Source.fromFile("input11.txt").getLines().toList

    val rounds = 20

    val monkeys = lines.filter(line => line.contains("Monkey")).length

    val items = Array.fill(monkeys)(Array[Int]())

    val operations = Array[String]()

    println(monkeys)
}
