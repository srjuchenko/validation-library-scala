/*
Sergey Juchenko - 319365102
Viktor Rokytko - 336484951
 */
package il.ac.hit.validation

/**
 * The Utils object provides helper functions and some constants for common validation tasks.
 */
object Utils {
  val MINIMUM_AGE = 12
  val DEFAULT_USERNAME = "Default Username"
  val DEFAULT_EMAIL = "default@default.com"
  val DEFAULT_PASSWORD = "123456"

  /**
   * Checks if a string contains only letters and numbers.
   *
   * @param str The string to be checked.
   * @return `true` if the string contains only letters and numbers, otherwise `false`.
   */
  def isIncludesLettersAndNumbersOnly(str: String): Boolean = {
    if (str.matches("[a-zA-Z0-9]+")) true
    else false
  }

  /**
   * Checks if the length of a string is greater than a specified length.
   *
   * @param str The string to be checked.
   * @param length The minimum length to compare against.
   * @return `true` if the string length is greater than the specified length, otherwise `false`.
   */
  def isStrLengthBiggerThan(str: String, length: Int): Boolean = {
    if (str.length > length) true
    else false
  }

  /**
   * Checks if a string ends with a specific suffix.
   *
   * @param str The string to be checked.
   * @param suffix The suffix to compare against.
   * @return `true` if the string ends with the specified suffix, otherwise `false`.
   */
  def isStrEndsWithSuffix(str: String, suffix: String): Boolean = {
    if (str.endsWith(suffix)) true
    else false
  }

  /**
   * Checks if a string contains a specific character.
   *
   * @param str The string to be checked.
   * @param sign The character to search for.
   * @return `true` if the string contains the specified character, otherwise `false`.
   */
  def isStrIncludesSign(str: String, sign: Char): Boolean = {
    if (str.contains(sign)) true
    else false
  }

  /**
   * Checks if two strings are different after trimming leading and trailing whitespace.
   *
   * @param str1 The first string.
   * @param str2 The second string.
   * @return `true` if the trimmed strings are different, otherwise `false`.
   */
  def isDifferentStrings(str1: String, str2: String): Boolean = {
    if (str1.trim != str2.trim) true
    else false
  }

  /**
   * Checks if a number is greater than a specified limit.
   *
   * @param num The number to be checked.
   * @param limit The limit to compare against.
   * @return `true` if the number is greater than the specified limit, otherwise `false`.
   */
  def isBiggerThanLimit(num: Int, limit: Int): Boolean = {
    if (num > limit) true
    else false
  }

  /**
   * Checks if all items in an array are equal to a specific boolean value.
   *
   * @param arr The array of booleans to be checked.
   * @param boolean The boolean value to compare against.
   * @return `true` if all items in the array are equal to the specified boolean, otherwise `false`.
   */
  def isAllItemsEqualToBoolean(arr: Array[Boolean], boolean: Boolean): Boolean = {
    println(arr.mkString(","))
    arr.forall(_ == boolean)
  }
}
