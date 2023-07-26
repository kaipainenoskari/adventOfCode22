import scala.io.Source

object Go extends App {
    val lines = Source.fromFile("day2.txt").getLines().toList

    val games = lines.map(l => (l(0), l(2)))

    /*
    A == Rock
    B == Paper
    C == Scissors

    X == Rock
    Y == Paper
    Z == Scissors

    X == Lose
    Y == Draw
    Z == Win
    */

    def points(opp: Char, me: Char): Int =
        if opp == 'A' then
            if me == 'X' then
                return 1 + 3
            if me == 'Y' then
                return 2 + 6
            //if me == 'Z' then
            return 3 + 0
        if opp == 'B' then
            if me == 'X' then
                return 1 + 0
            if me == 'Y' then
                return 2 + 3
            if me == 'Z' then
                return 3 + 6
        //if opp == 'C' then
        if me == 'X' then
            return 1 + 6
        if me == 'Y' then
            return 2 + 0
        //if me == 'Z' then
        return 3 + 3

    def getWhatToPlay(opp: Char, winLose: Char): Char =
        if opp == 'A' then
            if winLose == 'X' then
                return 'Z'
            if winLose == 'Y' then
                return 'X'
            return 'Y'
        if opp == 'B' then
            if winLose == 'X' then
                return 'X'
            if winLose == 'Y' then
                return 'Y'
            return 'Z'
        if winLose == 'X' then
            return 'Y'
        if winLose == 'Y' then
            return 'Z'
        return 'X'

    val part1 = games.map((opp, me) => points(opp, me)).sum
    val part2 = games.map((opp, me) => points(opp, getWhatToPlay(opp, me))).sum

    println(part1)
    println(part2)
}