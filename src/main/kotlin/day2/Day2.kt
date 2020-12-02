package day2

import java.io.File

fun main() {
   val input = File(object {}.javaClass.getResource("/day2/input.txt").toURI()).readLines()
   println("char count: ${matchingNrOfChars(input)}")
   println("char position: ${matchingPosition(input)}")
}

fun matchingNrOfChars(lines: List<String>) = prepare(lines)
   .map { (ruleAsString, password) -> Pair(charCountRule(ruleAsString), password) }
   .count { (rule, password) -> rule(password) }

fun matchingPosition(lines: List<String>) = prepare(lines)
   .map { (ruleAsString, password) -> Pair(charPositionRule(ruleAsString), password) }
   .count { (rule, password) -> rule(password) }

private fun charCountRule(asText: String): (String) -> Boolean =
   asText.split(" ").let { (charCounts, character) ->
      val (min, max) = charCounts.split("-").map { it.toInt() }
      val range = IntRange(min, max)
      val char = character.first()
      return { password ->  password.filter { it == char }.count() in range }
   }

private fun charPositionRule(asText: String): (String) -> Boolean =
   asText.split(" ").let { (positions, character) ->
      val (firstPos, secondPos) = positions.split("-").map { it.toInt() }
      val char = character.first()
      return { password ->
         password.withIndex().count {
            indexMatches(it.index, firstPos, secondPos) && it.value == char
         } == 1
      }
   }

private fun prepare(input: List<String>) =
   input.filter { it.isNotEmpty() }.map { it.split(": ") }

private fun indexMatches(actualIndex: Int, vararg desiredIndices: Int) =
   actualIndex + 1 in desiredIndices





