class FizzBuzz {

    fun convert(n: Int): String {
        if (isFizz(n) && isBuzz(n)) {
            return "FizzBuzz"
        } else if (isFizz(n)) {
            return "Fizz"
        } else if (isBuzz(n)) {
            return "Buzz"
        }
        return n.toString()
    }

    private fun isBuzz(n: Int): Boolean {
        return n % 5 == 0
    }

    private fun isFizz(n: Int): Boolean {
        return n % 3 == 0
    }
}