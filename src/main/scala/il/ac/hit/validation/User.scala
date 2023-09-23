/*
Sergey Juchenko - 319365102
Viktor Rokytko - 336484951
 */

package il.ac.hit.validation

/**
 * Represents a user with username, email, password, and age.
 *
 * @param username The username of the user.
 * @param email The email address of the user.
 * @param password The password of the user.
 * @param age The age of the user.
 */
class User(private[this] var username: String,
           private[this] var email: String,
           private[this] var password: String,
           private[this] var age: Int
          ) {

  usernameProp = username
  emailProp = email
  passwordProp = password
  ageProp = age

  /**
   * Get the username property.
   */
  def usernameProp: String = username

  /**
   * Set the username property with a fallback to DEFAULT_USERNAME from Utils object if the provided username is empty.
   *
   * @param username The new username to set.
   */
  def usernameProp_=(username: String): Unit = {
    if (username == null || username.trim.isEmpty) {
      println("warning: username was empty, using default value")
      this.username = Utils.DEFAULT_USERNAME
    } else {
      this.username = username
    }
  }

  /**
   * Get the email property.
   */
  def emailProp: String = email

  /**
   * Set the email property with a fallback to DEFAULT_EMAIL from Utils object if the provided email is empty.
   *
   * @param email The new email to set.
   */
  def emailProp_=(email: String): Unit = {
    if (email == null || email.trim.isEmpty) {
      println("warning: email was empty, using default value")
      this.email = Utils.DEFAULT_EMAIL
    } else {
      this.email = email
    }
  }

  /**
   * Get the password property.
   */
  def passwordProp: String = password

  /**
   * Set the password property with a fallback to DEFAULT_PASSWORD from Utils object if the provided password is empty.
   *
   * @param password The new password to set.
   */
  def passwordProp_=(password: String): Unit = {
    if (password == null || password.trim.isEmpty) {
      println("warning: password was empty, using default value")
      this.password = Utils.DEFAULT_PASSWORD
    } else {
      this.password = password
    }
  }

  /**
   * Get the age property.
   */
  def ageProp: Int = age

  /**
   * Set the age property, ensuring that it is not negative (minimum age is MINIMUM_AGE from Utils object).
   *
   * @param age The new age to set.
   */
  def ageProp_=(age: Int): Unit = {
    if (age < 0) {
      println("warning: age was negative, using default value")
      this.age = Utils.MINIMUM_AGE
    } else {
      this.age = age
    }
  }

  /**
   * Converts the User instance to a human-readable string representation.
   *
   * @return A string containing the user's information.
   */
  override def toString = s"User(username = $usernameProp, email = $emailProp, password = $passwordProp, age = $ageProp)"
}

