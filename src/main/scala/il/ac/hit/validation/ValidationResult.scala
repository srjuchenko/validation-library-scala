/*
Sergey Juchenko - 319365102
Viktor Rokytko - 336484951
 */

package il.ac.hit.validation

/**
 * The ValidationResult trait represents the result of a validation operation.
 * It provides information about whether the validation is valid and an optional reason if it's not.
 */
trait ValidationResult {
  /**
   * Checks if the validation result is valid.
   *
   * @return `true` if the validation is valid, otherwise `false`.
   */
  def isValid: Boolean

  /**
   * Retrieves an optional reason for the validation result.
   *
   * @return An optional reason string if the validation is not valid, otherwise `None`.
   */
  def getReason: Option[String]
}
