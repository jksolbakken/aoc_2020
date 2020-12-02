package day1

import java.io.File

const val desiredSum = 2020

fun main() {
   with(bruteforceDouble() ?: Pair(0, 0)) {
      println("$first * $second = ${first * second}")
   }

   with(bruteforceTriple() ?: Triple(0, 0, 0)) {
      println("$first * $second * $third = ${first * second * third}")
   }
}

val input = File(object {}.javaClass.getResource("/day1/input.txt").toURI())
   .readLines().filter { it.isNotEmpty() }.map { it.toInt() }.filter { it <= desiredSum }

fun bruteforceDouble(): Pair<Int, Int>? {
   for (i in input.indices) {
      for (j in input.indices) {
         if (i == j) continue
         if (input[i] + input[j] == desiredSum) return Pair(input[i], input[j])
      }
   }
   return null
}

fun bruteforceTriple(): Triple<Int, Int, Int>? {
   for (i in input.indices) {
      for (j in input.indices) {
         for (k in input.indices) {
            if (i == j || i == k || j == k) continue
            if (input[i] + input[j] + input[k] == desiredSum) return Triple(input[i], input[j], input[k])
         }
      }
   }
   return null
}
