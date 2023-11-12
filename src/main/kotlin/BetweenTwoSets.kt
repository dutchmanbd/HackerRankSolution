import kotlin.math.abs

class BetweenTwoSets {

    fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
        var result = 0
        var lcm = a.first()
        for (n in a) {
            lcm = getLCM(lcm, n)
        }
        var gcd = b.first()
        for (n in b) {
            gcd = getGCD(gcd, n)
        }
        var multiple = 0
        while (multiple <= gcd) {
            multiple += lcm
            if (gcd % multiple == 0) {
                result++
            }
        }
        return result
    }

    private fun getLCM(n1: Int, n2: Int): Int {
        return if (n1 == 0 || n2 == 0) {
            0
        } else {
            val gcd = getGCD(n1, n2)
            abs(n1 * n2) / gcd
        }

    }

    private fun getGCD(n1: Int, n2: Int): Int {
        if (n2 == 0)
            return n1
        return getGCD(n2, n1 % n2)
    }
}