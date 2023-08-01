import scala.io.Source

object Day8 extends App {
    val lines = Source.fromFile("day8input.txt").getLines().toList.map(line => line.map(c => c.toInt).toList)
    var visible = (lines.length + (lines.head.length - 2)) * 2
    var scenicMax = 0

    var i = 1
    var j = 1
    while i < lines.length - 1 do
        while j < lines.head.length - 1 do
            val current = lines(i)(j)
            var c = i - 1
            var r = j - 1
            var scenicTop = 1
            var visibleTop = true
            // Check top
            while visibleTop && c >= 1 do
                if current > lines(c)(j) then
                    scenicTop += 1
                else
                    visibleTop = false
                c -= 1
            c = i + 1
            var scenicBottom = 1
            var visibleBottom = true
            // Check bottom
            while visibleBottom && c < lines.length - 1 do
                if current > lines(c)(j) then
                    scenicBottom += 1
                else
                    visibleBottom = false
                c += 1
            var scenicLeft = 1
            var visibleLeft = true
            // Check left
            while visibleLeft && r >= 1 do
                if current > lines(i)(r) then
                    scenicLeft += 1
                else
                    visibleLeft = false
                r -= 1
            var scenicRight = 1
            var visibleRight = true
            r = j + 1
            // Check right
            while visibleRight && r < lines.head.length - 1 do
                if current > lines(i)(r) then
                    scenicRight += 1
                else
                    visibleRight = false
                r += 1

            if visibleTop || visibleBottom || visibleLeft ||visibleRight then
                visible += 1
            
            val scenicCurrent = scenicTop * scenicBottom * scenicRight * scenicLeft
            if scenicCurrent > scenicMax then
                scenicMax = scenicCurrent
            j += 1
        i += 1
        j = 1
    
    println(visible)
    println(scenicMax)
}
