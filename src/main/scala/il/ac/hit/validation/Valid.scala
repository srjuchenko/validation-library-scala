/*
Sergey Juchenko - 319365102
Viktor Rokytko - 336484951
 */

package il.ac.hit.validation

/**
 * The Valid class represents a validation result that indicates validity.
 * It is used to signify that a validation operation has succeeded.
 */
class Valid extends ValidationResult { // ask Haim about the primary constructor and reason
  /**
   * Checks if the validation result is valid.
   *
   * @return Always returns `true` to indicate validity.
   */
  override def isValid: Boolean = true

  /**
   * Retrieves an optional reason for the validation result.
   *
   * @return Always returns `None` since there is no specific reason for a successful validation.
   */
  override def getReason: Option[String] = None

  /**
   * Converts the Valid instance to a human-readable string representation.
   *
   * @return A string containing the validity status and reason of the validation.
   */
  override def toString = s"Valid(isValid = $isValid, getReason = $getReason)"
}
