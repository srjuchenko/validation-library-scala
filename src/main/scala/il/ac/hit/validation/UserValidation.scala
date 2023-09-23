/*
Sergey Juchenko - 319365102
Viktor Rokytko - 336484951
 */

package il.ac.hit.validation

/**
 * The UserValidation trait defines validation logic that can be applied to a User instance.
 */
trait UserValidation extends Function1[User, ValidationResult] {
  /**
   * Checks whether two different conditions are fulfilled.
   *
   * @param other The other validation to compose with.
   * @return A new UserValidation representing the AND composition of the two validations.
   */
  def and(other: UserValidation): UserValidation = user => {
    val thisResult = this(user)
    // Checks if both of the conditions are valid
    if (thisResult.isValid) other(user)
    else thisResult
  }

  /**
   * Checks whether at least one of two different conditions is fulfilled.
   *
   * @param other The other validation to compose with.
   * @return A new UserValidation representing the OR composition of the two validations.
   */
  def or(other: UserValidation): UserValidation = user => {
    val thisResult = this(user)
    // Checks if one of the conditions are valid
    if (thisResult.isValid) thisResult
    else other(user)
  }
}

/**
 * The UserValidation object provides various validation methods for users.
 */
object UserValidation {
  /**
   * checks whether all supplied conditions are fulfilled.
   *
   * @param validations The validation conditions .
   * @return A UserValidation representing the combined validation.
   */
  def all(validations: UserValidation*): UserValidation = user =>
    /*
    The function takes a variable number of user validations as repeated parameters.
    It then applies each validation to the user and extracts a boolean value from the validation result.
    Subsequently, it checks whether the array contains only true values,
    indicating that all validations have passed successfully.
     */
    createValidationResult(
      Utils.isAllItemsEqualToBoolean(
        validations.map(
          validation => validation.apply(user).isValid).toArray,
        boolean = true
      ),
      "Not all validations are valid"
    )

  /**
   * checks whether none of the supplied conditions is fulfilled.
   *
   * @param validations The validation conditions.
   * @return A UserValidation representing the combined validation.
   */
  def none(validations: UserValidation*): UserValidation = user =>
    /*
    The function accepts a variable number of user validations as repeated parameters.
    It proceeds to apply each validation to the user and extract boolean values from the validation results.
    Afterwards, it verifies whether the array consists entirely of false values,
    signifying that none of the validations are valid.
    */
    createValidationResult(
      Utils.isAllItemsEqualToBoolean(
        validations.map(
          validation => validation.apply(user).isValid).toArray,
        boolean = false
      ),
      "Some of the validations are valid"
    )

  /**
   * Validates that the email address ends with "il".
   *
   * @return A UserValidation representing the email validation.
   */
  def emailEndsWithIL: UserValidation = user =>
    createValidationResult(Utils.isStrEndsWithSuffix(user.emailProp, "il"),
      "Email must end with 'il'")

  /**
   * Validates that the length of the email address is bigger than 10.
   *
   * @return A UserValidation representing the email length validation.
   */
  def emailLengthBiggerThan10: UserValidation = user =>
    createValidationResult(Utils.isStrLengthBiggerThan(user.emailProp, 10),
      "Email length must be bigger than 10")

  /**
   * Validates that the length of the password is bigger than 8.
   *
   * @return A UserValidation representing the password length validation.
   */
  def passwordLengthBiggerThan8: UserValidation = user =>
    createValidationResult(Utils.isStrLengthBiggerThan(user.passwordProp, 8),
      "Password length must be bigger than 8")

  /**
   * Validates that the password includes only letters and numbers.
   *
   * @return A UserValidation representing the password format validation.
   */
  def passwordIncludesLettersNumbersOnly: UserValidation = user =>
    createValidationResult(Utils.isIncludesLettersAndNumbersOnly(user.passwordProp),
      "Password must include letters and numbers only")

  /**
   * Validates that the password includes the $ character.
   *
   * @return A UserValidation representing the password character validation.
   */
  def passwordIncludesDollarSign: UserValidation = user =>
    createValidationResult(Utils.isStrIncludesSign(user.passwordProp, '$'),
      "Password must include the $ character")

  /**
   * Validates that the password is different from the username.
   *
   * @return A UserValidation representing the password uniqueness validation.
   */
  def passwordIsDifferentFromUsername: UserValidation = user =>
    createValidationResult(Utils.isDifferentStrings(user.usernameProp, user.passwordProp),
      "Password must be different from the username")


  /**
   * Validates that the age is bigger than 18.
   *
   * @return A UserValidation representing the age validation.
   */
  def ageBiggerThan18: UserValidation = user =>
    createValidationResult(Utils.isBiggerThanLimit(user.ageProp, 18),
      "Age must be bigger than 18")


  /**
   * Validates that the length of the username is bigger than 8.
   *
   * @return A UserValidation representing the username length validation.
   */
  def usernameLengthBiggerThan8: UserValidation = user =>
    createValidationResult(Utils.isStrLengthBiggerThan(user.usernameProp, 8),
      "Username length must be bigger than 8")


  /**
   * Creates a ValidationResult based on the provided validation result and reason for failure.
   *
   * @param isValid         The result of the validation.
   * @param reasonOnFailure The reason for validation failure.
   * @return A ValidationResult object representing the validation result.
   */
  private def createValidationResult(isValid: Boolean, reasonOnFailure: String): ValidationResult = {
    if (isValid) new Valid else new Invalid(reasonOnFailure)
  }
}
