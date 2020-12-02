package day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {

   val testdata = listOf(
      "1-3 a: abcde",
      "1-3 b: cdefg",
      "2-9 c: ccccccccc",
   )

   @Test
   fun `matching nr of a single char`() {
      assertEquals(2, matchingNrOfChars(testdata))
   }

   @Test
   fun `matching char position`() {
      assertEquals(1, matchingPosition(testdata))
   }

}
