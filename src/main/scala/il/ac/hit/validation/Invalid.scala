/*
Sergey Juchenko - 319365102
Viktor Rokytko - 336484951
 */
package il.ac.hit.validation

/**
 * The Invalid class represents a validation result that indicates invalidity.
 * It is used to signify that a validation operation has failed.
 *
 * @param reason The reason for the validation failure.
 */
class Invalid(private[this] var reason: String) extends ValidationResult {
  reasonProp = reason

  /**
   * Get the reason property.
   */
  def reasonProp: String = reason

  /**
   * Set the reason property with a fallback to "something went wrong" if the provided reason is empty.
   *
   * @param reason The new reason to set.
   */
  def reasonProp_=(reason: String): Unit = {
    if (reason == null || reason.trim.isEmpty) {
      this.reason = "something went wrong"
    } else {
      this.reason = reason
    }
  }

  /**
   * Checks if the validation result is valid.
   *
   * @return Always returns `false` to indicate invalidity.
   */
  override def isValid: Boolean = false

  /**
   * Retrieves an optional reason for the validation result.
   *
   * @return An optional reason string explaining the validation failure.
   */
  override def getReason: Option[String] = Some(reasonProp)

  /**
   * Converts the Invalid instance to a human-readable string representation.
   *
   * @return A string containing the validity status and reason of the validation.
   */
  override def toString = s"Invalid(isValid = $isValid, getReason = $getReason)"
}
