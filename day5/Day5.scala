import scala.io.Source

object Day5 extends App {
    val lines = Source.fromFile("day5.txt").getLines().toList

    val stacks = Array.fill(9)(Array[Char]())

    var setUp = true

    for line <- lines do
        if line == " 1   2   3   4   5   6   7   8   9 " then setUp = false
        //if line == " 1   2   3 " then setUp = false
        else if setUp then
            var l = line
            var s = 0
            while !l.isEmpty do
                val crate = l.take(4).trim()
                //println(crate)
                if crate != "" then
                    stacks(s) = stacks(s) :+ l(1)
                l = l.drop(4)
                s += 1
        else if line.trim() != "" then
            //println("stack: ")
            //stacks.foreach(l => println(l.toList))
            val ins = line.split(" ")
            val (amount, from, to) = (ins(1).toInt, ins(3).toInt - 1, ins(5).toInt - 1)
            // Part 1
            //stacks(to) = stacks(from).take(amount).reverse ++ stacks(to)
            // Part 2
            stacks(to) = stacks(from).take(amount) ++ stacks(to)
            stacks(from) = stacks(from).drop(amount)
    //stacks.foreach(l => println(l.toList))
    stacks.foreach(l => print(l(0)))
}