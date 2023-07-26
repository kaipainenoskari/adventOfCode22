import scala.io.Source

object Day3 extends App {
    def priority(c: Char): Int =
        val ret = c.toInt - 'a' + 1
        if ret < 0 then return c.toInt - 'A' + 27 else ret

    val lines = Source.fromFile("day3.txt").getLines().toList

    var (elf1, elf2, elf3) = ("", "", "")

    var part1 = 0
    var part2 = 0
    var i = 0
    for line <- lines do
        val r = i % 3
        if r == 0 then
            elf1 = line
        else if r == 1 then
            elf2 = line
        else
            elf3 = line
            part2 += priority(elf1.filter(c => elf2.contains(c)).filter(c => elf3.contains(c)).max)
        i += 1
        val (s1, s2) = line.splitAt(line.length / 2)
        part1 += priority(s1.filter(c => s2.contains(c)).max)
    println(part1)
    println(part2)
}
