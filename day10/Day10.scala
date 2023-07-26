import scala.io.Source

object Day10 extends App {
    val lines = Source.fromFile("input10.txt").getLines().toList

    var X = 1
    var cycle = -1
    var signalStrength = Array[Int]()
    var CRT = ""
    var sprite = "###....................................."

    for line <- lines do
        var repeat = true
        var went = true
        var amount = 0
        while repeat do
            cycle += 1
            if cycle != 0 && (cycle % 40 == 0) then
                CRT = CRT + "\n"
            CRT = CRT + sprite(cycle % 40)
            if ((cycle + 1) - 20) % 40 == 0 then
                signalStrength = signalStrength :+ (cycle + 1) * X
            if line != "noop" && went then
                amount = line.split(" ")(1).toInt
                went = false
            else
                if !went then
                    X += amount
                    sprite = ("." * (X - 1)) ++ "###" ++ ("." * (40 - X + 1 - 3))
                repeat = false

    println(signalStrength.sum)
    println(CRT)
}
