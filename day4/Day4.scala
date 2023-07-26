import scala.io.Source

object Day4 extends App {
    val lines = Source.fromFile("day4.txt").getLines().toList

    var part1 = 0
    var part2 = 0
    for line <- lines do
        val arr = line.split(",")
        val (elf1, elf2) = (arr(0), arr(1))
        val elf1arr = elf1.split("-")
        val (elf1s1, elf1s2) = (elf1arr(0).toInt, elf1arr(1).toInt)
        
        val elf2arr = elf2.split("-")
        val (elf2s1, elf2s2) = (elf2arr(0).toInt, elf2arr(1).toInt)
        if ( (elf1s1 <= elf2s1 && elf1s2 >= elf2s2) || (elf1s1 >= elf2s1 && elf1s2 <= elf2s2) ) then
            part1 += 1
        if ( (elf1s1 <= elf2s1 && elf1s2 >= elf2s1) || (elf1s1 <= elf2s2 && elf1s2 >= elf2s2)
            || (elf2s1 <= elf1s1 && elf2s2 >= elf1s1) || (elf2s1 <= elf1s2 && elf2s2 >= elf1s2) ) then
            //println(line)
            part2 += 1
    
    println(part1)
    println(part2)
}