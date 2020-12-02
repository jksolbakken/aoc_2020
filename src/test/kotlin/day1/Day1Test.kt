package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {

   @Test
   fun `two numbers`() {
      val (first, second) = bruteforceDouble() ?: Pair(0, 0)
      assertEquals(desiredSum, first + second)
   }

   @Test
   fun `three numbers`() {
      val (first, second, third) = bruteforceTriple() ?: Triple(0, 0, 0)
      assertEquals(desiredSum, first + second + third)
   }

}
